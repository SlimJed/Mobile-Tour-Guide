package com.omadoye.visitcu;

import com.omadoye.visitcu.ExpandableListAdapter;
import com.omadoye.visitcu.R;

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
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class ExpandActivity extends Activity {
	
	
	

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expand);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
			
			
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

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
				
				for(int i = 0; i<listDataHeader.size(); i++){
					if(i!=groupPosition){
						expListView.collapseGroup(i);
					}
					}
					
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		}
			);

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
		listDataHeader.add("Halls Of Residence");
		listDataHeader.add("Daniel Hall");
		listDataHeader.add("Peter Hall");
		listDataHeader.add("John Hall");
		listDataHeader.add("Joseph Hall");
		listDataHeader.add("Paul Hall");
		listDataHeader.add("Lydia Hall");
		listDataHeader.add("Dorcas Hall");
		listDataHeader.add("Deborah Hall");
		listDataHeader.add("Esther Hall");
		listDataHeader.add("Mary Hall");
		listDataHeader.add("Cafeteria");
		listDataHeader.add("Center for Learning Resources");
		listDataHeader.add("Center for Systems and Information Science");
		listDataHeader.add("CU Health Center");
		listDataHeader.add("Center for EnterpreneurialDevelopment Studies");
		listDataHeader.add("College of Science and Technology");
		listDataHeader.add("The School of Postgraduate Studies");
		listDataHeader.add("The Postgraduate Quarters");
		listDataHeader.add("Staff Quarters");
		listDataHeader.add("The Professor's Quarters");
		listDataHeader.add("College of Development Studies");
		listDataHeader.add("Covenant Suites");
		listDataHeader.add("Covenant University Chapel");
		listDataHeader.add("The covenant university sport complex");
		listDataHeader.add("Eagle square");
		listDataHeader.add("Senate Building");
		listDataHeader.add("CU Round About");
		listDataHeader.add("ALDC");
		listDataHeader.add("Lecture Theater 1");
		listDataHeader.add("Lecture Theater 2");
		listDataHeader.add("Chem Eng Building");
		listDataHeader.add("Elect Eng Building");
		listDataHeader.add("Mech Eng Building");
		listDataHeader.add("Civil Eng Building");
		listDataHeader.add("ICT Building");
				
		
				

		// Adding child data
		List<String> HallsOfResidence = new ArrayList<String>();
		HallsOfResidence.add("There are 10 halls of residence in the unversity namely Daniel Hall, Paul Hall, Joseph Hall, Peter Hall, John Hall, Esther Hall, Mary Dorcas, Lydia Hall, Deborah Hall and Dorcas Hall");
				
		List<String> DanielHall = new ArrayList<String>();
		DanielHall.add("This is the male residential hall for the final year students, the students' hostel facility can effectively accommodate 1308 students and has 327 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, barbing saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> PeterHall = new ArrayList<String>();
		PeterHall.add("This is the male residential hall for the final year students, the students' hostel facility can effectively accommodate 792 students and has 198 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, barbing saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		
		List<String> JohnHall = new ArrayList<String>();
		JohnHall.add("This is the male residential hall for the final year students, the students' hostel facility can effectively accommodate 840 students and has 210 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, barbing saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> JosephHall = new ArrayList<String>();
		JosephHall.add("This is the male residential hall for the final year students, the students' hostel facility can effectively accommodate 1208 students and has 302 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, barbing saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> PaulHall = new ArrayList<String>();
		PaulHall.add("This is the male residential hall for the final year students, the students' hostel facility can effectively accommodate 792 students and has 198 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, barbing saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> LydiaHall = new ArrayList<String>();
		LydiaHall.add("This is the female residential hall for the final year students, the students' hostel facility can effectively accommodate 1208 students and has 302 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, beauty saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> DorcasHall = new ArrayList<String>();
		DorcasHall.add("This is the female residential hall for the final year students, the students' hostel facility can effectively accommodate 1208 students and has 302 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, beauty saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");

		List<String> DeborahHall = new ArrayList<String>();
		DeborahHall.add("This is the female residential hall for the final year students, the students' hostel facility can effectively accommodate 544 students and has 284 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, beauty saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> EstherHall = new ArrayList<String>();
		EstherHall.add("This is the female residential hall for the final year students, the students' hostel facility can effectively accommodate 792 students and has 198 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, beauty saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> MaryHall = new ArrayList<String>();
		MaryHall.add("This is the female residential hall for the final year students, the students' hostel facility can effectively accommodate 544 students and has 284 rooms, there are ancillary spaces such as common rooms, butteries, tuck shops, telephone rooms, beauty saloons, porters' room and administrative offices.  All Covenant University Students reside in the hostels on campus.");
		
		List<String> Cafeteria1 = new ArrayList<String>();
		Cafeteria1.add("The Cafeteria is centrally situated in the midst of the six Halls of Residence Complexes. It has a capacity for 2,500 students, dining at the same time.");
		
		List<String> CenterforLearningResources = new ArrayList<String>();
		CenterforLearningResources.add("The University's Centre for Learning Resources (CLR), otherwise known as the University Library, is an information age learning centre.  It is the research nerve centre of the University.  The complex is an imposing ultra-modern structure on three floors reputed to be the largest in Africa.  The total floor area of the complex is 11,300m2.  It is designed as an imposing glass structure, which helps to speak of learning as the major activity in the University.  It is strategically located amidst the College buildings, University Chapel and the Halls of Residence.  It is able to accommodate up to 2,500 readers and about 500 researching staff and postgraduate students. The Centre has an ultra-modern conference centre located at the top floor of the CLR building. ");
		
		List<String> CenterforSystemsandInformationScience = new ArrayList<String>();
		CenterforSystemsandInformationScience.add("The Centre is a support unit dedicated to providing state-of-the-art information technology and communications to students and staffs. We communicate regularly with customers to update their call progress, monitor and test fixes to ensure that challenges are resolved. The centre also makes available remote access to the systems, logs requests from any caller in a well-designed format that gives details of the caller’s ID and his or her needs, logs details of the officer that may be directed to attend to this request online, gives technical directives to callers on how to resolve certain issues and submits the logged requests to HSS, Network Administrator or Head, Telecoms Unit as may be required.");
		
		List<String> CUHealthCenter = new ArrayList<String>();
		CUHealthCenter.add("The facility provides primary and secondary healthcare services to staff and students of the University, and it operates with Thirty Beds spread over three wards. Our operations are IT driven to deliver fast and efficient services with excellent, safe, and secure patient’s records and archival system. We also utilize online resources such as Pubmed, Cochrane, Univadis and NICE online (National Institute for Clinical Excellence) for in house training and routine practice.");
		
		List<String> CenterforEnterpreneurialDevelopmentStudies = new ArrayList<String>();
		CenterforEnterpreneurialDevelopmentStudies.add("Entrepreneurial Development Studies (EDS) is a custom-built programme in Covenant University. The programme is an all semester programme and compulsory for all students of the University irrespective of the student’s chosen field of study. It involves both theory and practical. The operations of the programme are housed in the Centre for Entrepreneurial Development Studies (CEDS).");
		
		List<String> CollegeofScienceandTechnology = new ArrayList<String>();
		CollegeofScienceandTechnology.add("This College building has a floor area of 11,980 m. It is a three story complex comprising of 25 lecture rooms, 17 specialized Science/Engineering laboratories and 45 Single/Executive offices.  Other spaces include 4 conference rooms, utility spaces and general conveniences. This Building also has within it one of the state-of-the-arts Computer laboratories that is equipped with a total of 250 branded PCs, fully networked and linked to the Internet. The University has other Computer laboratories and Cybercafés strategically located in the other College and the Laboratory for updated information and research purposes. ");
		
		List<String> TheSchoolofPostgraduateStudies = new ArrayList<String>();
		TheSchoolofPostgraduateStudies.add("The Postgraduate School Building is a half octagonal structure aesthetically linked to the Chapel building with the courtyard and walkway to form a full octagon.  The building has Seminar rooms, well equipped offices; conference rooms and a tea room for informal-out-of-lecture-interactions. ");
		
		List<String> ThePostgraduateQuarters = new ArrayList<String>();
		ThePostgraduateQuarters.add("These are six blocks of eight flats each of 3 bedroom flat accommodation available for Senior category of staff of the University. All the three bedrooms in these flats are provided with toilet facilities ensuite.");
		
		List<String> StaffQuarters = new ArrayList<String>();
		StaffQuarters.add("These block of duplexes have 4 bedroom built ensuites with toilet facilities for the Senior echelon of the University Staff. There are 22 of this category of buildings all endowed with plush lawns.");
		
		List<String> TheProfessorsQuarters = new ArrayList<String>();
		TheProfessorsQuarters.add("This is a three-storey ultra modern structure conceptualized from the marriage of two U-shaped forms. It has a total floor space area of 12, 748 m.");
				
		List<String> CollegeofDevelopmentStudies = new ArrayList<String>();
		CollegeofDevelopmentStudies.add("This is a three-storey ultra modern structure conceptualized from the marriage of two U-shaped forms. It has a total floor space area of 12, 748 m.");
		
		List<String> CovenantSuites = new ArrayList<String>();
		CovenantSuites.add("This is made up of 64 Suites of two bedroom duplexes made available to Senior Staff of the University who may be interested.  These block of duplexes also have in-built toilet facilities in each of the rooms located upstairs, while the living room, dining apartment and kitchen are situated downstairs. ");
		
		List<String> CovenantUniversityChapel = new ArrayList<String>();
		CovenantUniversityChapel.add("The Covenant University Chapel is an ultra-modern architectural masterpiece, situated in the heart of the University campus. It has a sitting capacity of 3,500.");
		
		List<String> Thecovenantuniversitysportcomplex = new ArrayList<String>();
		Thecovenantuniversitysportcomplex.add("The Sports Complex is located at the left side of the main entrance to the University.  Covenant University has put in place a well-rounded programme of sporting and athletic activities on the campus under the able supervision of seasoned coaches. The Sports Complex though still under construction is located on the left hand side of the main entrance to the University. Currently provided for both staff and student recreation are the following facilities which are located both at the Stadium complex and around the halls of residence. ");
		
		List<String> Eaglesquare = new ArrayList<String>();
		Eaglesquare.add("This is a black and white sculpture at the center of the female halls, rumored to be build by a graduating set");
		
		List<String> SenateBuilding = new ArrayList<String>();
		SenateBuilding.add("This is the administrative hub of the university");
		
		List<String> CURoundAbout = new ArrayList<String>();
		CURoundAbout.add("This is one of the numerous landmarks of the university");
		
		List<String> ALDC = new ArrayList<String>();
		ALDC.add("A beautiful very imposing state of the art facility is also available on campus to provide adequate services for Conferences, Seminars and symposium.  The building houses two main halls, made up of one conference hall with a gallery that can accommodate 2000 guests, one seminar room, two dining halls and one gymnasium.");
		
		List<String> LectureTheater1 = new ArrayList<String>();
		LectureTheater1.add("This is the Lecture hall for the general courses ");
		
		List<String> LectureTheater2 = new ArrayList<String>();
		LectureTheater2.add("This is the Lecture hall for the general courses");
		
		List<String> ChemEngBuilding = new ArrayList<String>();
		ChemEngBuilding.add("The workshops in these departments are being developed and equipped. The principal responsibility is to carry out assignments that are peculiar to the two departments. Engineering workshops provide students with a systematic understanding of the knowledge – base of engineering practice, the ability to be self – directed and innovative in tackling and solving problems, as well as the independent learning ability required for professional development.");
		
		List<String> ElectEngBuilding = new ArrayList<String>();
		ElectEngBuilding.add("In EIE Dept, we have a workshop that is staffed by experienced technicians and artisans. In the workshop, we carry out rewinding and refurbishing of electrical equipment and apparatus. Most faulty ceiling fans from the halls of Residence are sometimes taken to EIE workshop for repairs.");
		
		List<String> MechEngBuilding = new ArrayList<String>();
		MechEngBuilding.add("The general engineering workshop is located at the department of Mechanical Engineering; however other departments like Civil, Electrical & Information, Chemical and Petroleum also have workshops that are peculiar to each department");
		
		List<String> CivilEngBuilding = new ArrayList<String>();
		CivilEngBuilding.add("In civil engineering, we have two workshops that are functional now; others are being planned. The two workshops are: a. Carpentry workshop b. Concrete workshop");
		
		List<String> ICTBuilding = new ArrayList<String>();
		ICTBuilding.add("This is the Information and communication technology workshop");
		
		
		listDataChild.put(listDataHeader.get(0), HallsOfResidence); // Header, Child data
		listDataChild.put(listDataHeader.get(1), DanielHall);
		listDataChild.put(listDataHeader.get(2), PeterHall);
		listDataChild.put(listDataHeader.get(3), JohnHall);
		listDataChild.put(listDataHeader.get(4), JosephHall);
		listDataChild.put(listDataHeader.get(5), PaulHall);
		listDataChild.put(listDataHeader.get(6), LydiaHall);
		listDataChild.put(listDataHeader.get(7), DorcasHall);
		listDataChild.put(listDataHeader.get(8), DeborahHall);
		listDataChild.put(listDataHeader.get(9), EstherHall);
		listDataChild.put(listDataHeader.get(10), MaryHall);
		listDataChild.put(listDataHeader.get(11), Cafeteria1);
		listDataChild.put(listDataHeader.get(12), CenterforLearningResources);
		listDataChild.put(listDataHeader.get(13), CenterforSystemsandInformationScience);
		listDataChild.put(listDataHeader.get(14), CUHealthCenter);
		listDataChild.put(listDataHeader.get(15), CenterforEnterpreneurialDevelopmentStudies);
		listDataChild.put(listDataHeader.get(16), CollegeofScienceandTechnology);
		listDataChild.put(listDataHeader.get(17), TheSchoolofPostgraduateStudies);
		listDataChild.put(listDataHeader.get(18), ThePostgraduateQuarters);
		listDataChild.put(listDataHeader.get(19), StaffQuarters);
		listDataChild.put(listDataHeader.get(20), TheProfessorsQuarters);
		listDataChild.put(listDataHeader.get(21), CollegeofDevelopmentStudies);
		listDataChild.put(listDataHeader.get(22), CovenantSuites);
		listDataChild.put(listDataHeader.get(23), CovenantUniversityChapel);
		listDataChild.put(listDataHeader.get(24), Thecovenantuniversitysportcomplex);
		listDataChild.put(listDataHeader.get(25), Eaglesquare);
		listDataChild.put(listDataHeader.get(26), SenateBuilding);
		listDataChild.put(listDataHeader.get(27), CURoundAbout);
		listDataChild.put(listDataHeader.get(28), ALDC);
		listDataChild.put(listDataHeader.get(29), LectureTheater1);
		listDataChild.put(listDataHeader.get(30), LectureTheater2);
		listDataChild.put(listDataHeader.get(31), ChemEngBuilding);
		listDataChild.put(listDataHeader.get(32), ElectEngBuilding);
		listDataChild.put(listDataHeader.get(33), MechEngBuilding);
		listDataChild.put(listDataHeader.get(34), CivilEngBuilding);
		listDataChild.put(listDataHeader.get(35), ICTBuilding);
		
		
		
	}
}
