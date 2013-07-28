package com.example.exercises;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Mmenu extends Activity  {
	
	private Button clickBtn;

	private boolean isChangedStat = false;

	private static final int MENUITEM = Menu.FIRST;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mmenu);
		
		clickBtn = (Button) findViewById(R.id.menu_button);
		clickBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isChangedStat)
					isChangedStat = false;
				else
					isChangedStat = true;
			}
		});

		
	}


	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		if(isChangedStat)
			menu.add(0, MENUITEM, 0, "True");
		else
			menu.add(0, MENUITEM, 0, "False");

		return super.onPrepareOptionsMenu(menu);
	}

}
