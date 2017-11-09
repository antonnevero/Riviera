package com.example.admin.riviera;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class RivieraDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "ourOffices"; // Имя базы данных
    private static final int DB_VERSION = 1;

    RivieraDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE OFFICES (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "PHONE TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");

        insertOffices(db, "Офис 1", "Наш главный офис. Находится на 97м квартале по адресу пр-т Гагарина 36/30.", "Звоните нам +380676288883", R.drawable.riviera_photo);
        insertOffices(db, "Офис 2", "Один из наших франчайзинговых офисов \"CoralTravel\". Находится на 97м квартале по адресу пр-т Гагарина 36/30, рядом с главным офисом", "Звоните нам +380675680020", R.drawable.coral_one);
        insertOffices(db, "Офис 3", "Наш второй франчайзинговый офис \"CoralTravel\". Находится в Центрально-Городском районе по адресу пр-т Почтовый 35б ТЦ \"Либерти\"", "Звоните нам +380675575377", R.drawable.coral_two);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    private static void insertOffices(SQLiteDatabase db, String name,
                                    String description, String phone, int resourceId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("DESCRIPTION", description);
        contentValues.put("PHONE", phone);
        contentValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("OFFICES", null, contentValues);
    }
}