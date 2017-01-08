package com.omadoye.visitcu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GalleryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter(GalleryActivity.this));
        gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				
				Intent i= new Intent(GalleryActivity.this,SingleViewActivity.class);
				i.putExtra("id", position);
				startActivity(i);
			}
		});
        
        {
        	
        }
    }
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.history_cu, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
