package com.example.safety;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
	
	public void Restart(View view) {
		setContentView(R.layout.enter_location);
	}
	
	public void callBearWalk(View view) {
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:5106429255"));
		startActivity(intent);
	}
	
	public void showShuttleSchedule(View view) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bearwalk.berkeley.edu/shuttles/"));
		startActivity(browserIntent);
	}
	public void settings(View view){
		startActivity(new Intent(enter_location.this, user_settings.class));
//        enter_location.this.finish();
	}

}
