package com.example.myrehber;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class guncelle extends Activity implements OnClickListener {
	EditText gid,gis,gtel;
	Button gnc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guncelle);
		gid=(EditText)findViewById(R.id.etid2);
		gis=(EditText)findViewById(R.id.etisim2);
		gtel=(EditText)findViewById(R.id.ettel2);
		gnc=(Button)findViewById(R.id.btguncelle);
		gnc.setOnClickListener(this);
	}
	
	private void silText(){
		gtel.setText("");
		gis.setText("");
		gid.setText("");
	}
	
	
		@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			boolean test2;
			String mIsim = gis.getText().toString();
			String mTel = gtel.getText().toString();
			String sId = gid.getText().toString();
			long lId = Long.parseLong(sId);
            silText();
			Rehberim rh = new Rehberim(this);
			rh.ac();
		    test2=rh.kayitGuncelle(lId, mIsim, mTel);
			rh.kapat();
            if(!test2){
			Dialog d = new Dialog(this);
			d.setTitle("GEÇERSÝZ KAYIT ID");
			TextView tv = new TextView(this);
			tv.setText("Rehberinizde böyle bir kayýt bulunmamaktadýr");
			d.setContentView(tv);
			d.show();}
            else{

				Dialog d = new Dialog(this);
				d.setTitle("BAÞARILI");
				TextView tv = new TextView(this);
				tv.setText("KAYIT GÜNCELLENDÝ");
				d.setContentView(tv);
				d.show();
			
				}

	}
	
}
