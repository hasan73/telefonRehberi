package com.example.myrehber;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Rehberim {
	
	public static final String KEY_ID = "_id";
	public static final String KEY_AD = "kisiler_ad";
	public static final String KEY_TEL = "kisiler_tel";
	
	private static final String DATABASE_NAME = "rehberdb";
	private static final String DATABASE_TABLE = "kisilerTablo";
	private static final int DATABASE_VERSION = 1;
	
	private Veritabanim vt;
	private final Context cxt;
	private SQLiteDatabase vtn;
	
	
	private static class Veritabanim extends SQLiteOpenHelper{

		public Veritabanim(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_AD + " TEXT NOT NULL, " +
					KEY_TEL + " TEXT NOT NULL);"
			);	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}		
	}
	
	public Rehberim (Context c){
		cxt = c;
	}

	public Rehberim ac() throws SQLException{
		vt = new Veritabanim(cxt);
		vtn = vt.getWritableDatabase();
		return this;
	}
	
	 public void kapat(){
		 vt.close();
	 }

	public long kayitYap(String ad, String tel) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_AD, ad);
		cv.put(KEY_TEL, tel);
		return vtn.insert(DATABASE_TABLE, null, cv);
	}

	public String getirListe() {
		// TODO Auto-generated method stub
		String[] sutun = new String[]{ KEY_ID, KEY_AD, KEY_TEL};
		Cursor c = vtn.query(DATABASE_TABLE,sutun, null, null, null, null, null);
		String r = "";
		
		int iSut = c.getColumnIndex(KEY_ID);
		int iAd = c.getColumnIndex(KEY_AD);
		int iTel = c.getColumnIndex(KEY_TEL);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			r = r + c.getString(iSut) + "-" + c.getString(iAd) + " " + c.getString(iTel) + "\n";
		}
		
		return r;
	}
	
	public boolean kayitGuncelle(long l, String mad, String mtel) {
		// TODO Auto-generated method 
		String[] s=new String[]{KEY_ID};
		Cursor cur=vtn.query(DATABASE_TABLE,s,KEY_ID + "=" + l,null,null,null,null);
		boolean var = (cur.getCount() > 0);
		if(var){
		ContentValues cv2 = new ContentValues();
		cv2.put(KEY_AD, mad);
		cv2.put(KEY_TEL, mtel);
		vtn.update(DATABASE_TABLE, cv2, KEY_ID + "=" + l, null);
		return true;
		}else{
			return false;
		}
      }
	
	public boolean kayitSil(long Sut){
		String[] s1=new String[]{KEY_ID};
		Cursor cur2=vtn.query(DATABASE_TABLE,s1,KEY_ID + "=" + Sut,null,null,null,null);
		boolean var = (cur2.getCount() > 0);
		if(var){
		vtn.delete(DATABASE_TABLE,KEY_ID + "=" + Sut,null);
		return true;
		}
		else{
			return false;
		   }
	}
	
}


