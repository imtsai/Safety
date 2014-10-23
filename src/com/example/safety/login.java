package com.example.safety;

import android.app.Activity;
import android.os.Bundle;

import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class login extends Activity {
	private String username,password;
    private Button ok;
    private Button signup;
    private EditText editTextUsername,editTextPassword;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.init);
	    ok = (Button)findViewById(R.id.login);
	    signup = (Button)findViewById(R.id.signup);
	    

        editTextUsername = (EditText)findViewById(R.id.loginEmail);
        editTextPassword = (EditText)findViewById(R.id.loginPassword);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            editTextUsername.setText(loginPreferences.getString("email", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
	}

	

	public void checkVerification(View view) {
		// TODO check if registered
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);

        username = editTextUsername.getText().toString();
        password = editTextPassword.getText().toString();
        if (saveLoginCheckBox.isChecked()) {
            loginPrefsEditor.putBoolean("saveLogin", true);
            loginPrefsEditor.putString("username", username);
            loginPrefsEditor.putString("password", password);
            loginPrefsEditor.commit();
        } else {
            loginPrefsEditor.clear();
            loginPrefsEditor.commit();
        }
      
        //check server if registered
		startActivity(new Intent(login.this, enter_location.class));
        login.this.finish();
		
	}
	
	public void SignupProcess(View view) {
		startActivity(new Intent(login.this, signup.class));
        login.this.finish();


	}

}
