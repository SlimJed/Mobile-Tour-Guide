package com.omadoye.visitcu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class ExpOffActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exp_off);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.Expoff);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {
			

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});
	}

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
	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Vice Chancellor ");
		listDataHeader.add("Deputy Vice Chancellor");
		listDataHeader.add("Registrar ");
		listDataHeader.add("Director, Centre for Learning Resources");
		listDataHeader.add("Director, Financial Services");
		listDataHeader.add("University Chaplain");
		listDataHeader.add("Dean, School of Postgraduate Studies");
		listDataHeader.add("Dean, College of Business and Social Sciences");
		listDataHeader.add("Dean, College of Leadership and Development Studies");
		listDataHeader.add("Dean, College of Science and Technology");
		listDataHeader.add("Dean, College of Engineering");
		listDataHeader.add("Dean, Student Affairs");
		listDataHeader.add("Director, Physical Planning & Development");
		listDataHeader.add("DirectorCentreforSystemsandInformationServices");
		listDataHeader.add("Director, Academic Planning Unit");
		listDataHeader.add("Director, Centre for Research , Innovation and Discovery");
		listDataHeader.add("Director, Vice-Chancellor’s Office");
		listDataHeader.add("Director, Centre for Entrepreneurial Development Studies");
		listDataHeader.add("Director, Centre for LifeLong Learning");
		listDataHeader.add("Director, Covenant University Counselling Centre");
		listDataHeader.add("Chief Medical Officer");
		listDataHeader.add("Director, International Office and Linkages");
		listDataHeader.add("Director, Media and Corporate Affairs");
		listDataHeader.add("Director, Covenant University Construction Agency");
					

		// Adding child data
		List<String> ViceChancellor = new ArrayList<String>();
		ViceChancellor.add("The vice chancellor of covenant university is Professor Charles Ayo ");
				
		List<String> DeputyViceChancellor = new ArrayList<String>();
		DeputyViceChancellor.add("The deputy vice chancellor of covenant university is  Professor Taiwo Olubunmi Abioye");
		
		List<String> Registrar = new ArrayList<String>();
		Registrar.add("The registra of covenant university is Dr. Olumuyiwa Oludayo");
		
		
		List<String> DirectorCentreforLearningResources = new ArrayList<String>();
		DirectorCentreforLearningResources.add("The Director Centre for Learning Resources is Dr. Christopher Nkiko");
		
		List<String> DirectorFinancialServices = new ArrayList<String>();
		DirectorFinancialServices.add("The Director Financial Services is Pastor Deji Okubanjo");
		
		List<String> UniversityChaplain = new ArrayList<String>();
		UniversityChaplain.add("The University Chaplain is Pastor Oluwasegun Omidiora");
		
		List<String> DeanSchoolofPostgraduateStudies = new ArrayList<String>();
		DeanSchoolofPostgraduateStudies.add("Professor Charles Uzodinma Ogbulogo");
		
		List<String> DeanCollegeofBusinessandSocialSciences = new ArrayList<String>();
		DeanCollegeofBusinessandSocialSciences.add("The Dean School of Postgraduate Studies is Professor Olurinola Oluranti");

		List<String> DeanCollegeofLeadershipandDevelopmentStudies = new ArrayList<String>();
		DeanCollegeofLeadershipandDevelopmentStudies.add("The Dean College of Leadership and Development Studies is Professor Aize Obayan");
		
		List<String> DeanCollegeofScienceandTechnology = new ArrayList<String>();
		DeanCollegeofScienceandTechnology.add("The Dean College of Science and Technology is Professor Chinedu Shalom");
		
		List<String> DeanCollegeofEngineering  = new ArrayList<String>();
		DeanCollegeofEngineering.add("The Dean College of Engineering is Professor Cleophas Loto");
		
		List<String> DeanStudentAffairs = new ArrayList<String>();
		DeanStudentAffairs.add("The Dean Student Affairs is Mr. Azubuike Ezenwoke");
		
		List<String> DirectorPhysicalPlanningDevelopment = new ArrayList<String>();
		DirectorPhysicalPlanningDevelopment.add("The Director Physical Planning and Development is Architect Gbenga Alalade");
		
		List<String> DirectorCentreforSystemsandInformationServices = new ArrayList<String>();
		DirectorCentreforSystemsandInformationServices.add("The Director Centre for Systems and Information Services is Pastor Afolabi Abolade");
		
		List<String> DirectorAcademicPlanningUnit = new ArrayList<String>();
		DirectorAcademicPlanningUnit.add("The Director Academic Planning Unitn is Dr. Williams Akan");
		
		List<String> DirectorCentreforResearchInnovationandDiscovery = new ArrayList<String>();
		DirectorCentreforResearchInnovationandDiscovery.add("The Director Centre for Research Innovation and Discovery is Professor Louis Egwari");
		
		List<String> DirectorViceChancellorsOffice = new ArrayList<String>();
		DirectorViceChancellorsOffice.add("The Director Vice Chancellors Office is Dr. Osibanjo A. Omotayo");
		
		List<String> DirectorCenterforEntrepreneurialDevelopmentStudies = new ArrayList<String>();
		DirectorCenterforEntrepreneurialDevelopmentStudies.add("The Director Center for Entrepreneurial Development Studies is Dr. Chinoye Moses");
		
		List<String> DirectorCentreforLifeLongLearning = new ArrayList<String>();
		DirectorCentreforLifeLongLearning.add("The Director Centre for Life-Long Learning is Dr. Nicholas Omoregbe");
		
		List<String> DirectorCovenantUniversityCounsellingCentre = new ArrayList<String>();
		DirectorCovenantUniversityCounsellingCentre.add("The Director Covenant University Counselling Centre is Dr. Adekunle Oyeyemi");
		
		List<String> ChiefMedicalOfficer = new ArrayList<String>();
		ChiefMedicalOfficer.add("The Chief Medical Officer is Dr. Mercy Idachaba");
		
		List<String> DirectorInternationalOfficeandLinkages = new ArrayList<String>();
		DirectorInternationalOfficeandLinkages.add("The Director International Office and Linkages is Dr. Angela Eni");
		
		List<String> DirectorMediaandCorporateAffairs = new ArrayList<String>();
		DirectorMediaandCorporateAffairs.add("The Director Media and Corporate Affairs is Dr. Lanre Amodu");
		
		List<String> DirectorCovenantUniversityConstructionAgency = new ArrayList<String>();
		DirectorCovenantUniversityConstructionAgency.add("The Director of Covenant University Construction Agency is Pastor Azubuike Nwoke");
		
		
		listDataChild.put(listDataHeader.get(0), ViceChancellor); // Header, Child data
		listDataChild.put(listDataHeader.get(1), DeputyViceChancellor);
		listDataChild.put(listDataHeader.get(2), Registrar);
		listDataChild.put(listDataHeader.get(3), DirectorCentreforLearningResources);
		listDataChild.put(listDataHeader.get(4), DirectorFinancialServices);
		listDataChild.put(listDataHeader.get(5), UniversityChaplain);
		listDataChild.put(listDataHeader.get(6), DeanSchoolofPostgraduateStudies);
		listDataChild.put(listDataHeader.get(7), DeanCollegeofBusinessandSocialSciences);
		listDataChild.put(listDataHeader.get(8), DeanCollegeofLeadershipandDevelopmentStudies);
		listDataChild.put(listDataHeader.get(9), DeanCollegeofScienceandTechnology);
		listDataChild.put(listDataHeader.get(10), DeanCollegeofEngineering);
		listDataChild.put(listDataHeader.get(11), DeanStudentAffairs);
		listDataChild.put(listDataHeader.get(12), DirectorPhysicalPlanningDevelopment);
		listDataChild.put(listDataHeader.get(13), DirectorCentreforSystemsandInformationServices);
		listDataChild.put(listDataHeader.get(14), DirectorAcademicPlanningUnit);
		listDataChild.put(listDataHeader.get(15), DirectorCentreforResearchInnovationandDiscovery);
		listDataChild.put(listDataHeader.get(16), DirectorViceChancellorsOffice);
		listDataChild.put(listDataHeader.get(17), DirectorCenterforEntrepreneurialDevelopmentStudies);
		listDataChild.put(listDataHeader.get(18), DirectorCentreforLifeLongLearning);
		listDataChild.put(listDataHeader.get(19), DirectorCovenantUniversityCounsellingCentre);
		listDataChild.put(listDataHeader.get(20), ChiefMedicalOfficer);
		listDataChild.put(listDataHeader.get(21), DirectorInternationalOfficeandLinkages);
		listDataChild.put(listDataHeader.get(22), DirectorMediaandCorporateAffairs);
		listDataChild.put(listDataHeader.get(23), DirectorCovenantUniversityConstructionAgency 	);
		
	}
}
