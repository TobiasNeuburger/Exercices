package com.example.exercises;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Welcome extends Activity {
	
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		final SharedPreferences prefs = this.getSharedPreferences("com.example.exercices",Context.MODE_PRIVATE);
		
		loginDataBaseAdapter = new LoginDataBaseAdapter(this);
		loginDataBaseAdapter = loginDataBaseAdapter.open();
		
		String mail = prefs.getString("MAIL", "nan");
		
		String firstName = loginDataBaseAdapter.getFirstname(mail);
		String lastName = loginDataBaseAdapter.getLastname(mail);
		String password = loginDataBaseAdapter.getPassword(mail);
		
		((TextView) findViewById(R.id.welcome_mail)).setText(mail);
		((TextView) findViewById(R.id.welcome_firstName)).setText(firstName);
		((TextView) findViewById(R.id.welcome_lastName)).setText(lastName);
		((TextView) findViewById(R.id.welcome_password)).setText(password);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
