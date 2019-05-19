package com.blogspot.ketikanmd.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.SQLException;
import java.util.ArrayList;

public class AgendaController {
    private AgendaHelper db;
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "daftaragenda";
    public static final String ID = "id";
    public static final String AGENDA = "agenda";
    public static final String TANGGAL = "tanggal";
    public static final String TEMPAT = "tempat";
    public static final String KETERANGAN = "keterangan";
    public static final String STATUS = "status";

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static final String CREATE_AGENDA = "CREATE TABLE "+TABLE_NAME+ " " + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + AGENDA + " TEXT," + TANGGAL + " TEXT,"
            + TEMPAT + " TEXT, "+KETERANGAN+" TEXT, "+STATUS+" TEXT)";

    private String[] TABLE_COLOUMNS = {ID, AGENDA, TANGGAL, TEMPAT, KETERANGAN, STATUS};

    public AgendaController(Context context) {
        db = new AgendaHelper(context);
    }

    public void close() {
        db.close();
    }

    public void open() throws SQLException {
        database = db.getWritableDatabase();
    }

    public void deleteData() {
        database.delete(TABLE_NAME, null, null);
    }

    public void insertData(int id, String agenda, String tanggal, String tempat, String keterangan, String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(AGENDA, agenda);
        contentValues.put(TANGGAL, tanggal);
        contentValues.put(TEMPAT, tempat);
        contentValues.put(KETERANGAN, keterangan);
        contentValues.put(STATUS,status);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<AgendaModel> getData() {
        ArrayList<AgendaModel> allData = new ArrayList<AgendaModel>();
        Cursor cursor = null;

        cursor = database.query(TABLE_NAME, TABLE_COLOUMNS, null, null, null, null, ID + " ASC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return allData;
    }

    private AgendaModel parseData(Cursor cursor) {
        AgendaModel curData = new AgendaModel();

        curData.setId(cursor.getInt(0));
        curData.setAgenda(cursor.getString(1));
        curData.setTanggal(cursor.getString(2));
        curData.setTempat(cursor.getString(3));
        curData.setKeterangan(cursor.getString(4));
        curData.setStatus(cursor.getString(5));


        return curData;
    }
}
