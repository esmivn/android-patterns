package com.example.fyp_sensormanager;

import com.example.sensor.BatteryCheck;
import com.example.sensor.ConnectivityChecker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showConnectivityStatus();
		showBatteryStatus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void videoStream(View v){
		String result = SensorManager.videoStream(getApplicationContext());
		
		TextView resultTextView = (TextView) findViewById(R.id.result);
		resultTextView.setText("Result : "+result);
	}
	
	public void sendBigFile(View v){
		String result = SensorManager.sendBigFile(getApplicationContext());
		
		TextView resultTextView = (TextView) findViewById(R.id.result);
		resultTextView.setText("Result : "+result);
	}
	
	public void showConnectivityStatus(){

		TextView result = (TextView) findViewById(R.id.textViewConnection);
		
		if(ConnectivityChecker.isConnected(getApplicationContext())){
			if(ConnectivityChecker.isConnectedWifi(getApplicationContext())){
				result.setText("On Wifi");
			}else{
				result.setText("on 3G network");
			}
		}else{
			result.setText("Not connected");
		}
		
	}
	
	public void showBatteryStatus(){

		TextView result = (TextView) findViewById(R.id.textViewBattery);
		
		float batteryLife = BatteryCheck.getBatteryLife(getApplicationContext());
		
		result.setText("currently battery life ="+batteryLife);
		
	}

}
