package com.example.admin.riviera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1){
                    Intent intent = new Intent(TopLevelActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent(TopLevelActivity.this, OfficesCategoryActivity.class);
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent(TopLevelActivity.this, AboutUs.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
