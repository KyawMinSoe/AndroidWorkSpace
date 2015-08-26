package com.example.resume.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ImageView;
 
public class FullImageActivity extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);
 
        // get intent data
        Intent i = getIntent();
 
        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);       
        
        WebView WV = (WebView)findViewById (R.id.webView1);
		WV.loadUrl("file:///android_asset/"+imageAdapter.mThumbIdsStr[position]);	
        WV.getSettings().setBuiltInZoomControls(true);
        WV.getSettings().setSupportZoom(true);
        
    }

	
    
   
}
