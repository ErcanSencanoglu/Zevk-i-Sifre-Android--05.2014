package com.ercansencan.zevk_isifre;
import com.ercansencan.zevk_isifre.R;
import com.ercansencan.zevk_isifre.MainActivity;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class KategoriSekme extends Activity {

	private String kategori;
	
	private TextView txt;
	private TextView txt30;
	private TextView txt5;
	private TextView txtDeneme;
	private TextView txtFacebook;
	private TextView txtTwitter;
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kategori_sekme);
		
		Thread myThread = new Thread(){
			public void run(){	
			try{
				sleep(550);
				}catch(Exception e){}}};
		
		Intent theIntent = getIntent();
		kategori = theIntent.getStringExtra("kategori");
		
		txt5 = (TextView)findViewById(R.id.textView5);
		txtFacebook = (TextView)findViewById(R.id.textView2);
		txtTwitter = (TextView)findViewById(R.id.textView4);
		
		txt = (TextView)findViewById(R.id.textView1);
		txt.setText(kategori);
		
		txt30 = (TextView)findViewById(R.id.textView30);
		txtStringDuzenle2();
		
		txtDeneme = (TextView)findViewById(R.id.textView3);
		
		list = (ListView)findViewById(R.id.listView1);
		myThread.start();
		
			internetVar();
	}
	
	

	private void txtStringDuzenle2(){
		
		if(kategori.equals("All of") || kategori.equals("T�m�")){
			txtFacebook.setText("Facebook:");
			txtTwitter.setText("Twitter");
			txt30.setText("https://www.facebook.com/");
			txt5.setText("https://twitter.com/");
		}
		else if(kategori.equals("Digerleri") || kategori.equals("Others")){
			txtFacebook.setText("Facebook:");
			txtTwitter.setText("Twitter");
			txt30.setText("https://www.facebook.com/);
			txt5.setText("https://twitter.com/");
		}
		else if(kategori.equals("Duyurular") || kategori.equals("Announcements")){
			txtFacebook.setText("Facebook:");
			txtTwitter.setText("Twitter");
			txt30.setText("https://www.facebook.com/");
			txt5.setText("https://twitter.com/");
		}
	}
	
	private void internetVar(){
		//ArrayList veriler;
		final List<Sifreler> veriler;
		//VeriTabani DB = new VeriTabani();
		if(kategori.equals("Game1") || kategori.equals("Game2") ||
				kategori.equals("Mfs") || kategori.equals("Game3") ||
				kategori.equals("Game5")){
				veriler = getData(MainActivity.DB.getKategori(kategori));
		}
		else if(kategori.equals("All of") || kategori.equals("T�m�")){
			veriler = getData2(MainActivity.DB.getHepsiniGetir());
		}
		else if(kategori.equals("Digerleri") || kategori.equals("Others")){
			veriler = getData2(MainActivity.DB.getDigerleri());
		}
		else if(kategori.equals("Duyurular") || kategori.equals("Announcements")){
			veriler = getData3(MainActivity.DB.getDuyurular());
		}else {
			veriler = getData3(MainActivity.DB.getDuyurular());
			//veriler = new ArrayList<String>();
		}
		
		OzelAdapter adaptorumuz=new OzelAdapter(this, veriler);
		   list.setAdapter(adaptorumuz);
		//list.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, veriler)); 
			MainActivity.pdialog.dismiss();
		}
	
	private List<Sifreler> getData(String elemanlar[][]){
		
		final List<Sifreler> kisiler=new ArrayList<Sifreler>();
		String eleman="",eleman2="";
		
		txtDeneme.setText(R.string.userName);
		String userName = txtDeneme.getText().toString();
		
		txtDeneme.setText(R.string.password);
		String password = txtDeneme.getText().toString();
		
		txtDeneme.setText(R.string.date);
		String date = txtDeneme.getText().toString();
		
		for (int i = elemanlar.length; i >= 0; i--) {
			
			eleman="";eleman2="";
			try {
				eleman += userName + "\t" + elemanlar[i][0].toString();
				eleman += "\n"+password + "\t" + elemanlar[i][1].toString();
				eleman2 = date+"  " + elemanlar[i][2].toString();
				kisiler.add(new Sifreler(eleman, eleman2));
				}
				catch (Exception e) {
				e.printStackTrace();
			}
		}
		return kisiler;
	}
	
	private List<Sifreler> getData2(String elemanlar[][]){
		
		final List<Sifreler> kisiler=new ArrayList<Sifreler>();
		String eleman="",eleman2="";
		
		txtDeneme.setText(R.string.userName);
		String userName = txtDeneme.getText().toString();
		
		txtDeneme.setText(R.string.password);
		String password = txtDeneme.getText().toString();
		
		txtDeneme.setText(R.string.date);
		String date = txtDeneme.getText().toString();
		
		txtDeneme.setText(R.string.Categories);
		String Categories = txtDeneme.getText().toString();
		
		for (int i = elemanlar.length; i >= 0; i--) {
			eleman="";eleman2="";
			/*try {
				eleman += R.string.userName + "\t" + elemanlar[i][0];
				eleman += R.string.password + "\t" + elemanlar[i][1];
				eleman += R.string.Categories + "\t" + elemanlar[i][2];
				eleman += R.string.date + "\t" + elemanlar[i][3];
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		
			try {
				eleman +=  userName 	   + "\t" + elemanlar[i][0].toString();
				eleman += "\n"+password 	   + "\t" + elemanlar[i][1].toString();
				eleman += "\n"+Categories   + "\t" + elemanlar[i][2].toString();
				eleman2 = date 		   +  elemanlar[i][3].toString();
				kisiler.add(new Sifreler(eleman, eleman2));}
				catch (Exception e) {
				e.printStackTrace();
			}
		}
		return kisiler;
	}
	
	private List<Sifreler> getData3(String elemanlar[][]){
		
		final List<Sifreler> kisiler=new ArrayList<Sifreler>();
		String eleman="",eleman2="";
		
		txtDeneme.setText(R.string.date);
		String date = txtDeneme.getText().toString();
		
		
		for (int i = elemanlar.length; i >= 0; i--) {
			try {
				eleman = elemanlar[i][0].toString();
				eleman2 = date+  elemanlar[i][1].toString();
				kisiler.add(new Sifreler(eleman, eleman2));
			} catch (Exception e) {
				// TODO: handle exception
			}		
			
		}
		return kisiler;	
	}
		
	
	
		
	
	
	public class OzelAdapter extends BaseAdapter {
		 
	    private LayoutInflater mInflater;
	    private List<Sifreler> mKisiListesi;
	 
	    public OzelAdapter(Activity activity, List<Sifreler> kisiler) {
	        //XML'i al�p View'a �evirecek inflater'� �rnekleyelim
	        mInflater = (LayoutInflater) activity.getSystemService(
	                Context.LAYOUT_INFLATER_SERVICE);
	        //g�sterilecek listeyi de alal�m
	        mKisiListesi = kisiler;
	    }
	 
	    @Override
	    public int getCount() {
	        return mKisiListesi.size();
	    }
	 
	    @Override
	    public Sifreler getItem(int position) {
	        //��yle de olabilir: public Object getItem(int position)
	        return mKisiListesi.get(position);
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return position;
	    }
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View satirView;
	 
	        satirView = mInflater.inflate(R.layout.satir_layout, null);
	        TextView textView1 = 
	                (TextView) satirView.findViewById(R.id.textView1); 
	        TextView textView2 = 
	                (TextView) satirView.findViewById(R.id.textView2);
	 
	        Sifreler kisi = mKisiListesi.get(position);
	 
	        textView1.setText(kisi.getVeri());
	        textView2.setText(kisi.getTarih());
	       
	        return satirView;
	    }
	    
	    
	}
		
	
}
