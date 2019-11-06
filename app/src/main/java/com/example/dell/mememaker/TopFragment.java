package com.example.dell.mememaker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

/**
 * Created by DELL on 03/09/2016.
 */
public class TopFragment extends Fragment{
    EditText e1,e2;
    Button b;
    TopSectionInterface myIterface;

    public interface TopSectionInterface{

        public void createMenu(String s1,String s2);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.top_entity,container);

        e1=(EditText)view.findViewById(R.id.edit1);
        e2=(EditText)view.findViewById(R.id.edit2);
        b=(Button)view.findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myIterface.createMenu(e1.getText().toString(),e2.getText().toString());
            }
        });

        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            myIterface=(TopSectionInterface)activity;

        }catch(ClassCastException c) {
            Log.d("Nazim",""+c.toString());}
    }

}
