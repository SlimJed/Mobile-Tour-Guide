package com.omadoye.visitcu;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPins extends MapActivity {
	//36pins currently
	static Marker mark1,mark2,mark3,mark4,mark5,mark6,mark7,mark8,mark9,mark10,mark11,mark12,mark13,mark14,mark15,mark16,mark17,mark18,mark19,mark20,mark21,mark22,mark23,
	mark24,mark25,mark26,mark27,mark28,mark29,mark30,mark31,mark32,mark33,mark34,mark35,mark36;
	
	static boolean isPinShowing = true;

	
	public static void nameAllBuildingsWithMarkersInCU(){
		//these are all the markers i am using on the map
		mark1 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.672648, 3.162013)).title("Cafe 2(restaurant)").snippet("This is the covenant university cafeteria 2 restaurant"));
		mark2 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.669420, 3.154046)).title("Cafe 1(restaurant)").snippet("This is the covenant university cafeteria 1 restaurant"));
		mark13 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671337, 3.154831)).title("Eagle Square").snippet("This is the Eagle Square"));
		mark14 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.673427, 3.160407)).title("Senate Building").snippet("This is the Senate Building"));
		mark15 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.673591, 3.158770)).title("College of Science and Technology").snippet("This is the College of Science and Technology"));
		mark16 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671893, 3.160280)).title("College of Developmental Studies").snippet("This is the College of Developmental Studies"));
		mark17 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.674590, 3.158812)).title("Lecture Theatre 1").snippet("This is the Lecture Theatre 1"));
		mark18 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.674301, 3.159319)).title("Lecture Theatre 2").snippet("This is the Lecture Theatre 2"));
		mark19 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.669989, 3.158400)).title("Chapel").snippet("This is the covenant university chapel"));
		mark20 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671427, 3.161445)).title("C_EDS Building").snippet("This is the C_EDS Building"));
		mark21 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.674105, 3.157441)).title("Chem Eng Building").snippet("This is the Chem Eng Building"));
		mark22 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.674281, 3.156953)).title("Ict center (zenith)").snippet("This is the Ict center (zenith)"));
		mark23 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.675831, 3.162474)).title("Elect Eng Building").snippet("This is the Elect Eng Building"));
		mark24 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.674593, 3.162616)).title("Civil Eng Building").snippet("This is the Civil Eng Building"));
		mark25 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.673431, 3.162699)).title("Mech Eng Building").snippet("This is the Mech Eng Building"));
		mark26 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.668273, 3.155473)).title("Health Center").snippet("This is the Health Center"));
		mark27 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.674932, 3.161646)).title("Sport Complex").snippet("This is the Sport Complex"));
		mark28 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.673431, 3.162699)).title("Mech Eng Building").snippet("This is the Mech Eng Building"));
		mark29 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.672412, 3.162827)).title("ALDC Building").snippet("This is the ALDC Building"));
		mark30 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.670175, 3.162716)).title("Staff Quaters").snippet("This is the Staff Quaters"));
		mark31 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.670442, 3.157065)).title("Center for Learning Rseources").snippet("This is the Center for Learning Rseources"));
		//mark.number = googleMap.addMarker(new MarkerOptions().position(new LatLng()).title().snippet());
		//mark.number = googleMap.addMarker(new MarkerOptions().position(new LatLng()).title().snippet());
		
		
	}
	
		
	public static void nameAllHallsWithMarkersInCU(){
		mark3 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671748, 3.152420)).title("Daniel Hall").snippet("This is Daniel Hall"));
		mark4 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.668517, 3.154241)).title("Peter Hall").snippet("This is Peter Hall"));
		mark5 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.670583, 3.154035)).title("Paul Hall").snippet("This is Paul Hall"));
		mark6 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.668509, 3.154282)).title("John Hall").snippet("This is John Hall"));
		mark7 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.670693, 3.152936)).title("Joseph Hall").snippet("This is Joseph Hall"));
		mark8 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671833, 3.157044)).title("Dorcas Hall").snippet("This is Dorcas Hall"));
		mark9 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671120, 3.156277)).title("Deborah Hall").snippet("This is Deborah Hall"));
		mark10 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.671961, 3.154641)).title("Mary Hall").snippet("This is Mary Hall"));
		mark11 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.669672, 3.155308)).title("Esther Hall").snippet("This is Esther Hall"));
		mark12 = googleMap.addMarker(new MarkerOptions().position(new LatLng(6.672170, 3.155556)).title("Lydia Hall").snippet("This is Lydia Hall"));
		
	}
	
	public static void togglePinVisibility(){
		if(isPinShowing){
			isPinShowing = false;//first set the boolean(flag) false
			center.setVisible(false);//this marker is for CU gardens.....i created it in in CuMaps class 
			mark1.setVisible(false);
			mark2.setVisible(false);
			mark3.setVisible(false);
			mark4.setVisible(false);
			mark5.setVisible(false);
			mark6.setVisible(false);
			mark7.setVisible(false);
			mark8.setVisible(false);
			mark9.setVisible(false);
			mark10.setVisible(false);
			mark11.setVisible(false);
			mark12.setVisible(false);
			mark13.setVisible(false);
			mark14.setVisible(false);
			mark15.setVisible(false);
			mark16.setVisible(false);
			mark17.setVisible(false);
			mark18.setVisible(false);
			mark19.setVisible(false);
			mark20.setVisible(false);
			mark21.setVisible(false);
			mark22.setVisible(false);
			mark23.setVisible(false);
			mark24.setVisible(false);
			mark25.setVisible(false);
			mark26.setVisible(false);
			mark27.setVisible(false);
			mark28.setVisible(false);
			mark29.setVisible(false);
			mark30.setVisible(false);
			mark31.setVisible(false);
			mark32.setVisible(false);
			mark33.setVisible(false);
			mark34.setVisible(false);
			mark35.setVisible(false);
			mark36.setVisible(false);
		}else{
			isPinShowing = true;//set the boolean(flag) to true
			center.setVisible(true);//this marker is for CU gardens.....i created it in in CuMaps class 
			mark1.setVisible(true);
			mark2.setVisible(true);
			mark3.setVisible(true);
			mark4.setVisible(true);
			mark5.setVisible(true);
			mark6.setVisible(true);
			mark7.setVisible(true);
			mark8.setVisible(true);
			mark9.setVisible(true);
			mark10.setVisible(true);
			mark11.setVisible(true);
			mark12.setVisible(true);
			mark13.setVisible(true);
			mark14.setVisible(true);
			mark15.setVisible(true);
			mark16.setVisible(true);
			mark17.setVisible(true);
			mark18.setVisible(true);
			mark19.setVisible(true);
			mark20.setVisible(true);
			mark21.setVisible(true);
			mark22.setVisible(true);
			mark23.setVisible(true);
			mark24.setVisible(true);
			mark25.setVisible(true);
			mark26.setVisible(true);
			mark27.setVisible(true);
			mark28.setVisible(true);
			mark29.setVisible(true);
			mark30.setVisible(true);
			mark31.setVisible(true);
			mark32.setVisible(true);
			mark33.setVisible(true);
			mark34.setVisible(true);
			mark35.setVisible(true);
			mark36.setVisible(true);
		}
		
		
	}
	
	
}
