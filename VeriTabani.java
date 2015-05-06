package com.example.myrehber;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VeriTabani extends Activity implements OnClickListener {

	Button kaydet,listele;
	EditText is, tel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_veri_tabani);
		
		is = (EditText) findViewById(R.id.etisim);
		tel = (EditText) findViewById(R.id.ettelefon);
		kaydet = (Button) findViewById(R.id.bKaydet);
		listele = (Button) findViewById(R.id.bListele);
		
		kaydet.setOnClickListener(this);
		listele.setOnClickListener(this);
		
		}

	private void silText(){
		is.setText("");
		tel.setText("");
		
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.bKaydet:

			boolean test = true;
			try {
				String kisi = is.getText().toString();
				String cep = tel.getText().toString();
                silText();
				Rehberim giris = new Rehberim(VeriTabani.this);
				giris.ac();
				giris.kayitYap(kisi,cep);
				giris.kapat();

			} catch (Exception e) {
				test = false;
				String hata = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("HATA!");
				TextView tv = new TextView(this);
				tv.setText(hata);
				d.setContentView(tv);
				d.show();
			} finally {
				if (test) {
					Dialog d = new Dialog(this);
					d.setTitle("BASARILI!");
					TextView tv = new TextView(this);
					tv.setText("Kayit Tamamlandi");
					d.setContentView(tv);
					d.show();
				}
			}

			break;
		case R.id.bListele:
			Intent i = new Intent("com.example.myrehber.LISTELE");
			startActivity(i);
			break;
		
		}
	}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
    super.onCreateOptionsMenu(menu);
	MenuInflater b=getMenuInflater();
	b.inflate(R.menu.my_menu, menu);
	return true;
                                               }



@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	switch(item.getItemId()){
	case R.id.myRehber:
	Intent i=new Intent("com.example.myrehber.MYREHBER");
	startActivity(i);
	break;
	
	case R.id.mguncelle:
		Intent s=new Intent("com.example.myrehber.GUNCELLE");
		startActivity(s);
		break;
		
	case R.id.msil:
		Intent e=new Intent("com.example.myrehber.SIL");
		startActivity(e);
		break;
		
	case R.id.exit:
		finish();
		break;	
		
	}
	return false;
}


}