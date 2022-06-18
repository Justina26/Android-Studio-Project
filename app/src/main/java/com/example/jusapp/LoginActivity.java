package com.example.jusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {


    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        callbackManager = CallbackManager.Factory.create();
//
//        LoginManager.getInstance().registerCallback(callbackManager,
//                new FacebookCallback<LoginResult>() {
//                    @Override
//                    public void onSuccess(LoginResult loginResult) {
//                        // App code
//
//                        startActivity(new Intent(LoginActivity.this, NavigationDrawerActivity.class));
//                        finish();
//
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        // App code
//
//
//
//                    }
//
//                    @Override
//                    public void onError(FacebookException exception) {
//                        // App code
//
//
//
//                    }
//                });




        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        //initialize login button
        Button loginbtn = findViewById(R.id.loginbtn);

        //initialize google icon
        ImageView gglBtn = findViewById(R.id.gglBtn);

        //initialize facebook icon
        ImageView fbBtn = findViewById(R.id.fbBtn);

        //initialize twitter icon
        ImageView twtBtn = findViewById(R.id.twtBtn);

        //username:admin and password:admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

                    //correct authentication

                    Toast.makeText(LoginActivity.this, "Login succeded!", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, NavigationDrawerActivity.class));



                }
                    //invalid authentication

                    else if((username.getText().toString() != "admin") && (password.getText().toString() != "admin")){

                    Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();

                }

        //when clicking on the google icon
        gglBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //login to google



            }
        });


        //when clicking on the facebook icon
        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //login to facebook

            LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));


            }
        });

        //when clicking on the twitter icon
        twtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //login to twitter


            }
        });



            }
        });




    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


}