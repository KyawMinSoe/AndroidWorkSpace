package com.example.resume.app;

import com.example.resume.app.TitleProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DiffAdapter extends BaseAdapter implements TitleProvider {

	private static final int VIEW1 = 0;
	private static final int VIEW2 = 1;
	private static final int VIEW3 = 2;
	private static final int VIEW4 = 3;
	private static final int VIEW5 = 4;	
	private static final int VIEW_MAX_COUNT = VIEW5 + 1;
	private final String[] names = { "PERSONAL DETAIL", "EDUCATION",
			 "CERTIFICATES", "REFERENCES", "TECHNOLOGIES"};

	private LayoutInflater mInflater;

	public DiffAdapter(Context context) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}

	@Override
	public int getViewTypeCount() {
		return VIEW_MAX_COUNT;
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int view = getItemViewType(position);
		if (convertView == null) {
			switch (view) {
			case VIEW1:
				convertView = mInflater.inflate(R.layout.personal_detail, null);
				break;
			case VIEW2:
				convertView = mInflater.inflate(R.layout.education, null);
				break;
			case VIEW3:
				convertView = mInflater.inflate(R.layout.certificates, null);
				break;
			case VIEW4:
				convertView = mInflater.inflate(R.layout.references, null);
				break;
			case VIEW5:
				convertView = mInflater.inflate(R.layout.technologies, null);
				break;
		  /*case VIEW6:
				convertView = mInflater.inflate(R.layout.project,null);
				break;
			case VIEW7:
				convertView = mInflater.inflate(R.layout.experiences, null);
				break;*/

			}
		}
		return convertView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.taptwo.android.widget.TitleProvider#getTitle(int)
	 */
	public String getTitle(int position) {
		return names[position];
	}

}
