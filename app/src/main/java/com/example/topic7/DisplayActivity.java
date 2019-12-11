package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplayActivity extends AppCompatActivity {

    private ListView lstDictionary;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary= new HashMap<>();

        readFromFile();

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, new ArrayList<String>(dictionary.keySet())
        );
        lstDictionary.setAdapter(adapter);
    }
}
