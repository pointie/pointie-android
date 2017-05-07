package com.example.user.pointie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import java.io.File;
import android.os.Environment;
import android.net.Uri;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    private File imageFile;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view)
    {
        /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), System.currentTimeMillis() + ".jpg");

        Uri temp = Uri.fromFile(imageFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, value); //Media
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

        startActivityForResult(intent, 0);*/

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
