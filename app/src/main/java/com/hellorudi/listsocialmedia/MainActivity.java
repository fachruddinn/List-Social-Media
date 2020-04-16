package com.hellorudi.listsocialmedia;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SocialAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPicture;
    private ArrayList<Social> socials;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_list);
        adapter = new SocialAdapter(this);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        mContext = getApplicationContext();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        socials.get(position).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_social);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPicture = getResources().obtainTypedArray(R.array.data_picture);
    }

    private void addItem() {
        socials = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Social social = new Social();
            social.setPicture(dataPicture.getResourceId(i, -1));
            social.setName(dataName[i]);
            social.setDescription(dataDescription[i]);
            socials.add(social);
        }
        adapter.setSocials(socials);
    }
}
