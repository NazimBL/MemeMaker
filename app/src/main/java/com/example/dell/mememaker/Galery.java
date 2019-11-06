package com.example.dell.mememaker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Galery extends AppCompatActivity {

    ImageView img;
    Button b;
    final static int IMAGE_CAPTURE_REQUEST=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);

b=(Button)findViewById(R.id.b3);
        img=(ImageView)findViewById(R.id.img);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK);
                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                String path = directory.getPath();
                Uri data = Uri.parse(path);
                i.setDataAndType(data, "image/*");
                startActivityForResult(i, IMAGE_CAPTURE_REQUEST);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode==IMAGE_CAPTURE_REQUEST){

            Uri imageUri=data.getData();

            try {
                InputStream inputStream=getContentResolver().openInputStream(imageUri);
               Bitmap photo= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(photo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
