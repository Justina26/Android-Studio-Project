package com.example.jusapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraUseActivity extends AppCompatActivity {

    //Initialize Variable
    ImageView imageView;
    Button btOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_use);



        //Assign Variable
        imageView = findViewById(R.id.image_view);
        btOpen = findViewById(R.id.bt_open);

        //Request for Camera permission
        if(ContextCompat.checkSelfPermission(CameraUseActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(CameraUseActivity.this, new String[]{

                            Manifest.permission.CAMERA
                    },
                    100
            );
        }

        btOpen.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view){

                //Open Camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);



            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {

            //Get capture image
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");

            //Set capture image to imageView
            imageView.setImageBitmap(captureImage);


        }


    }
}