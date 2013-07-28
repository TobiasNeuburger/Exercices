package com.example.exercises;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MyListView extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_list_view);
		setListAdapter(new DataAdapter(this));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_list_view, menu);
		return true;
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Toast.makeText(getApplicationContext(), "Ich bin Nummer " + position, Toast.LENGTH_SHORT).show();
	}

}