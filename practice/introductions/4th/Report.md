Practice Report for 1.4
------

実習のレポートを下記に記述してください

1. (実習)Android SDK 内の、下記の 2 つのディレクトリにあるコマンドを列挙してください。
- tools
* emulator-mips
* hierarchyviewer
* monitor
* ddms
* emulator-x86
* hprof-conv
* monkeyrunner
* dmtracedump
* emulator64-arm
* jobb
* traceview
* android
* draw9patch
* emulator64-mips
* uiautomatorviewer
* ant
* emulator
* emulator64-x86
* lint
* sqlite3
* zipalign
* apkbuilder
* emulator-arm
* etc1tool
* mksdcard

- platform-tools
* adb
* dx
* aapt
* aidl
* dexdump
* fastboot
* llvm-rs-cc

2. (実習)上記のディレクトリにパスを通し、下記のコマンドを実行してください。
* adb devices
List of devices attached
0146B0020901800A         device

* adb shell
% adb shell
shell@android:/ $


3. (実習)adb shellコマンドを使って、Android 内のファイルシステムにアクセスし、下記の項目を確認してください。

* ls /data/data
shell@android:/ $ ls /data/data
opendir failed, Permission denied

* ls /sdcard/Android/data
shell@android:/ $ ls /sdcard/Android/data/jp.mixi/
cache

