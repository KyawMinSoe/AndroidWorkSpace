package com.example.resume.app;

import java.lang.Thread.State;
import java.util.ArrayList;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ViewFlow viewFlow;
	private ListView reflist;
	
	public static ArrayList<String> ref_name = new ArrayList<String>(); 
	public static ArrayList<String> ref_pos = new ArrayList<String>();
	public static ArrayList<String> ref_add = new ArrayList<String>();
	public static ArrayList<String> ref_email = new ArrayList<String>();
	public static ArrayList<String> ref_mobile = new ArrayList<String>();
	
	public TextView txtrefname,txtrefpos,txtrefadd,txtrefemail,txtrefmobile;
	
	RefAdapter rda ;
	
	ImageView img_pic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		DiffAdapter adapter = new DiffAdapter(this);
		viewFlow.setAdapter(adapter);
		TitleFlowIndicator indicator = (TitleFlowIndicator) findViewById(R.id.viewflowindic);
		indicator.setTitleProvider(adapter);
		viewFlow.setFlowIndicator(indicator);	
		
		img_pic = (ImageView) findViewById(R.id.img_pic);
		/*img_pic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Pop_up_myimage.class);				
				startActivity(i);				
			}
		});*/
		
		Toast.makeText(getApplicationContext(), "click on the photo to see large size", Toast.LENGTH_LONG).show();
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	 // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }			
        });
        
        InputReferenceData();
		
		reflist = (ListView)findViewById(R.id.ref_list);
		rda = new RefAdapter(this); 
		reflist.setAdapter(rda);
		reflist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
				final String mobile= ref_mobile.get(arg2);
				
				AlertDialog diag = new AlertDialog.Builder(MainActivity.this)
				.setTitle(mobile)
				.setIcon(R.drawable.telephone)				
				.setMessage("Would You Call to "+ref_name.get(arg2)+"?")
				.setPositiveButton("Call",
								new android.content.DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,	int which) {
										Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+mobile));
										startActivityForResult(i, 1111);
									}
								})
				.setNegativeButton("Cancle",
								new android.content.DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int which) {

									}
								}).create();
				diag.show();
			}
			
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1111 && resultCode == Activity.RESULT_OK) {
			Toast.makeText(this, data.getDataString(), Toast.LENGTH_LONG)
					.show();
		}
	}
			
	private void InputReferenceData() {
		
		ref_name = new ArrayList<String>(); 
		ref_pos = new ArrayList<String>();
		ref_add = new ArrayList<String>();
		ref_email = new ArrayList<String>();
		ref_mobile = new ArrayList<String>();
		
		ref_name.add("Daw Kay Thi Soe");
		ref_name.add("Dr. Daw Me Me Nge");
		ref_name.add("Mr. Paul Corcoran");
		ref_name.add("Zar Che Nyein");

		ref_pos.add("Team Lead, Cremeworkz Pte Ltd.");
		ref_pos.add("General Manager, Realistic Infotech Group Co.,Ltd.");
		ref_pos.add("CEO , Corcoran Holding Co, Ltd.");
		ref_pos.add("Software Engineer, EPROTEA FINEXUS Co.,Ltd");
	
	    ref_add.add("Block 347, Clementi Avenue 5, #03-64, 120347,Singapore.");
	    ref_add.add("No. 126, 39th Street, Second Floor, Lower Block, Kyauttader Township, Yangon, Myanmar.");
	    ref_add.add("197/3 Krabi Condotel, Koathong Road, Paknum Muang Krabi 81000");
	    ref_add.add("Rachadacity Condo : 92 Soi Paisan, Pracharachbumphen 7 Rd., Huaykhwang, Bangkok 10310 Thailand");
	
	    ref_email.add("kaythi@cremeworkz.com");
	    ref_email.add("ngengemyat@rig-info.com");
	    ref_email.add("ceo@roomallocator.com");
	    ref_email.add("znyein@gmail.com");
	
	    ref_mobile.add("+6590107019");
	    ref_mobile.add("+95973085840");
	    ref_mobile.add("+66810905301");
	    ref_mobile.add("+66838630192");
	}

	class RefAdapter extends ArrayAdapter {
		
		Activity context;

		public RefAdapter(Activity context) {
			super(context, R.layout.ref_layout,ref_name);
			this.context = context;
		}
		
		@Override
		public View getView(int pos, View convertView, ViewGroup parent) {
			LayoutInflater inf = context.getLayoutInflater();
			View row = inf.inflate(R.layout.ref_layout, null);
			
			txtrefname = (TextView) row.findViewById(R.id.ref_name);
			txtrefpos = (TextView) row.findViewById(R.id.ref_pos);
			txtrefadd = (TextView) row.findViewById(R.id.ref_add);
			txtrefemail= (TextView) row.findViewById(R.id.ref_email);
			txtrefmobile = (TextView) row.findViewById(R.id.ref_mobile);
			
			txtrefname.setText(ref_name.get(pos).toString());
			txtrefpos.setText(ref_pos.get(pos).toString());
			txtrefadd.setText(ref_add.get(pos).toString());
			txtrefemail.setText(ref_email.get(pos).toString());
			txtrefmobile.setText(ref_mobile.get(pos).toString());
			
			return row;
		}
	}

	
	public void ShowLargeSize(View v) {
		
		Intent i = new Intent(MainActivity.this, Pop_up_myimage.class);				
		startActivity(i);
		
	}
	
			
	
}
