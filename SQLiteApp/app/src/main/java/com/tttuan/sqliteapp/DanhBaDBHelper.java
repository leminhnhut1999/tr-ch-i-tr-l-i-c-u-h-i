package com.tttuan.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DanhBaDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DanhBaDB.db";

    public DanhBaDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DanhBaEntry.TAO_BANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DanhBaEntry.XOA_BANG);

        onCreate(sqLiteDatabase);
    }
    public long themDanhBa(DanhBaEntry obj){
        //INSERT INTO danh_ba(ten,sdt) VALUES(?,?)
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(DanhBaEntry.COL_TEN, obj.getTen());
        values.put(DanhBaEntry.COL_SDT, obj.getSdt());

        long insertedID = sqLiteDatabase.insert(
                DanhBaEntry.TABLE_NAME,         //Tao bang
                null,
                values                          //Ten Filed - Value
        );
        return insertedID;
    }

    public DanhBaEntry timTheoSDT(String sdt){
        SQLiteDatabase db = this.getReadableDatabase();

        //SELECT *
        String[] projection = {
                DanhBaEntry.COL_ID,
                DanhBaEntry.COL_TEN,
                DanhBaEntry.COL_SDT
        };

        //WHERE std=?
        String selection = DanhBaEntry.COL_SDT + " = ?";
        String[] selectionArgs = { sdt };

        //ORDER BY Ten ASC
        String sortOrder = DanhBaEntry.COL_TEN + " ASC";

        //Thuc thi truy van
        Cursor cursor = db.query(
                DanhBaEntry.TABLE_NAME,     //Form danh_ba
                projection,                 //SELECT cot(null -> 0)
                selection,                  //WHERE
                selectionArgs,              //gia tri trong WHERE
                null,              //GROUP BY
                null,               //HAVING
                sortOrder                   //ORDER
        );

        //xu ly ket qua tra ve
        DanhBaEntry dbObj = null;
        while(cursor.moveToNext()){
            int index = cursor.getColumnIndexOrThrow(DanhBaEntry.COL_ID);
            long id = cursor.getLong(index);

            index = cursor.getColumnIndexOrThrow(DanhBaEntry.COL_TEN);
            String ten = cursor.getString(index);

            String so_dien_thoai = cursor.getString(cursor.getColumnIndexOrThrow(DanhBaEntry.COL_SDT));
            dbObj = new DanhBaEntry(id,ten,sdt);
        }
        cursor.close();
        return dbObj;
    }
}
