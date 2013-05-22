Practice Report for 3.1
------

実習のレポートを下記に記述してください

デバッグ

1. (実習) 実習プロジェクト`DebugPractice`をビルド・インストールし、起動してから画面が立ち上がるまでのメソッドのプロファイリングを実行し、どのメソッドに時間がかかっているかレポートしてください。

(アプリ起動して、start method profilingを実行後回転させたりした後集計を停めました)
* android/text/StaticLayout.generate  Excl Cpu Time 13.9% calls 7
* adnroid/text/StaticLayout.isIdenographic Excl Cpu Time 10.6%  calls 36154+
    * parent android/text/StaticLayout.generate

前者が後者のを呼び出しているので後者が遅いため前者も遅くなってるように見える。


自動ビルド

2. (実習) 適用したプロジェクトを ant でビルドし、ログを見て、ビルドに必要な手順をレポートしてください。
$ ant debug install

-set-mode-check:
-set-debug-files:
-check-env:
-setup:
-set-debug-mode:
-debug-obfuscation-check:
-pre-build:
-build-setup:
-code-gen:
-pre-compile:
-compile:
-post-compile:
-obfuscate:
-dex:
-crunch:
-package-resources:
-package:
-post-package:
-do-debug:
-post-build:

debug:
install:
