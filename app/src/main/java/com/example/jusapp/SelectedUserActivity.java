package com.example.jusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//For RecyclerView selected user

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvSelectedUserName;
    UsersForRecyclerView usersForRecyclerView;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        tvSelectedUserName = findViewById(R.id.tvSelectedUserName);
        intent = getIntent();

        if(intent != null){

            usersForRecyclerView = (UsersForRecyclerView) intent.getSerializableExtra("data");

            String userName = usersForRecyclerView.getFirstname() + " "+ usersForRecyclerView.getLastname();

            tvSelectedUserName.setText(userName);

        }

    }
}