package com.uni.unitonwanttoapp.db;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.uni.unitonwanttoapp.dto.Dream;

public class MySQLiteHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "WanttoDB";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// SQL statement to create book table
		String CREATE_BOOK_TABLE = "CREATE TABLE dreams ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "zone TEXT, "
				+ "todo TEXT, " + "lat NUMERIC, " + "lon NUMERIC, "
				+ "location TEXT, " + "memo TEXT, " + "check NUMERIC, "
				+ "noti NUMERIC,"+ "notification TEXT)";

		// create books table
		db.execSQL(CREATE_BOOK_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older books table if existed
		db.execSQL("DROP TABLE IF EXISTS books");

		// create fresh books table
		this.onCreate(db);
	}

	// ---------------------------------------------------------------------

	/**
	 * CRUD operations (create "add", read "get", update, delete) book + get all
	 * books + delete all books
	 */

	// Books table name
	private static final String DREAM_TABLES = "dreams";

	// Books Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_ZONE = "zone";
	private static final String KEY_TODO = "todo";
	private static final String KEY_LAT = "lat";
	private static final String KEY_LON = "lon";
	private static final String KEY_LOCATION = "location";
	private static final String KEY_MEMO = "memo";
	private static final String KEY_CHECK = "check";
	private static final String KEY_NOTI = "noti";
	private static final String KEY_CATEGORY = "category";

	private static final String[] COLUMNS = { KEY_ID, KEY_ZONE, KEY_TODO,
			KEY_LAT, KEY_LON, KEY_LOCATION, KEY_MEMO, KEY_CHECK, KEY_NOTI,KEY_CATEGORY };

	// Dream Table ALL ADD
	public void addDream(Dream dream) {
		Log.d("addBook", KEY_CATEGORY.toString());
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		
		values.put(KEY_ZONE, dream.getZone()); 
		values.put(KEY_TODO, dream.getTodo()); 
		values.put(KEY_LAT, dream.getLat()); 
		values.put(KEY_LON, dream.getLon()); 
		values.put(KEY_LOCATION, dream.getLocation()); 
		values.put(KEY_MEMO, dream.getMemo()); 
		values.put(KEY_CHECK, dream.isCheck()); 
		values.put(KEY_NOTI, dream.isNoti()); 
		values.put(KEY_CATEGORY, dream.getCategory()); 
		 
		// 3. insert
		db.insert(DREAM_TABLES, // table
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}
	
	// Dream Table One GET by id
	public Dream getDream(int id) {

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();

		// 2. build query
		Cursor cursor = db.query(DREAM_TABLES, // a. table
				COLUMNS, // b. column names
				" id = ?", // c. selections
				new String[] { String.valueOf(id) }, // d. selections args
				null, // e. group by
				null, // f. having
				null, // g. order by
				null); // h. limit

		// 3. if we got results get the first one
		if (cursor != null)
			cursor.moveToFirst();

		// 4. build book object
		Dream dream = new Dream();
		dream.setId(Integer.parseInt(cursor.getString(0)));
		dream.setTodo(cursor.getString(1));
		dream.setLat(Float.parseFloat(cursor.getString(2)));
		dream.setLon(Float.parseFloat(cursor.getString(3)));
		dream.setLocation(cursor.getString(4));
		dream.setMemo(cursor.getString(5));
		dream.setCheck(Boolean.parseBoolean(cursor.getString(6)));
		dream.setNoti(Boolean.parseBoolean(cursor.getString(7)));
		dream.setCategory(cursor.getString(8));
		

		Log.d("getDream(" + id + ")", dream.toString());

		// 5. return book
		return dream;
	}

	// Get All Books
	public List<Dream> getAllDreams() {
		List<Dream> dreams = new LinkedList<Dream>();

		// 1. build the query
		String query = "SELECT  * FROM " + DREAM_TABLES;

		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// 3. go over each row, build book and add it to list
		Dream dream = null;
		if (cursor.moveToFirst()) {
			do {
				dream = new Dream();
				dream.setId(Integer.parseInt(cursor.getString(0)));
				dream.setTodo(cursor.getString(1));
				dream.setLat(Float.parseFloat(cursor.getString(2)));
				dream.setLon(Float.parseFloat(cursor.getString(3)));
				dream.setLocation(cursor.getString(4));
				dream.setMemo(cursor.getString(5));
				dream.setCheck(Boolean.parseBoolean(cursor.getString(6)));
				dream.setNoti(Boolean.parseBoolean(cursor.getString(7)));
				dream.setCategory(cursor.getString(8));

				// Add book to books
				dreams.add(dream);
			} while (cursor.moveToNext());
		}

		Log.d("getAllBooks()", dreams.toString());

		// return books
		return dreams;
	}

	// Updating single book
	public int updateDream(Dream dream) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put(KEY_ZONE, dream.getZone()); 
		values.put(KEY_TODO, dream.getTodo()); 
		values.put(KEY_LAT, dream.getLat()); 
		values.put(KEY_LON, dream.getLon()); 
		values.put(KEY_LOCATION, dream.getLocation()); 
		values.put(KEY_MEMO, dream.getMemo()); 
		values.put(KEY_CHECK, dream.isCheck()); 
		values.put(KEY_NOTI, dream.isNoti()); 
		values.put(KEY_CATEGORY, dream.getCategory()); 
		// 3. updating row
		int i = db.update(DREAM_TABLES, // table
				values, // column/value
				KEY_ID + " = ?", // selections
				new String[] { String.valueOf(dream.getId()) }); // selection
																// args

		// 4. close
		db.close();

		return i;

	}

	// Deleting single book
	public void deleteDream(Dream dream) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. delete
		db.delete(DREAM_TABLES, KEY_ID + " = ?",
				new String[] { String.valueOf(dream.getId()) });

		// 3. close
		db.close();

		Log.d("deleteBook", dream.toString());

	}
}
