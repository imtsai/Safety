package com.example.safety;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;


public class user_settings extends Activity {

	private Spinner spinnerGender;
	private Spinner spinnerSortSetting;
	private String selectedGender;
	private String selectedSortSetting;

	private EditText physical;
	private EditText theft;
	private EditText sexual;
	
	private String PhysicalPreference;
	private String SexualPreference;
	private String TheftPreference;



	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.user_settings);
		
		super.onCreate(savedInstanceState);

		spinnerGender = (Spinner) findViewById(R.id.Gender);
		spinnerSortSetting = (Spinner) findViewById(R.id.SortSetting);

		physical = (EditText) findViewById(R.id.Physical);
		theft = (EditText) findViewById(R.id.Theft);
		sexual = (EditText) findViewById(R.id.Sexual);
		
		

	}



	public void onPause()
	{
		// get Spinner Slected text here
		selectedGender = spinnerGender.getSelectedItem().toString();
		selectedSortSetting = spinnerSortSetting.getSelectedItem().toString();
		
		PhysicalPreference = physical.getText().toString();
		SexualPreference = sexual.getText().toString();
		TheftPreference = theft.getText().toString();



		//Create SharedPreferences to store selected value

		SharedPreferences spinnerPrefs = this.getSharedPreferences("spinnerPrefs", 
				MODE_WORLD_READABLE);
		SharedPreferences.Editor prefsEditor = spinnerPrefs.edit();
		prefsEditor.putString("Gender", selectedGender);
		prefsEditor.putString("Sort Setting", selectedSortSetting);
		
		prefsEditor.putString("Physical", PhysicalPreference);
		prefsEditor.putString("Sexual", SexualPreference);
		prefsEditor.putString("Theft", TheftPreference);



		prefsEditor.commit();

		super.onPause();

	}


	public String getGender() {
		return selectedGender;
	}
	public String getSortSetting() {
		return selectedSortSetting;
	}
	public String getPhysicalPreference() {
		return PhysicalPreference;
	}
	public String getSexualPreference() {
		return SexualPreference;
	}
	public String getTheftPreference() {
		return TheftPreference;
	}
	
	


	
	


}
