package com.example.safety;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends ActionBarActivity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     

       Intent first = new Intent(getApplicationContext(), login.class); 
        startActivity(first); //start login activity 

        
        
        
//        Intent first = new Intent(getApplicationContext(), login.class); 

        
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Parse.initialize(this, "vbUdwLH81SJSQqkMXPXAMe992HT5yTlO2ZB9RJLs", "MN860orJYIiDsOKG3kBmgqAtcOJ8ALC5lnP6KICD");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//
//
//        
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        if (id==R.id.goBackButton) {
//        	//go back to enter locatoin page
//        }
//        
//        WebView myWebView = (WebView) findViewById(R.id.webView);
//        myWebView.loadUrl("https://goo.gl/maps/oEbfz");
      
        return super.onOptionsItemSelected(item);
    }
}
