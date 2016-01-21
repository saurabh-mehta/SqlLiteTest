package com.example.databasetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TestAdapter t = new TestAdapter(this);
		t.insert("Saurabh", "Saurabh");
		String s=t.seedetails();
		Log.e("DataTest",s);
		Toast.makeText(this, "The data is"+s, Toast.LENGTH_LONG).show();
		
	}
}
