package com.example.resume.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	public ImageAdapter(Context c) {
		// TODO Auto-generated constructor stub
		mContext=c;
	}


	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
	}
	

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView;
		 if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(120, 150));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(10, 10 , 10, 10);
	        } else {
	            imageView = (ImageView) convertView;
	        }

	        imageView.setImageResource(mThumbIds[position]);
	        return imageView;

		
	}
	 // references to our images
    public Integer[] mThumbIds = {
         R.drawable.award,R.drawable.bcsc_1,R.drawable.bcsc_2,
         R.drawable.bcsc_hon_1,R.drawable.bcsc_hon_2,R.drawable.imceits_1,R.drawable.imceits_2,         
         R.drawable.grading,R.drawable.marks_first,R.drawable.grading_first,
         R.drawable.marks_second,R.drawable.grading_second,
         R.drawable.marks_third,R.drawable.grading_third,R.drawable.transcript,
         R.drawable.recommendation,R.drawable.ict
         
    };
    
    public String[] mThumbIdsStr = {
    		"award.jpg","bcsc_1.jpg","bcsc_2.jpg",
            "bcsc_hon_1.jpg","bcsc_hon_2.jpg","imceits_1.jpg","imceits_2.jpg",         
            "grading.jpg","marks_first.jpg","grading_first.jpg",
            "marks_second.jpg","grading_second.jpg",
            "marks_third.jpg","grading_third.jpg","transcript.jpg",
            "recommendation.jpg","ict.jpg"
    };


}

