package com.example.filemanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    TextView txt_get_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_get_text = findViewById(R.id.txt_get_text);
        Button btn_back = findViewById(R.id.btn_back);
        Button btn_show_private_data = findViewById(R.id.btn_show_private_data);
        Button btn_show_public_data = findViewById(R.id.btn_show_public_data);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btn_show_private_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrivateFile(v);
            }
        });
        btn_show_public_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPublicFile(v);
            }
        });
    }

    // get public file
    private void getPublicFile(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "biodata.txt");
        String text = getData(file);
        if (text != null) {
            txt_get_text.setText(text);
        } else {
            txt_get_text.setText("");
        }
    }

    // get private file
    private void getPrivateFile(View view) {
        File folder = getExternalFilesDir("personal");
        File file = new File(folder, "personal.txt");
        String text = getData(file);
        if (text != null) {
            txt_get_text.setText(text);
        } else {
            txt_get_text.setText("");
        }
    }

    private String getData(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int i = -1;
            StringBuilder stringBuffer = new StringBuilder();
            while ((i = fileInputStream.read()) != -1) {
                stringBuffer.append((char) i);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream !=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}