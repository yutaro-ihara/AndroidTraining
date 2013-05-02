Assignment Report for 2.2
------

以下に、課題の回答を記入してください。

Activity と Fragment
======

### Activity

3. ライフサイクルのコールバックメソッドの呼び出し順
* 起動時
    * create
    * start
    * resume
* back button -> 起動
    * pause
    * stop
    * destroy
    * 再起動
        * create
        * start
        * resume
* home button -> 起動
    * pause
    * stop
    * 再起動
        * restart
        * start
        * resume
* device orientation
    * pause
    * stop
    * destroy
    * create
    * start
    * resume

