package com.example.safety;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class display_routes extends Activity {
	private WebView webView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.display_routes);
	    webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("https://goo.gl/maps/8CegB");
 
	}

}
