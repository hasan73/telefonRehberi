package com.example.myrehber;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class listele extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listele);
		TextView tv = (TextView) findViewById(R.id.tvliste);
		Rehberim veri = new Rehberim(this);
		
		veri.ac();
		String d = veri.getirListe();
		veri.kapat();
		tv.setText(d);
		
	}
}

