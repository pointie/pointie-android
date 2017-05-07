package com.example.user.pointie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class AddImageActivity extends AppCompatActivity {
    private File imageFile;
    private String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void process(View view)
    {

        filePath =  Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".jpeg";

        File file = new File(filePath);

        Uri output = Uri.fromFile(file);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, output);

        startActivityForResult(cameraIntent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case RESULT_OK:

                Log.i( "MakeMachine", "resultCode: " + resultCode );
                switch( resultCode )
                {
                    case 0:
                        Log.i( "MakeMachine", "User cancelled" );
                        break;
                    case -1:
                        //Bitmap bm = BitmapFactory.decodeFile(filePath);
                        break;
                }
                break;

        }

    }
}
