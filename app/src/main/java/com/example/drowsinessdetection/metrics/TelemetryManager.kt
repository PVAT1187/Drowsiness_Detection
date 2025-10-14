package com.example.drowsinessdetection.metrics

import io.opentelemetry.api.GlobalOpenTelemetry
import io.opentelemetry.api.metrics.Meter
import io.opentelemetry.sdk.OpenTelemetrySdk
import io.opentelemetry.sdk.metrics.SdkMeterProvider
import io.opentelemetry.sdk.metrics.export.MetricExporter
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter
import io.opentelemetry.exporter.otlp.http.metrics.OtlpHttpMetricExporter
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

object TelemetryManager {
    private lateinit var meter: Meter

    fun initialize() {
        val exporter: MetricExporter = OtlpHttpMetricExporter.builder()
            .setEndpoint("http://10.0.2.2:4318/v1/metrics")
            .build()

        val reader = PeriodicMetricReader.builder(exporter)
            .setInterval(5.seconds.toJavaDuration())
            .build()

        val meterProvider = SdkMeterProvider.builder()
            .registerMetricReader(reader)
            .build()

        val openTelemetry = OpenTelemetrySdk.builder()
            .setMeterProvider(meterProvider)
            .buildAndRegisterGlobal()

        meter = GlobalOpenTelemetry.getMeter("drowsiness-metrics")
    }

    fun recordDrowsyAlertEvent() {
        val drowsyAlertCounter = meter.counterBuilder("drowsy_alert_events")
            .setDescription("Number of drowsy alerts detected")
            .setUnit("alerts")
            .build()

        drowsyAlertCounter.add(1)
    }
}
