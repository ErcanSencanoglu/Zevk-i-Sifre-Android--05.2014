package com.ercansencan.zevk_isifre;
import com.ercansencan.zevk_isifre.R;
import com.ercansencan.zevk_isifre.KategoriSekme;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;





public class MainActivity extends Activity {

	Button btnGame1;
	Button btnGame2;
	Button btnGame3;
	Button btnGame4;
	Button btnGame5;
	Button btnDigerleri;
	Button btnTumu;
	Button btnDuyurular;
	Button btnCikis;
	
	static ProgressDialog pdialog;
	static VeriTabani DB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnGame1 = (Button)findViewById(R.id.btnGame1);
		btnGame2 = (Button)findViewById(R.id.btnGame2);
		btnGame3 = (Button)findViewById(R.id.btnGame3);
		btnGame4 = (Button)findViewById(R.id.btnGame4);
		btnGame5 = (Button)findViewById(R.id.btnGame5);
		btnDigerleri = (Button)findViewById(R.id.btnDigerleri);
		btnTumu = (Button)findViewById(R.id.btnTumu);
		btnDuyurular = (Button)findViewById(R.id.btnDuyurular);
		btnCikis = (Button)findViewById(R.id.btnCikis);	
		pdialog = new ProgressDialog(this);
	}

	public void btnClickCikis(final View view){
		System.exit(0);
	}

	public void btnSekme(final View view){
		if(view == btnCikis){System.exit(0);return;}
		String cs = getResources().getString(R.string.loading);
		pdialog.setCancelable(true);
		pdialog.setMessage(cs);
		pdialog.show();
		Thread myThread = new Thread(){
			public void run(){	
			try{
			DB = new VeriTabani();
			String kategori = ((Button)view).getText().toString();
			Intent theIntent = new Intent(getApplication(), KategoriSekme.class);
			theIntent.putExtra("kategori", kategori);
			startActivity(theIntent);
				}catch(Exception e){
					String cs2 = getResources().getString(R.string.hataMessageTwo);
					Toast.makeText(MainActivity.this, cs2, Toast.LENGTH_SHORT).show();
					System.exit(1);
				}}};
				
				if(isOnline()){
					myThread.start();
				}
				else{
					internetYok();
				}
			
		//int boslukNerede= ((Button)view).getText().toString().indexOf(" ");
		//String kategori = ((Button)view).getText().toString().substring(boslukNerede,((Button)view).getText().toString().length());
		
	}
	
	private boolean isOnline()
	{
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	 
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	 
	    if (netInfo != null && netInfo.isConnectedOrConnecting())
	    {
	        return true;
	    }
	    return false;
	}

	@SuppressWarnings("deprecation")
	private void internetYok(){
		
		String hata = getResources().getString(R.string.hata);
		String hataMessage = getResources().getString(R.string.hataMessage);
		String hataTamam = getResources().getString(R.string.hataTamam);
		pdialog.cancel();
		AlertDialog alerDialog = new AlertDialog.Builder(MainActivity.this).create();
		alerDialog.setTitle(hata);
		alerDialog.setMessage(hataMessage);	
		alerDialog.setButton(hataTamam, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		alerDialog.show();
	}
	
	
}
