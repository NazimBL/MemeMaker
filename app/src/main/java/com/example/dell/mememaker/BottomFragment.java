package com.example.dell.mememaker;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by DELL on 03/09/2016.
 */
public class BottomFragment extends Fragment {
   TextView t1,t2;
    Button b,b2;
    ImageView img;
    View view;
    final static int IMAGE_CAPTURE_REQUEST=20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view= inflater.inflate(R.layout.bottom_entity, container);

        t1=(TextView)view.findViewById(R.id.text1);
        t2=(TextView)view.findViewById(R.id.text2);
        b=(Button)view.findViewById(R.id.button);
        img=(ImageView)view.findViewById(R.id.img);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });

       // b2=(Button)view.findViewById(R.id.button2);


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Bitmap photo;
        Bundle extra=data.getExtras();
         photo=(Bitmap)extra.get("data");

        img.setImageBitmap(photo);

    }



    public void setMemes(String s1,String s2){

        t1.setText(s1);
        t2.setText(s2);
    }


}
