package com.omadoye.visitcu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
	public ImageAdapter (Context context){
		mContext=context;
    	
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThubIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup parent) {
		
		ImageView imageview;
		
		if(convertview == null)
		{
			 imageview =new ImageView(mContext);
			 imageview.setLayoutParams(new GridView.LayoutParams(150,150));
			 imageview.setScaleType(ScaleType.CENTER_CROP);
             imageview.setPadding(5,5,5,5);
		} 
		else{
			imageview= (ImageView) convertview;
			}
		imageview.setImageResource(mThubIds[position]);
		return imageview;
		
		
			}
		public Integer[] mThubIds ={
				R.drawable.cu1,R.drawable.cu28,R.drawable.cu55,
    			R.drawable.cu2,R.drawable.cu29,R.drawable.cu56,
    			R.drawable.cu3,R.drawable.cu30,R.drawable.cu57,
    			R.drawable.cu4,R.drawable.cu31,R.drawable.cu58,
    			R.drawable.cu5,R.drawable.cu32,R.drawable.cu59,
    			R.drawable.cu6,R.drawable.cu33,R.drawable.cu60,
    			R.drawable.cu7,R.drawable.cu34,R.drawable.cu61,
    			R.drawable.cu8,R.drawable.cu35,R.drawable.cu62,
    			R.drawable.cu9,R.drawable.cu36,R.drawable.cu63,
    			R.drawable.cu10,R.drawable.cu37,R.drawable.cu64,
    			R.drawable.cu11,R.drawable.cu38,R.drawable.cu65,
    			R.drawable.cu12,R.drawable.cu39,R.drawable.cu66,
    			R.drawable.cu13,R.drawable.cu40,//R.drawable.cu67,
    			R.drawable.cu14,R.drawable.cu41,//R.drawable.cu68,
    			R.drawable.cu15,R.drawable.cu42,//R.drawable.cu69,
    			R.drawable.cu16,R.drawable.cu43,R.drawable.cu70,
    			R.drawable.cu17,R.drawable.cu44,R.drawable.cu71,
    			R.drawable.cu18,R.drawable.cu45,R.drawable.cu72,
    			R.drawable.cu19,R.drawable.cu46,R.drawable.cu73,
    			R.drawable.cu20,R.drawable.cu47,R.drawable.cu74,
    			R.drawable.cu21,R.drawable.cu48,R.drawable.cu75,
    			R.drawable.cu22,R.drawable.cu49,R.drawable.cu76,
    			R.drawable.cu23,R.drawable.cu50,R.drawable.cu77,
    			R.drawable.cu24,R.drawable.cu51,R.drawable.cu78,
    			R.drawable.cu25,R.drawable.cu52,R.drawable.cu79,
    			R.drawable.cu26,R.drawable.cu53,R.drawable.cu80,
    			R.drawable.cu27,R.drawable.cu54,R.drawable.cu81,
    			
    			R.drawable.cu82,R.drawable.cu90,R.drawable.cu98,
    			R.drawable.cu83,R.drawable.cu91,R.drawable.cu99,
    			R.drawable.cu84,R.drawable.cu92,R.drawable.cu100,
    			R.drawable.cu85,R.drawable.cu93,
    			R.drawable.cu86,R.drawable.cu94,
    			R.drawable.cu87,R.drawable.cu95,
    			R.drawable.cu88,R.drawable.cu96,
				
};
		

}
