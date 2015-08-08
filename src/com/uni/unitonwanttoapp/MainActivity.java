package com.uni.unitonwanttoapp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.uni.unitonwanttoapp.db.MyDB;
import com.uni.unitonwanttoapp.db.MySQLiteHelper;
import com.uni.unitonwanttoapp.dto.Dream;

public class MainActivity extends Activity {

	private SQLiteDatabase database; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button filterBtn = (Button)findViewById(R.id.filterButton);
		Button addFtn = (Button)findViewById(R.id.addButton);
		Button pushBtn = (Button)findViewById(R.id.pushButton);
		filterBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,FilterAcitivy.class);
				startActivity(i);
			}
		});
		
		addFtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,WriteActivity.class);
				startActivity(i);
			}
		});
		pushBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,CreateNotificationActivity.class);
				startActivity(i);
			}
		});
		
	/*	MyDB my = new MyDB(this);
		Dream d = new Dream(1, "test", "test2", 123.123, 123.123,
				"test3", "test4", "test5", 1,
				0);
		my.addDream(d);
		Toast toast = Toast.makeText(getApplicationContext(),
				   "토스트창에 출력될 문자", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
		*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
