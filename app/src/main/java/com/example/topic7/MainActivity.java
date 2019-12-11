package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etWord,etMeaning;
    Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord= findViewById(R.id.etWord);
        etMeaning= findViewById(R.id.etMeaning);
        btnAddWord= findViewById(R.id.btnAddWord);

        btnAddWord.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Save();
    }
    private void Save(){
        try{
            PrintStream printStream = new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etWord.getText().toString()+"->"+etMeaning.getText().toString());
            Toast.makeText(this,"saved to"+getFilesDir(),Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Log.d("Dictionary app","Error"+e.toString());
            e.printStackTrace();
        }
    }
    private void readFromFile(){
        try{
            FileInputStream fos = openFileInput("words.txt");
            InputStreamReader isr= new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line="";
            while((line=br.readLine()) != null)(
                    String[] parts = line.split("->");
                    dictionary.put(parts[0, parts[1]]);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
