package org.glenbrooknorth;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class GlenbrookNorth extends Activity implements OnClickListener {
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.map_button:
			Intent i = new Intent(this, Map.class);
			startActivity(i);
			break;
		case R.id.schedules_button:
			Intent j = new Intent(this, Schedules.class);
			startActivity(j);
			break;
		case R.id.sites_button:
			Intent k = new Intent(this, Sites.class);
			startActivity(k);
			break;
			//more buttons go here
		}
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Set up click listeners for all the buttons
        View mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(this);
        View schedulesButton = findViewById(R.id.schedules_button);
        schedulesButton.setOnClickListener(this);
        View sitesButton = findViewById(R.id.sites_button);
        sitesButton.setOnClickListener(this);
    }
    }