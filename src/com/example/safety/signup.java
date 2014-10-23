package com.example.safety;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;

public class signup extends Activity {
	EditText editTextEmail;
    EditText editTextPassword;
    CheckBox noSue;
    String email;
// 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.signup);
	    editTextEmail = (EditText)findViewById(R.id.signupEmail);
        editTextPassword = (EditText)findViewById(R.id.signupPassword);
        noSue = (CheckBox)findViewById(R.id.disclaimerCheckbox);
        email = editTextEmail.getText().toString();

	    

	}
	public void registration(View v) {
		CharSequence required = "berkeley.edu";
   	startActivity(new Intent(signup.this, enter_location.class));
   	ParseUser user = ParseUser.getCurrentUser();
   	user.setEmail(user.getEmail());
   	user.saveInBackground();
      if (!noSue.isChecked() && !email.contains(required)) {
    	  if (!email.contains(required)) {
//    		  to do: make a popup window that says you must be a berkeley student
    	  } else if (!noSue.isChecked()) {
//    		  to do: make a popup window that says you must agree to not sue us 
    	  }
      } else {
//    	  have it go to screen saying ___please go verify your email 
        	startActivity(new Intent(signup.this, login.class));

          signup.this.finish();

      }
	    
	}

}
