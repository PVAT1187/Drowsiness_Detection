# Driver Drowsiness Detection (Android Application)

An Android application that monitors driver facial features (eye movements) in real time to detect potential drowsiness using Google ML Kit. Integrates Firebase and BigQuery for event logging and data analysis.

---

## Design Goals
- Explore real-time computer vision and ML integration on Android
- Practice integrating cloud-based analytics to monitor usage data

---

## Features
- Drowsiness Detection: Analyzes facial landmarks and eye-open probabilities using Google ML Kit's Face Detection API
- Visual Alerts: Displays an on-screen warning when drowsiness is detected
- Analytics: Logs application events through Firebase Analytics and exports data to BigQuery for analysis

---

## Tech Stack
- Programming Language: Kotlin
- Platform: Android SDK
- ML: Google ML Kit Face Detection
- Analytics: Firebase Analytics, BigQuery
- IDE/Tools: Android Studio, GitHub Actions

---

## Setup Instructions
Prerequisites
- Android Studio
- Android SDK 36 or higher
- A physical Android device or emulator
- (Optional) Firebase project and google-services.json (for Firebase features)

Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/PVAT1187/Drowsiness_Detection.git
2. Open the project in Android Studio
3. To enable Firebase features:
   - Obtain your google-services.json file from the Firebase Console
   - Place it in the app/ directory.
4. Build and run the application on your device or emulator

---

## Screenshots
<img width="347" height="704" alt="Screenshot 2025-10-19 000658" src="https://github.com/user-attachments/assets/d842d404-9cb5-4a50-95e5-8728f3ac91d4" />
<img width="215" height="168" alt="Screenshot 2025-10-19 000840" src="https://github.com/user-attachments/assets/8cdb512a-8b50-463c-8dc8-54d588625266" />

---

## Contributors
**Vu Anh Thu Phan** - [GitHub](https://github.com/PVAT1187)
- Integrated Firebase Analytics and data export to BigQuery
- Configured the CI/CD pipeline
  
**Collaborating Developers**  
- Contributed to the core Android application and ML Kit-based drowsiness detection
