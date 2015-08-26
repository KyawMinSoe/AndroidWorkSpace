package com.example.resume.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Pop_up_myimage extends Activity implements OnClickListener{
	
	Button btn_close;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pop_up_myimage);
		
		btn_close = (Button) findViewById(R.id.btn_cancel);
		btn_close.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btn_close) {
			finish();
		}
		
	}

}
