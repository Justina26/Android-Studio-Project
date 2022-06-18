package com.example.jusapp.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jusapp.LoginActivity;
import com.example.jusapp.R;
import com.example.jusapp.RecyclerViewSearchFilterActivity;
import com.example.jusapp.databinding.FragmentLogoutBinding;
import com.facebook.login.LoginManager;

public class LogoutFragment extends Fragment {

    private Button logoutBtn;

    public LogoutFragment() {



    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_logout, container, false);

        logoutBtn = view.findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginManager.getInstance().logOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));

            }
        });

        return view;

    }


}