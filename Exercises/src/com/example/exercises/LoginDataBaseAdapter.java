package com.example.exercises;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter {
		static final String DATABASE_NAME = "login.db";
		static final int DATABASE_VERSION = 1;
		
		static final String DATABASE_CREATE = "create table "+"LOGIN"+
                "( " +"ID"+" integer primary key autoincrement,"+ "MAIL text, FIRSTNAME text, LASTNAME text, PASSWORD text); ";
		
		
		public  SQLiteDatabase db;
		
		private final Context context;
		
		private DataBaseHelper dbHelper;
		public LoginDataBaseAdapter(Context _context) {
			context = _context;
			dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public LoginDataBaseAdapter open() throws SQLException {
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() {
			db.close();
		}

		public SQLiteDatabase getDatabaseInstance() {
			return db;
		}
		public void insertEntry(String mail, String firstname, String lastname, String password) {
			ContentValues newValues = new ContentValues();
			newValues.put("MAIL", mail);
			newValues.put("FIRSTNAME", firstname);
			newValues.put("LASTNAME", lastname);
			newValues.put("PASSWORD", password);

			db.insert("LOGIN", null, newValues);
		}
		public int deleteEntry(String mail) {
		    String where = "MAIL=?";
		    int numberOFEntriesDeleted = db.delete("LOGIN", where, new String[]{mail}) ;

	        return numberOFEntriesDeleted;
		}	
		public boolean checkPassword(String mail, String password) {
			Cursor cursor = db.query("LOGIN", null, " MAIL=?", new String[]{mail}, null, null, null);
	        if (cursor.getCount() > 0) {
	        	cursor.moveToFirst();
				String loginPassword = cursor.getString(cursor.getColumnIndex("PASSWORD"));
				if (password.equals(loginPassword)) {
					cursor.close();	
					return true;
				}
	        }
		    
			cursor.close();
			return false;			
		}
		public String getFirstname (String mail) {
			Cursor cursor = db.query("LOGIN", null, " MAIL=?", new String[]{mail}, null, null, null);
			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
				String firstname = cursor.getString(cursor.getColumnIndex("FIRSTNAME"));
				cursor.close();
				return firstname;
			}
			
			cursor.close();
			return "NaN";
		}
		public String getLastname (String mail) {
			Cursor cursor = db.query("LOGIN", null, " MAIL=?", new String[]{mail}, null, null, null);
			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
				String firstname = cursor.getString(cursor.getColumnIndex("LASTNAME"));
				cursor.close();
				return firstname;
			}
			
			cursor.close();
			return "NaN";
		}
		public String getPassword (String mail) {
			Cursor cursor = db.query("LOGIN", null, " MAIL=?", new String[]{mail}, null, null, null);
			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
				String firstname = cursor.getString(cursor.getColumnIndex("PASSWORD"));
				cursor.close();
				return firstname;
			}
			
			cursor.close();
			return "NaN";
		}
		public void updateEntry(String mail, String firstname, String lastname, String password) {
			ContentValues updatedValues = new ContentValues();
			updatedValues.put("MAIL", mail);
			updatedValues.put("FIRSTNAME", firstname);
			updatedValues.put("LASTNAME", lastname);
			updatedValues.put("PASSWORD",password);

	        String where="MAIL = ?";
		    db.update("LOGIN",updatedValues, where, new String[]{mail});			   
		}		
}