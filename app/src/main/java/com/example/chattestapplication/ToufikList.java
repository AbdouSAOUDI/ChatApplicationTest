package com.example.chattestapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ToufikList extends AppCompatActivity
{
    ListView rootList = null;
    String[] table = {"0", "1", "2", "3", "4", "5"};
//    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toufik_list);

        rootList = findViewById(R.id.ToufikRootList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table);

        rootList.setAdapter(adapter);

        rootList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ToufikList.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });

//        for (int i = 0; i < 10; i++) list.add(i + "");
    }
}
