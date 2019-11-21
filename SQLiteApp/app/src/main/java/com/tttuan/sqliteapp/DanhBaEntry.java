package com.tttuan.sqliteapp;

public class DanhBaEntry {
    public static final String TABLE_NAME = "danh_ba";
    public static final String COL_ID = "id";
    public static final String COL_TEN = "ten";
    public static final String COL_SDT = "sdt";

    public static final String TAO_BANG = "CREATE TABLE " + TABLE_NAME + " ("
            +COL_ID + " INTEGER PRIMARY KEY," + COL_TEN + " TEXT," + COL_SDT + " TEXT)";

    public static final String XOA_BANG = "DROP TABLE IF EXIST " + TABLE_NAME;

    private long id;
    private String ten;
    private String sdt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public DanhBaEntry(String ten, String sdt){
        this.id = 0;
        this.ten = ten;
        this.sdt = sdt;
    }
    public DanhBaEntry(long id, String ten, String sdt){
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
    }
}
