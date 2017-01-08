package com.omadoye.visitcu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class HomeActivity extends Activity implements OnClickListener {

	private Button build,hall;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		build = (Button)findViewById(R.id.buildings);
		hall = (Button)findViewById(R.id.halls);
				
		build.setOnClickListener(this);
		hall.setOnClickListener(this);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.history_cu, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.back:
			Intent i = new Intent (HomeActivity.this, MainActivity.class);
			startActivity(i);
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.buildings:
			Intent openService = new Intent(HomeActivity.this,MapActivity.class);
			openService.putExtra("presentService", "building");
			startActivity(openService);
			break;
		case R.id.halls:
			Intent openServic = new Intent(HomeActivity.this,MapActivity.class);
			openServic.putExtra("presentService", "halls");
			startActivity(openServic);
			break;
		
				}
			}
	}