package com.example.exercises;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {
	
	private static final String TAG = "MAIN";
	private static int spinnerPos = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		
		List <String> values = Arrays.asList("Long Click","Action Bar", "Login", "Menu", "Searchview", "ActionBar", "ListView");
		ArrayAdapter <String> adapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, values);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setOnItemSelectedListener(this);
		spinner.setAdapter(adapter);
		
		Button action = (Button) findViewById(R.id.action_button);
		action.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (spinnerPos) {
				case 0:
					Intent intent1 = new Intent(getApplicationContext(), Longclick.class);
					startActivity(intent1);
					break;
				case 1:
					Intent intent2 = new Intent(getApplicationContext(), Actionbar.class);
					startActivity(intent2);
					break;
				case 2:
					Intent intent3 = new Intent(getApplicationContext(), Login.class);
					startActivity(intent3);
					break;	
				default:
					Toast.makeText(getApplicationContext(), R.string.no_value, Toast.LENGTH_SHORT).show();
					break;
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
		Log.d( TAG, "on item selected: " + position );
		spinnerPos = position;
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		Log.d( TAG, "nothing selected" );
	
	}
	

}