package org.glenbrooknorth;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Schedules extends Activity {
	private SharedPreferences prefs;
	private EditText firstBlock;
	private EditText secondBlock;
	private EditText thirdBlock;
	private EditText fourthBlock;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedulea);
		
		Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View r) {
				onEmail();
			}

			private void onEmail() {
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

		        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My GBN Schedule");

		        emailIntent.setType("plain/text");
		        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");

		        startActivity(emailIntent);
				
			}
		});
		
        
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		String firstString = prefs.getString("firstblock", "");
		String secondString = prefs.getString("secondblock", "");
		String thirdString = prefs.getString("thirdblock", "");
		String fourthString = prefs.getString("fourthblock", "");
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner_lunch);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.lunch_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    
	    firstBlock = (EditText) findViewById(R.id.editText1);
	    firstBlock.setText(firstString);
	    secondBlock = (EditText) findViewById(R.id.editText2);
	    secondBlock.setText(secondString);
	    thirdBlock = (EditText) findViewById(R.id.editText3);
	    thirdBlock.setText(thirdString);
	    fourthBlock = (EditText) findViewById(R.id.editText4);
	    fourthBlock.setText(fourthString);
	}
	@Override  
	public boolean onCreateOptionsMenu(Menu menu) {  
	    menu.add(R.string.B);
	    return super.onCreateOptionsMenu(menu);  
	 }
	
	
	//call this when the save button is hit
	private void onSave(){
		Editor edit = prefs.edit();
		String firstString = firstBlock.getText().toString();
		String secondString = secondBlock.getText().toString();
		String thirdString = thirdBlock.getText().toString();
		String fourthString = fourthBlock.getText().toString();
		
		edit.putString("firstBlock", firstString);
		edit.putString("secondBlock", secondString);
		edit.putString("thirdBlock", thirdString);
		edit.putString("fourthBlock", fourthString);
		
		//do this for the rest of the blocks and put the code here
		
		edit.commit();
	
	}
	protected void onResume()
	{
	   super.onResume();

	   	firstBlock = (EditText) findViewById(R.id.editText1);
	    firstBlock.setText(firstString);
	    secondBlock = (EditText) findViewById(R.id.editText2);
	    secondBlock.setText(secondString);
	    thirdBlock = (EditText) findViewById(R.id.editText3);
	    thirdBlock.setText(thirdString);
	    fourthBlock = (EditText) findViewById(R.id.editText4);
	    fourthBlock.setText(fourthString);
	   
	}

}