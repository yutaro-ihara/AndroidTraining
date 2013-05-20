package jp.mixi.practice.test.target;

import android.annotation.SuppressLint;
import java.util.Locale;

/**
 * TODO: TestPractice2 の各テストケースをパスするメソッドを書く
 */
public class TestTarget2 {
	
	private final int MAX_LENGTH = 10;
	
    public boolean isValidLength(String string) {
    	if (string == null || (string.length() == 0 || MAX_LENGTH < string.length())) {
    		return false;
    	}
        return true;
    }

    @SuppressLint("DefaultLocale")
	public String formatTextCount(int count, int max) {
        return String.format(Locale.getDefault(), "%d / %d", count, max);
    }
}