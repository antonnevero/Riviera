package com.example.admin.riviera;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OfficesActivity extends Activity {

    public static final String EXTRA_OFFICESNO = "officesNo";
    int officesNo;
    String phoneText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offices);

        officesNo = (Integer)getIntent().getExtras().get(EXTRA_OFFICESNO);

        try {
            SQLiteOpenHelper rivieraDatabaseHelper = new RivieraDatabaseHelper(this);
            SQLiteDatabase db = rivieraDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("OFFICES",
                    new String[]{"NAME", "DESCRIPTION", "PHONE", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(officesNo)},
                    null, null, null);

            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                phoneText = cursor.getString(2);
                int photoId = cursor.getInt(3);

                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
                phoneNumber.setText(phoneText);

                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException ex) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneText));
        startActivity(intent);
    }
}
