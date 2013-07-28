package com.example.exercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

	LoginDataBaseAdapter loginDataBaseAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		loginDataBaseAdapter = new LoginDataBaseAdapter(this);
		loginDataBaseAdapter = loginDataBaseAdapter.open();
		
		Button button = (Button) findViewById(R.id.register_action);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String mail = ((EditText) findViewById(R.id.register_mail)).getText().toString();
				String firstName = ((EditText) findViewById(R.id.register_firstName)).getText().toString();
				String lastName = ((EditText) findViewById(R.id.register_lastName)).getText().toString();
				String pass = ((EditText) findViewById(R.id.register_pass)).getText().toString();
				
				if (mail.length() != 0 && firstName.length() != 0 && lastName.length() != 0 && pass.length() != 0) {
					loginDataBaseAdapter.insertEntry(mail, firstName, lastName, pass);
					Toast.makeText(getApplicationContext(), R.string.register_successful, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent (getApplicationContext(), Login.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
					startActivity(intent);
				}
				else
					Toast.makeText(getApplicationContext(), R.string.register_dismissed, Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
