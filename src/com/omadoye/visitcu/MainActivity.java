package com.omadoye.visitcu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button buttonexpofficials;
	Button buttonAboutCU;
	Button buttonaboutbuilding;
	Button buttonsearchCU;
	Button buttongallery;
	Button buttonfindbuildings;
	Button buttontourmemories;
	Button buttonhistorycu;
	Button buttoncuvideo;
	Button buttoncualumni;
	Button buttoncuinnovation;
	Button buttonuniversityaward;
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
					
		buttonuniversityaward = (Button) findViewById(R.id.universityaward);
		buttonuniversityaward.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(MainActivity.this, UniversityAwardActivity.class);
						startActivity(i);
					}
				});
		
		buttoncuinnovation = (Button) findViewById(R.id.studentinnovation);
		buttoncuinnovation.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(MainActivity.this, StudentInnovationActivity.class);
						startActivity(i);
					}
				});
		
		buttoncualumni = (Button) findViewById(R.id.cualumni);
		buttoncualumni.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(MainActivity.this, CUAlumniActivity.class);
						startActivity(i);
					}
				});
		
		buttoncuvideo = (Button) findViewById(R.id.acuvideo);
		buttoncuvideo.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(MainActivity.this, YoutubeActivity.class);
						startActivity(i);
					}
				});
				
		buttonhistorycu = (Button) findViewById(R.id.historycu);
		buttonhistorycu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, HistoryCUActivity.class);
				startActivity(i);
			}
		});
		
		
		
		buttontourmemories = (Button) findViewById(R.id.tourmemories);
		buttontourmemories.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, CameraActivity.class);
				startActivity(i);
			}
		});
		
		buttonfindbuildings = (Button) findViewById(R.id.findbuildings);
		buttonfindbuildings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, HomeActivity.class);
				startActivity(i);
			}
		});
		
		buttongallery = (Button) findViewById(R.id.gallery);
		buttongallery.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, GalleryActivity.class);
				startActivity(i);
			}
		});
		
		buttonexpofficials = (Button) findViewById(R.id.expofficials);
		buttonexpofficials.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this , ExpOffActivity.class);
				startActivity(i);
			}
		});
		
		buttonsearchCU = (Button) findViewById(R.id.searchcu);
		buttonsearchCU.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this , SearchActivity.class);
				startActivity(i);
			}
		});
		
		buttonaboutbuilding = (Button) findViewById(R.id.aboutbuilding);
		buttonaboutbuilding.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this , ExpandActivity.class);
				startActivity(i);
			}
		});
		
		buttonAboutCU = (Button) findViewById(R.id.aboutcu);
		buttonAboutCU.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(MainActivity.this , AboutCUActivity.class);
			startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
