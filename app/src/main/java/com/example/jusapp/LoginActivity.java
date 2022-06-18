package com.example.jusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);

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


//                    else if(username.getText().toString().equals(null) && password.getText().toString().equals(null)){
//
//                    //not enough informations
//
//                    Toast.makeText(LoginActivity.this, "Credentials missing!", Toast.LENGTH_SHORT).show();
//
//                }
//
//                    else if(username.getText().toString().equals(null)){
//
//                    //username missing
//
//                    Toast.makeText(LoginActivity.this, "Username missing!", Toast.LENGTH_SHORT).show();
//
//                }
//
//                    else if(password.getText().toString().equals(null)){
//
//                    //password missing
//
//                    Toast.makeText(LoginActivity.this, "Password missing!", Toast.LENGTH_SHORT).show();
//
//                }


            }
        });




    }
}