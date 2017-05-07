package com.example.user.pointie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import java.io.File;
import java.util.ArrayList;

import android.os.Environment;
import android.net.Uri;
import android.widget.GridView;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {
    public void showTiles() {
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));



    }

    private File imageFile;
    private String filePath;
    private ArrayList<String> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this, AddImageActivity.class));
          //      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
           //             .setAction("Action", null).show();
            }
        });
        new AsyncHttp() {
            @Override
            public void onResponse( ArrayList<String> array) {
                super.onResponse(array);

                showTiles();
            }
        }.execute();


    }


}
