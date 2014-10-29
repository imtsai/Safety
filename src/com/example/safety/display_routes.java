package com.example.safety;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity.Header;
import android.webkit.WebView;
import android.widget.Toast;

public class display_routes extends Activity {
	private WebView webView;
	private String resultstring;
	private String wurl;
	private JSONObject jObject;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_routes);
		webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		try {
			jObject = readJsonPacket();
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			JSONArray jArray = jObject.getJSONArray("points");
			String directions = jArray.toString();
			resultstring = "www.google.com/maps/dir/" + directions;
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		webView.loadUrl(resultstring);
	}

	public JSONObject readJsonPacket() throws ClientProtocolException, IOException, JSONException{
		JSONObject jsonobj = new JSONObject();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppostreq = new HttpPost(wurl);
		StringEntity se = new StringEntity(jsonobj.toString());
		se.setContentType("application/json;charset=UTF-8");
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
		httppostreq.setEntity(se);
		HttpResponse httpresponse = httpclient.execute(httppostreq);

		HttpEntity resultentity = httpresponse.getEntity();
		InputStream inputstream = resultentity.getContent();
		org.apache.http.Header contentencoding = httpresponse.getFirstHeader("Content-Encoding");
		if(contentencoding != null && contentencoding.getValue().equalsIgnoreCase("gzip"))
			inputstream = new GZIPInputStream(inputstream);
		resultstring = convertStreamToString(inputstream);
		JSONObject jObject = new JSONObject(resultstring);
		inputstream.close();
		return jObject;
}

	private String convertStreamToString(InputStream input){
		String line = "";
		StringBuilder total = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(input)); 
		try {
			while ((line = rd.readLine()) != null) {
				total.append(line);
			}
		} catch (Exception e){
			Toast.makeText(this, "Stream Exception", Toast.LENGTH_SHORT).show();
		}
		return total.toString();
	}
}
