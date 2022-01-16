package com.example.lab_6;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
EditText textBox;
static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = findViewById(R.id.txtText1);
        InputStream is = this.getResources().openRawResource(R.raw.textfile);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = null;
        try {
            while ((str = br.readLine()) != null) {
                Toast.makeText(getBaseContext(),str, Toast.LENGTH_SHORT).show();
            }
            is.close();
            br.close();
        }
     catch (IOException e) {
            e.printStackTrace();
        }



    }
    public void onClickSave(View view){
        String str = textBox.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput("textfile.txt", MODE_WORLD_READABLE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write(str);
            osw.flush();
            osw.close();
            Toast.makeText(getBaseContext(), "Dadoteka je uspesno snimljena", Toast.LENGTH_SHORT).show();
            textBox.setText("");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void onClickLoad(View view){
        try {
            FileInputStream fln = openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fln);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while((charRead = isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s+=readString;
                        inputBuffer = new char[READ_BLOCK_SIZE];
            }
            textBox.setText(s);
            Toast.makeText(getBaseContext(), "Dadoteka je uspesno ucitana", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}