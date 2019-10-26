package com.ercansencan.zevk_isifre;
import com.ercansencan.zevk_isifre.R;
import com.ercansencan.zevk_isifre.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Acilis2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acilis2);
		
		Thread acilis = new Thread(){
			
			public void run(){
				
				try{
					sleep(1400);
					Intent intent = new Intent(Acilis2.this, MainActivity.class);
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
		
		
		
	}


}
