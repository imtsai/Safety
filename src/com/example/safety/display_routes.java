package com.example.safety;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class display_routes extends Activity {
	private WebView webView;
	private String resultstring;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.display_routes);
	    webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		resultstring = "www.google.com/maps/dir/" + getPointsFromServer();
		webView.loadUrl(resultstring);
	}

	public String getPointsFromServer(){
		HttpEntity resultentity = httpresponse.getEntity();
		InputStream inputstream = resultentity.getContent();
		Header contentencoding = httpresponse.getFirstHeader("Content-Encoding");
		if(contentencoding != null && contentencoding.getValue().equalsIgnoreCase("gzip")) 
			inputstream = new GZIPInputStream(inputstream);
		resultstring = convertStreamToString(inputstream);
		inputstream.close();
		return resultstring;
	}

	private String convertStreamToString(InputStream input){
		String line = "";
		StringBuilder total = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStream(input));
		try {
			while ((line = rd.readline() != null)
				total.append(line + "/"))
		} catch (Exception e){
			Toast.makeText(this, "Stream Exception", Toast.LENGTH_SHORT).show();
		}
		return total.toString();
	}


}
