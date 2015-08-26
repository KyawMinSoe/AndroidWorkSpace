package com.example.resume.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity{
	
	ProgressWheel pw;
	boolean running ;
	int progress = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		pw = (ProgressWheel) findViewById(R.id.progressBar);	
		
		final Runnable r = new Runnable() {
			public void run() {
				running = true;
				while(progress<361) {
					pw.incrementProgress();
					progress++;
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						if(progress==361)
						{
							running = false;
							
							 Intent i = new Intent(getApplicationContext(), MainActivity.class);
							 startActivity(i);
							 finish();
						}
					}
				}
				
				
			}
        };
        
        if(!running) {
			progress = 0;
			pw.resetCount();
			Thread s = new Thread(r);
			s.start();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		progress = 361;
		pw.stopSpinning();
		pw.resetCount();
		pw.setText("Start");
	}

}
