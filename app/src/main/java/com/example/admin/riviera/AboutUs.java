package com.example.admin.riviera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Button ourOffices = (Button) findViewById(R.id.ourOffices_btn);
        TextView textAboutUs = (TextView) findViewById(R.id.textAboutUs);
        textAboutUs.setText(R.string.about_us);

    }

    public void onClickBtn (View v){
        Intent intent = new Intent(AboutUs.this, OfficesCategoryActivity.class);
        startActivity(intent);
    }
}
