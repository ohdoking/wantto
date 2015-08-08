package com.uni.unitonwanttoapp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private SQLiteDatabase database; 
	
	final int ONE = 0;
    final int TWO = 1;
    final int THREE = 2;
    final int FOUR = 3;
    final int FIVE = 4;
    final int SIX = 5;
    final int SEVEN = 6;
    final int EIGHT = 7;
    final int NINE = 8;
    final int TEN = 9;
	
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
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
 
        return super.onCreateOptionsMenu(menu);
	}

	/**
     * On selecting action bar icons
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
        case R.id.action_search:
            // search action
            return true;
        case R.id.action_location_found:
            // location found
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
