package com.example.myrehber;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sil extends Activity implements OnClickListener{
	EditText silKayit;
    Button bsil;
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sil);
		silKayit=(EditText)findViewById(R.id.etid3);
		bsil=(Button)findViewById(R.id.btid3);
		bsil.setOnClickListener(this);
	}
	
	private void silText(){
		silKayit.setText("");
		}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		    boolean t;
			String sid=silKayit.getText().toString();
			long lId=Long.parseLong(sid);
			silText();
			Rehberim s = new Rehberim(this);
			s.ac();
			t=s.kayitSil(lId);
			s.kapat();
		
            if(!t){
			Dialog d = new Dialog(this);
			d.setTitle("GE�ERS�Z KAYIT ID");
			TextView tv = new TextView(this);
			tv.setText("Rehberinizde b�yle bir kay�t bulunmamaktad�r");
			d.setContentView(tv);
			d.show();}
            else{
				Dialog d = new Dialog(this);
				d.setTitle("BA�ARILI");
				TextView tv = new TextView(this);
				tv.setText("Kay�t silindi");
				d.setContentView(tv);
				d.show();
		}
	}
}

