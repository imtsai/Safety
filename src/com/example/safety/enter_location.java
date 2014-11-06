package com.example.safety;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class enter_location extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.enter_location);

	}
	public void showResults(View view) {
	    setContentView(R.layout.routes_results);

	}

}
