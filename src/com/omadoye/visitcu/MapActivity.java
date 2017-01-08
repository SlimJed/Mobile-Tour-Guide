package com.omadoye.visitcu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.omadoye.visitcu.MapsPins;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MapActivity extends Activity implements OnClickListener,LocationListener{
	
		static GoogleMap googleMap;
	private Button closestService,searchplace;
	private AutoCompleteTextView searchbox;
	private ArrayAdapter<String> adapter;
	public static Marker center;
	private String currentLat = "null";
	private String currentLong = "null";
	public String presentService;
	private LocationManager locationManager;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		Intent whichService = getIntent();
		
		presentService = whichService.getStringExtra("presentService");
		
		if (presentService.equals("halls")) {
			loadHallServices();
			showtoast("All halls of residence in CU");
		}else if(presentService.equals("building")){
			loadBuildingServices();
			showtoast("All buildings in CU");
		}
		
		//here, i'll be putting different methods of classes that i will call based on what intent i pass
		//so for instance, if i put intent = 1 , it should call a method like name allPlacesInCU();
		
		
		locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
	}
	
	private void loadBuildingServices() {
		// TODO Auto-generated method stub
		String buildings[] = getResources().getStringArray(R.array.buildings); 
		searchbox =(AutoCompleteTextView)findViewById(R.id.searcheditbox);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buildings);
		searchbox.setAdapter(adapter);
		searchbox.setThreshold(1);
		searchplace = (Button)findViewById(R.id.searchbutton);
		searchplace.setOnClickListener(this);
		closestService = (Button)findViewById(R.id.closestService);
		closestService.setOnClickListener(this);
		try {
			startBuildingMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startBuildingMap() {
		// TODO Auto-generated method stub

		if (googleMap==null){
			googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			googleMap.setMyLocationEnabled(true);
			
			
			
			//this is the lattitude and longitude for the Center of CU which is CU Gardens...lol..theres no name like dat o
			double latitude = 6.671318;
			double longitude = 3.158343;
			LatLng latlng = new LatLng(latitude, longitude);
			
			//create initial marker for center of CU and all other places....
			center = googleMap.addMarker(new MarkerOptions().position(latlng).title("CU Gardens").snippet("This is the center of covenant university"));
			center.showInfoWindow();
			CameraPosition camposition = new CameraPosition(latlng, 18, 0, 0);
			googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camposition), 5000, null);
			
			//create the remaining markers for all other places in CU
			MapsPins.nameAllBuildingsWithMarkersInCU();
			
			
			//check if map is created succesfully or not
			if(googleMap==null){
				Toast.makeText(getApplicationContext(), "You need internet connectivity", Toast.LENGTH_LONG).show();
			}
			
			
			
		}
	
	}

	
	private void loadHallServices() {
		// TODO Auto-generated method stub
		String halls[] = getResources().getStringArray(R.array.halls); 
		searchbox =(AutoCompleteTextView)findViewById(R.id.searcheditbox);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, halls);
		searchbox.setAdapter(adapter);
		searchbox.setThreshold(1);
		searchplace = (Button)findViewById(R.id.searchbutton);
		searchplace.setOnClickListener(this);
		closestService = (Button)findViewById(R.id.closestService);
		closestService.setOnClickListener(this);
		try {
			startHallMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startHallMap() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		if (googleMap==null){
			googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			googleMap.setMyLocationEnabled(true);
			
			
			
			//this is the lattitude and longitude for the Center of CU which is CU Gardens...lol..theres no name like dat o
			double latitude = 6.671318;
			double longitude = 3.158343;
			LatLng latlng = new LatLng(latitude, longitude);
			
			//create initial marker for center of CU and all other places....
			center = googleMap.addMarker(new MarkerOptions().position(latlng).title("CU Gardens").snippet("This is the center of covenant university"));
			center.showInfoWindow();
			CameraPosition camposition = new CameraPosition(latlng, 18, 0, 0);
			googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camposition), 5000, null);
			
			//create the remaining markers for all other places in CU
			MapsPins.nameAllHallsWithMarkersInCU();
			
			
			//check if map is created succesfully or not
			if(googleMap==null){
				Toast.makeText(getApplicationContext(), "You need internet connectivity", Toast.LENGTH_LONG).show();
			}
			
			
			
		}
	
	
	
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		//startAgain
		if (presentService.equals("halls")) {
			loadHallServicesAgain();
		}else if(presentService.equals("building")){
			loadBuildingServicesAgain();
		}
		
		
		CheckEnableGPS();//i think i know why it was overlapping because after i checked 4 gps...i now registered in here in line 120
		//but now, i am unregistering it after i register it from my checkGps().
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		//criteria.setAccuracy(Criteria.ACCURACY_FINE);
		//criteria.setCostAllowed(false);
		locationManager.requestSingleUpdate(criteria, this, null);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		locationManager.removeUpdates(this);
	}

	private void loadBuildingServicesAgain() {
		// TODO Auto-generated method stub

			//it is never empty again
			googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			googleMap.clear();
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			googleMap.setMyLocationEnabled(true);
			
			
			
			//this is the lattitude and longitude for the Center of CU which is CU Gardens...lol..theres no name like dat o
			double latitude = 6.671318;
			double longitude = 3.158343;
			LatLng latlng = new LatLng(latitude, longitude);
			
			//create initial marker for center of CU and all other places....
			center = googleMap.addMarker(new MarkerOptions().position(latlng).title("CU Gardens").snippet("This is the center of covenant university"));
			center.showInfoWindow();
			CameraPosition camposition = new CameraPosition(latlng, 18, 0, 0);
			googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camposition), 5000, null);
			
			//create the remaining markers for all other places in CU
			MapsPins.nameAllBuildingsWithMarkersInCU();//this will add all the remamining markers...i created them in CuMapsPins class
			
			
			//check if map is created succesfully or not
			if(googleMap==null){
				Toast.makeText(getApplicationContext(), "You need internet connectivity", Toast.LENGTH_LONG).show();
			}
			
			
			
		
	
	}

	
	private void loadHallServicesAgain() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

			googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			googleMap.clear();
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			googleMap.setMyLocationEnabled(true);
			
			
			
			//this is the lattitude and longitude for the Center of CU which is CU Gardens...lol..theres no name like dat o
			double latitude = 6.671318;
			double longitude = 3.158343;
			LatLng latlng = new LatLng(latitude, longitude);
			
			//create initial marker for center of CU and all other places....
			center = googleMap.addMarker(new MarkerOptions().position(latlng).title("CU Gardens").snippet("This is the center of covenant university"));
			center.showInfoWindow();
			CameraPosition camposition = new CameraPosition(latlng, 18, 0, 0);
			googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camposition), 5000, null);
			
			//create the remaining markers for all other places in CU
			MapsPins.nameAllHallsWithMarkersInCU();//this will add all the remamining markers...i created them in CuMapsPins class
			
			
			//check if map is created succesfully or not
			if(googleMap==null){
				Toast.makeText(getApplicationContext(), "You need internet connectivity", Toast.LENGTH_LONG).show();
			}
	
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		
		//handled by me..
	}
	
	public void animateCameraToSearchPoint(double latitude, double longitude){
		LatLng latlng = new LatLng(latitude, longitude);
		CameraPosition camposition = new CameraPosition(latlng, 18, 0, 0);
		googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camposition), 1000, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.closestService:
			closestService();
			
			break;
			
		case R.id.searchbutton:
			final InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);//also edit the manifest
		    if(searchbox.getText().toString().length()==0){
				Toast.makeText(getApplicationContext(), "Please input a destination", Toast.LENGTH_SHORT).show();
			}else if(searchbox.getText().toString().equals("Cafe 2(restaurant)")){
				animateCameraToSearchPoint(6.672648, 3.162013);
				MapsPins.mark1.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Cafe 1(restaurant)")){
				animateCameraToSearchPoint(6.669420, 3.154046);
				MapsPins.mark2.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Daniel Hall")){
				animateCameraToSearchPoint(6.671748, 3.152420);
				MapsPins.mark3.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Peter Hall")){
				animateCameraToSearchPoint(6.668517, 3.154241);
				MapsPins.mark4.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Paul Hall")){
				animateCameraToSearchPoint(6.670583, 3.154035);
				MapsPins.mark5.showInfoWindow();
			}else if(searchbox.getText().toString().equals("John Hall")){
				animateCameraToSearchPoint(6.668509, 3.154282);
				MapsPins.mark6.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Joseph Hall")){
				animateCameraToSearchPoint(6.670693, 3.152936);
				MapsPins.mark7.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Dorcas Hall")){
				animateCameraToSearchPoint(6.671833, 3.157044);
				MapsPins.mark8.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Deborah Hall")){
				animateCameraToSearchPoint(6.671120, 3.156277);
				MapsPins.mark9.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Mary Hall")){
				animateCameraToSearchPoint(6.671961, 3.154641);
				MapsPins.mark10.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Esther Hall")){
				animateCameraToSearchPoint(6.669672, 3.155308);
				MapsPins.mark11.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Lydia Hall")){
				animateCameraToSearchPoint(6.672170, 3.155556);
				MapsPins.mark12.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Eagle Square")){
				animateCameraToSearchPoint(6.671337, 3.154831);
				MapsPins.mark13.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Senate Building")){
				animateCameraToSearchPoint(6.673427, 3.160407);
				MapsPins.mark14.showInfoWindow();
			}else if(searchbox.getText().toString().equals("College of Science and Technology")){
				animateCameraToSearchPoint(6.673591, 3.158770);
				MapsPins.mark15.showInfoWindow();
			}else if(searchbox.getText().toString().equals("College of Developmental Studies")){
				animateCameraToSearchPoint(6.671893, 3.160280);
				MapsPins.mark16.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Lecture Theatre 1")){
				animateCameraToSearchPoint(6.674590, 3.158812);
				MapsPins.mark17.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Lecture Theatre 2)")){
				animateCameraToSearchPoint(6.674301, 3.159319);
				MapsPins.mark18.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Chapel")){
				animateCameraToSearchPoint(6.669989, 3.158400);
				MapsPins.mark19.showInfoWindow();
			}else if(searchbox.getText().toString().equals("C_EDS Building")){
				animateCameraToSearchPoint(6.671427, 3.161445);
				MapsPins.mark20.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Chem Eng Building")){
				animateCameraToSearchPoint(6.674105, 3.157441);
				MapsPins.mark21.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Ict center (zenith)")){
				animateCameraToSearchPoint(6.674281, 3.156953);
				MapsPins.mark22.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Elect Eng Building")){
				animateCameraToSearchPoint(6.675831, 3.162474);
				MapsPins.mark23.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Civil Eng Building")){
				animateCameraToSearchPoint(6.674593, 3.162616);
				MapsPins.mark24.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Mech Eng Building")){
				animateCameraToSearchPoint(6.673431, 3.162699);
				MapsPins.mark25.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Health Center")){
				animateCameraToSearchPoint(6.668273, 3.155473);
				MapsPins.mark26.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Sport Complex")){
				animateCameraToSearchPoint(6.674932, 3.161646);
				MapsPins.mark27.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Mech Eng Building")){
				animateCameraToSearchPoint(6.673431, 3.162699);
				MapsPins.mark28.showInfoWindow();
			}else if(searchbox.getText().toString().equals("ALDC Building")){
				animateCameraToSearchPoint(6.672412, 3.162827);
				MapsPins.mark29.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Staff Quaters")){
				animateCameraToSearchPoint(6.670175, 3.162716);
				MapsPins.mark30.showInfoWindow();
			}else if(searchbox.getText().toString().equals("Center for Learning Rseources")){
				animateCameraToSearchPoint(6.670442, 3.157065);
				MapsPins.mark31.showInfoWindow();
			}
			
			break;
		}
	}

	private void closestService() {
		// TODO Auto-generated method stub
		 if(CheckEnableGPS()){
			 if (currentLat.equals("null") || currentLong.equals("null")) {
				 showtoast("Please wait a little while we get your current location");
				 
			 } else {
				 
				 if (presentService.equals("halls")) {
						closestHallServices();
						showtoast("Not implemented yet..have to sleep");
					}else if(presentService.equals("building")){
						closestBuildingServices();
					}
				 
				 showtoast("You are currently at lat: " + currentLat + " and longitude: " + currentLong );
				 
			 }
		 }
		
		
	}

	private void closestBuildingServices() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		double myLat = Double.valueOf(currentLat);
		double myLong = Double.valueOf(currentLong);
		
		Location locationA = new Location("point A");     
		locationA.setLatitude(myLat); 
		locationA.setLongitude(myLong);
		
		
		Location locationB = new Location("point B");
		locationB.setLatitude(6.672622); 
		locationB.setLongitude(3.161937);
		float distance1 = locationA.distanceTo(locationB) ;
		
		Location locationC = new Location("point C");
		locationB.setLatitude(6.669438); //this is just a test value
		locationB.setLongitude(3.153992);//this is just a test value
		float distance2 = locationA.distanceTo(locationC) ;
		
		
		Location locationD = new Location("point D");
		locationD.setLatitude(6.679593); //this is just a test value
		locationD.setLongitude(3.167382);//this is just a test value
		float distance3 = locationA.distanceTo(locationD) ;
		
		float places[] = new float[3];
		
		places[0] = distance1; 
		places[1] = distance2;
		places[2] = distance3;
		float shortest = places[0];
		int position = 0;
		
		for(int i = 0; i<places.length; i++){
			if(places[i] > shortest){
				shortest = places[i];
				
				position = i;
			}
		}
		
		if(position == 0){
			animateCameraToSearchPoint(6.672622 , 3.161937);
		} else if(position == 1){
			animateCameraToSearchPoint(6.669438, 3.153992);
		}else if(position == 2){
			animateCameraToSearchPoint(6.679593, 3.167382);
		}
		
		Toast.makeText(getApplicationContext(), "The closest building to you is "+shortest+" and it is in position "+position, Toast.LENGTH_LONG).show();
	
	}

	private void closestHallServices() {}
	
	private boolean CheckEnableGPS(){
	    boolean gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	       if(gps_enabled){
	    	   
	    	   return true;
	           //GPS Enabled
	        //Toast.makeText(this, "GPS is Enabled", Toast.LENGTH_LONG).show();
	       }else{
	    	   AlertDialog.Builder alertGpsEnabled = new AlertDialog.Builder(this);
	    	   alertGpsEnabled.setTitle("GPS needed");
	    	   alertGpsEnabled.setMessage("Please, you need to enable your GPS as it is a requirement for this application");
	    	   alertGpsEnabled.setCancelable(false);
	    	   alertGpsEnabled.setPositiveButton("Enable GPS in settings", new DialogInterface.OnClickListener() {
	   			
	   			@Override
	   			public void onClick(DialogInterface arg0, int arg1) {
	   				Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			        startActivity(intent);
	   			}
	   		});
	    	   alertGpsEnabled.show();
	    	   
	    	   return false;
	       }
	       
	       
	       
 }

	private void showtoast(String msg) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		currentLat = String.valueOf(location.getLatitude());
		currentLong = String.valueOf(location.getLongitude());
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}

