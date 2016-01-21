package com.example.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TestAdapter {
	
	TestSqlLite t=null;
	SQLiteDatabase s=null;
	public TestAdapter(Context c)
	{
		
		t=new TestSqlLite(c);
		
		
	}
	
	public void insert(String user,String pass)
	{
		s=t.getWritableDatabase();
		ContentValues c = new ContentValues();
		c.put("name", user);
		c.put("pass",pass);
		long i=s.insert("Test", null, c);
		Log.e("DataTest", "DataAdded at row "+i);
		
		
		
		
	}
	
	public String seedetails()
	{
		Log.e("DataTest","cursor next ");
		String username=null;
		String password=null;
		SQLiteDatabase s=t.getWritableDatabase();
		String[] columns ={"name","pass"};
		Cursor c =s.query("Test" ,columns, null, null, null, null, null);
		c.moveToNext();
		
		int x=c.getColumnIndex("name");
		
		int y=c.getColumnIndex("pass");
		username=c.getString(x);
		password=c.getString(y);
		
		
		
		return(username+"   "+password);
		
	}
	
	
	public class TestSqlLite extends SQLiteOpenHelper{

		public TestSqlLite(Context c)
		{
			
			super(c,"TestDb",null, 1);
			
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE Test(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(255),pass VARCHAR(255));");
			Log.e("DataTest", "Table Created");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
		
	}

}
