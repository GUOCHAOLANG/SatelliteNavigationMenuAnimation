package com.example.snma;

import com.example.snma.DrawerMenu.OnMenuItemGClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DrawerMenu dd = (DrawerMenu)findViewById(R.id.one);
//		//�ӿڻص� ����
//		dd.setOnMenuItemGClickListener(new OnMenuItemGClickListener() {
//			
//			public void onClick(View view, int pos) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "item=" + pos,Toast.LENGTH_LONG).show();
//			}
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
