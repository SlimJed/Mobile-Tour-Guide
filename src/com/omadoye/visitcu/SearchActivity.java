package com.omadoye.visitcu;

import java.util.ArrayList;
import java.util.HashMap;

import com.omadoye.visitcu.SearchActivity;
import com.omadoye.visitcu.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchActivity extends Activity {
		 
	// List view
		private ListView lv;
		
		// Listview Adapter
		ArrayAdapter<String> adapter;
		
		// Search EditText
		EditText inputSearch;
				
		// ArrayList for Listview
		ArrayList<HashMap<String, String>> productList;
		
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		// Listview Data
        String products[] = {"Daniel Hall", "Joseph Hall", "Peter Hall", "John Hall", "Joseph Hall",
        						"Paul Hall", "Lydia Hall",
        						"Dorcas Hall", "Deborah Hall", "Esther Hall", "Mary Hall","Cafeteria", "Center for Learning Resources","Center for Systems and Information Science",
        						"Center for EnterpreneurialDevelopment Studies","College of Science and Technology","The School of Postgraduate Studies","The Postgraduate Quarters","Staff Quarters",
        						"CU Health Center","The Professor's Quarters","College of Development Studies","Covenant Suites","Covenant University Chapel","The covenant university sport complex","Eagle square","Senate Building","CU Round About",
        						"ALDC","Lecture Theater 1","Lecture Theater 2","Chem Eng Building","Elect Eng Building","Civil Eng Building","ICT Building","Vice Chancellor","Professor Charles Korede Ayo","Deputy Vice Chancellor" ,"Professor Taiwo Olubunmi Abioye",
        						"Registrar", "Dr. Olumuyiwa Oludayo","Director, Centre for Learning Resources", "Dr. Christopher Nkiko", "Director, Financial Services", "Pastor Deji Okubanjo","University Chaplain", "Pastor Oluwasegun Omidiora","Dean, School of Postgraduate Studies", ",Professor Charles Uzodinma Ogbulogo",
        						"Dean, College of Business and Social Sciences","Professor Olurinola Oluranti", "Dean, College of Leadership and Development Studies", "Professor Aize Obayan", "Dean, College of Science and Technology", "Professor Chinedu Shalom",
        						"Dean, College of Engineering", "Professor Cleophas Loto",
        						"Dean, Student Affairs","Mr. Azubuike Ezenwoke","Director, Physical Planning & Development"," Architect Gbenga Alalade ","Director, Centre for Systems and Information Services","Pastor Afolabi Abolade","Director Academic Planning Unit","Dr. Williams Akan","Director, Centre for Research Innovation and Discovery", "Professor Louis Egwari",
        						"Director, Vice-Chancellor’s Office","Dr. Osibanjo A. Omotayo","Director, Centre for Entrepreneurial Development Studies","Dr. Chinoye Moses","Director, Centre for LifeLong Learning","Dr. Nicholas Omoregbe ","Director, Covenant University Counselling Centre",
        						"Dr. Adekunle Oyeyemi","Chief Medical Officer","Dr. Mercy Idachaba","Director, International Office and Linkages","Dr. Angela Eni",
        						"Director, Media and Corporate Affairs","Dr. Lanre Amodu","Director, Covenant University Construction Agency","Pastor Azubuike Nwoke"};
        
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.building_name, products);
        lv.setAdapter(adapter);
        
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
				// When user changed the Text
				SearchActivity.this.adapter.getFilter().filter(cs);	
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub							
			}
		});

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
