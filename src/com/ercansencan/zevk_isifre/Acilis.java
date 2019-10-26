package com.ercansencan.zevk_isifre;
import com.ercansencan.zevk_isifre.R;
import com.ercansencan.zevk_isifre.Acilis2;


import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class Acilis extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acilis);
		
		try{
		String s�zler[] = {"Sentence 1",
							"Sentence 2",
							"Sentence 3"
							};
		
		TextView txt = (TextView)findViewById(R.id.textView1);
		Random karisikSayi = new Random();
		txt.setText("\""+s�zler[karisikSayi.nextInt(s�zler.length)]+"\"");
		
		Thread acilis = new Thread(){
				public void run(){	
				try{
					sleep(4000);
					Intent intent = new Intent(Acilis.this, Acilis2.class);
					startActivity(intent);
				} catch (InterruptedException e) {
					System.exit(0);
				}
				finally{
					finish();
				}//try sonu
				
			}//run sonu
		};//thread sonu
		
		acilis.start();
	}catch(Exception e){
		Intent intent = new Intent(Acilis.this, Acilis2.class);
		startActivity(intent);
	}
	
	}//onCreate sonu

	

}//class sonu
