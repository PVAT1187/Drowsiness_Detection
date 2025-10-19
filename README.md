# Driver Drowsiness Detection (Android Application)

A real-time Android application designed to monitor driver drowsiness by analyzing facial features such as eye movements. 

---

## Setup Instructions
Prerequisites
- Android Studio (Arctic Fox or newer)
- Android SDK 36 or higher
- A physical Android device or emulator
- (Optional) Firebase account for analytics and data storage

Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/PVAT1187/Drowsiness_Detection.git
2. Open the project in Android Studio
3. If you wish to enable Firebase features:
- Obtain your google-services.json file from the Firebase Console
- Place it in the app/ directory.
4. Build and run the application on your device or emulator

---

## Usage
<img width="347" height="704" alt="Screenshot 2025-10-19 000658" src="https://github.com/user-attachments/assets/d842d404-9cb5-4a50-95e5-8728f3ac91d4" />
<img width="215" height="168" alt="Screenshot 2025-10-19 000840" src="https://github.com/user-attachments/assets/8cdb512a-8b50-463c-8dc8-54d588625266" />

---

## Features
- Analyzes real-time facial landmarks and eye-open probabilities using Google ML Kit’s Face Detection API to detect driver drowsiness
- Displays a warning panel on screen when drowsiness is detected
- Firebase Integration for analytics and event logging
- Data Export to BigQuery for large-scale analysis and visualization

---

## Tech Stack
- Programming Language: Kotlin
- Frameworks: Android SDK, Google ML Kit
- Backend/Analytics: Firebase Realtime Database, Firebase Analytics, BigQuery
- Concepts: Computer Vision, Real-Time Processing, Machine Learning Integration, CI/CD
- IDE/Tools: Android Studio, Git, GitHub Actions

---

## Authors
**Vu Anh Thu Phan** - [GitHub](https://github.com/PVAT1187)
- Responsible for Firebase analytics integration, CI/CD pipeline setup, and data export to BigQuery 

**Collaborating Developer**  
- Contributed to Core Android design and ML Kit–based drowsiness detection implementation



