package com.example.exercises;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class Searchview extends Activity {

	SearchView sv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seachview);
		
		ActionBar actionBar = getActionBar();
		actionBar.setCustomView(R.layout.searchbar);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_SHOW_CUSTOM);
		
		sv = (SearchView) findViewById(R.id.searchbar);
		sv.setOnQueryTextListener(new OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String query) {
				//Hide Keyboard
				InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(FragmentActivity.INPUT_METHOD_SERVICE);
		        imm.hideSoftInputFromWindow(sv.getWindowToken(), 0);
		        
		        //Set Searchview to default status
		        sv.onActionViewCollapsed();
		        
		        //Make toast of search input
				Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
				
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) {
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seachview, menu);
		return true;
	}

}
