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
		String CREATE_BOOK_TABLE = "CREATE TABLE IF NOT EXISTS dreams ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "zone VARCHAR(100), "
				+ "todo VARCHAR(100), " + "lat NUMERIC(10,5), " + "lon NUMERIC(10,5), "
				+ "location VARCHAR(100), " + "memo VARCHAR(100), " + "checked INTEGER, "
				+ "noti INTEGER,"+" category VARCHAR(100))";

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

	
}
