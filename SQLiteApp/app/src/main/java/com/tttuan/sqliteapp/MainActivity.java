package com.tttuan.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mTenEdit, mSDTEdit;
    private DanhBaDBHelper dbHelper;
    private DanhBaEntry mDanhBaEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTenEdit = findViewById(R.id.ten_text);
        mSDTEdit = findViewById(R.id.sdt_text);

        dbHelper = new DanhBaDBHelper(this);
    }

    public void xoaForm(View view) {
        //Xóa nội dung 2 EditText
        mTenEdit.setText("");
        mSDTEdit.setText("");

        //Chuyển focus vào EditText Tên
        mTenEdit.requestFocus();
    }

    public void themMoi(View view) {
        String ten = mTenEdit.getText().toString();
        String sdt = mSDTEdit.getText().toString();
        mDanhBaEntry = new DanhBaEntry(ten,sdt);
        long id = dbHelper.themDanhBa(mDanhBaEntry);
        if(id > 0){
            Toast.makeText(this,"Thêm thông tin liên lạc thành công",Toast.LENGTH_SHORT).show();
            xoaForm(view);
        }else {
            Toast.makeText(this,"Thêm thông tin liên lạc thất bại",Toast.LENGTH_SHORT).show();
        }
    }
    public void timTheoSDT(View view){
        //Bo qua viec kiem tra da nhap so dt chua?

    }
}
