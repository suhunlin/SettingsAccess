package com.suhun.settingsaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private TextView fieldName;
    private ListView showContentValues;
    private Button getFieldName, getContentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        fieldName = findViewById(R.id.lid_fieldName);
        showContentValues = findViewById(R.id.lid_contentValues);
        getFieldName = findViewById(R.id.lid_getFieldName);
        getContentValues = findViewById(R.id.lid_getSetingContent);
        getFieldName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getContentValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

}