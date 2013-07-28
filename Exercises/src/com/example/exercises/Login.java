package com.example.exercises;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		final SharedPreferences prefs = this.getSharedPreferences("com.example.exercices",Context.MODE_PRIVATE);	
		
		loginDataBaseAdapter = new LoginDataBaseAdapter(this);
		loginDataBaseAdapter = loginDataBaseAdapter.open();
		
		Button login = (Button) findViewById(R.id.login_action);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String mail = ((EditText) findViewById(R.id.login_mail)).getText().toString();
				String password = ((EditText) findViewById(R.id.login_pass)).getText().toString();
				
				if (mail.length() != 0 && password.length() != 0 && loginDataBaseAdapter.checkPassword(mail, password)) {
					prefs.edit().putString("MAIL", mail).commit();
					Toast.makeText(getApplicationContext(), R.string.login_successful, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent (getApplicationContext(), Welcome.class);
					startActivity (intent);
				}
				else
					Toast.makeText(getApplicationContext(), R.string.login_dismissed, Toast.LENGTH_SHORT).show();
				
			}
		});
		
		Button register = (Button) findViewById(R.id.login_register);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (getApplicationContext(), Register.class);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
