package jp.mixi.practice.sqlite;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class BookContentProvider extends ContentProvider {
	
	private static final String TAG = BookContentProvider.class.getSimpleName();
	private BookOpenHelper mBookOpenHelper;
	
	private static final UriMatcher URI_MATCHER;
	static {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		URI_MATCHER.addURI(Book.AUTHORITY, Book.BOOK_TABLE_NAME, Book.BOOK);
	}
	

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = mBookOpenHelper.getWritableDatabase();
		
		int deletedCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);
		getContext().getContentResolver().notifyChange(uri, null);
		return deletedCount;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = mBookOpenHelper.getWritableDatabase();
		long rowid = db.insert(Book.BOOK_TABLE_NAME, null, values);
		
		Uri inserted = ContentUris.withAppendedId(uri, rowid);
		getContext().getContentResolver().notifyChange(inserted, null);
		return null;
	}

	@Override
	public boolean onCreate() {
		mBookOpenHelper = new BookOpenHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = mBookOpenHelper.getReadableDatabase();
		String tableName = uri.getPathSegments().get(0);
		Cursor cursor = db.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = mBookOpenHelper.getWritableDatabase();
		String tableName = uri.getPathSegments().get(0);
		int updateCount = db.update(tableName, values, selection, selectionArgs);
		getContext().getContentResolver().notifyChange(uri, null);
		return updateCount;
	}

}
