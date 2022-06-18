package com.example.jusapp.ui.contacts;

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

import com.example.jusapp.NavigationDrawerActivity;
import com.example.jusapp.R;
import com.example.jusapp.RecyclerViewSearchFilterActivity;
import com.example.jusapp.databinding.FragmentContactsBinding;

public class ContactsFragment extends Fragment {


    private Button viewContactsBtn;

    public ContactsFragment() {



    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        viewContactsBtn = view.findViewById(R.id.viewContactsBtn);

        viewContactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), RecyclerViewSearchFilterActivity.class));

            }
        });

        return view;

    }

}