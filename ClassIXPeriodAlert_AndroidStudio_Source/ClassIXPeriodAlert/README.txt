CLASS IX PERIOD ALERT – ANDROID SOURCE PROJECT

Purpose
- Android notification + English voice announcement at the start of each scheduled Class IX period.
- Monday to Saturday, using the winter timetable supplied in the conversation.
- AUTO and BFSI are announced as separate student groups with their respective teachers.
- Saturday Period 1 is left blank because the uploaded teacher-wise timetable has no Class IX entry for it.

Timings
P1 10:15, P2 11:00, P3 11:45, P4 12:30, lunch 13:15–13:45,
P5 13:45, P6 14:30, P7 15:15. Periods are 45 minutes.

Important setup
1. Open this folder in Android Studio (Hedgehog or newer recommended).
2. Let Android Studio sync Gradle and install any requested Android SDK Platform 35.
3. Build > Build Bundle(s) / APK(s) > Build APK(s).
4. Transfer app-debug.apk to the Android smartboard and install it.
5. Open the app and tap ENABLE PERIOD ALERTS.
6. Allow notifications and exact alarms when Android asks. Set battery use to Unrestricted / Don't optimize if the smartboard has aggressive battery management.
7. Set media/notification volume to an audible level and connect the smartboard speaker.

Notes
- This is Android Studio source code, not a precompiled APK. An Android SDK/Gradle build environment is required to produce the APK.
- Android versions and smartboard manufacturers differ in exact-alarm and background execution behavior. Test one upcoming period on the actual smartboard before relying on it for school use.
- Voice uses the device's installed English text-to-speech voice. Install an English TTS voice in Android settings if one is missing.
- Abbreviations such as SCL, SCP, KRI, ROB, SRUJANI and JIGYANSA are retained as shown in the uploaded timetable; their expanded subject names were not supplied.
- Teacher/period mapping was read from the uploaded workbook's “Teacher Wise” sheet, not inferred from a class-wise timetable.
