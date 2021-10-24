package com.example.filemanagement2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txt_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // access component
        txt_edit = findViewById(R.id.txt_edit);
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_private_save = findViewById(R.id.btn_private_save);
        Button btn_public_save = findViewById(R.id.btn_public_save);
        // redirect user to main activity 2
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
        // save in private
        btn_private_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFileToPrivate();
            }
        });
        // save in public
        btn_public_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFileToPublic();
            }
        });
    }

    // save file to public
    public void saveFileToPublic() {
        // get access permission to external storage
        int STORAGE_FILE_PERMISSION = 23;
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_FILE_PERMISSION);
        // get text from edit text
        String text = txt_edit.getText().toString();
        // folder definition
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        // save file on folder (folder, name of file)
        File file = new File(folder, "biodata.txt");
        // method to store the file
        writeData(file, text);
        txt_edit.setText("");
    }

    // save file in private mode
    public void saveFileToPrivate() {
        // get text
        String text = txt_edit.getText().toString();
        // set folder place to file store
        File folder = getExternalFilesDir("personal");
        // set file location and file name to store
        File file = new File(folder, "personal.txt");
        writeData(file, text);
        txt_edit.setText("");
    }

    private void writeData(File file, String text) {
        FileOutputStream fileOutputStream = null;
        try {
            // make container from file
            fileOutputStream = new FileOutputStream(file);
            // write text to file
            fileOutputStream.write(text.getBytes());
            // show toast
            Toast.makeText(this, "Saved in" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close file
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}