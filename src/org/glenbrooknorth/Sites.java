package org.glenbrooknorth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class Sites extends Activity implements OnClickListener {
	
	private static final String TAG = "Sites";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sites);
		
		View moodleButton = findViewById(R.id.moodle_button);
        moodleButton.setOnClickListener(this);
        View homeLogicButton = findViewById(R.id.homelogic_button);
        homeLogicButton.setOnClickListener(this);
        View gbnpageButton = findViewById(R.id.gbnpage_button);
        gbnpageButton.setOnClickListener(this);
        View webassignButton = findViewById(R.id.webassign_button);
        webassignButton.setOnClickListener(this);
	}
	@Override  
	public boolean onCreateOptionsMenu(Menu menu) {  
		menu.add(R.string.homelogic);  
	    menu.add(R.string.moodle);
	    menu.add(R.string.gbnpage);
	    return super.onCreateOptionsMenu(menu);  
	 }
	public void onClick(View v) {
		
		Log.i(TAG, "why isn't this working");
		
		switch (v.getId()) {
		case R.id.moodle_button:
			String moodlesite = "http://gbn-moodle.glenbrook225.org/moodle/login/index.php";
			Intent moodle = new Intent(Intent.ACTION_VIEW);
			moodle.setData(Uri.parse(moodlesite));
			startActivity(moodle);
			break;
		case R.id.gbnpage_button:
			String gbnpagesite = "http://www.glenbrook225.org/north/Pages/default.aspx";
			Intent gbnpage = new Intent(Intent.ACTION_VIEW);
			gbnpage.setData(Uri.parse(gbnpagesite));
			startActivity(gbnpage);
			break;
		case R.id.homelogic_button:
			String homelogicsite = "http://hl.glenbrook225.org/homelogic/";
			Intent homelogic = new Intent(Intent.ACTION_VIEW);
			homelogic.setData(Uri.parse(homelogicsite));
			startActivity(homelogic);
			break;
		case R.id.webassign_button:
			String webassignsite = "https://www.webassign.net/login.html";
			Intent webassign = new Intent(Intent.ACTION_VIEW);
			webassign.setData(Uri.parse(webassignsite));
			startActivity(webassign);
			break;
			//more buttons go here
		}
	}
}
