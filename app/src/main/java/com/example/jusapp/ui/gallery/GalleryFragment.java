package com.example.jusapp.ui.gallery;

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

import com.example.jusapp.CameraUseActivity;
import com.example.jusapp.R;
import com.example.jusapp.RecyclerViewSearchFilterActivity;
import com.example.jusapp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private Button takePictureBtn;

    public GalleryFragment() {


    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        takePictureBtn = view.findViewById(R.id.takePictureBtn);

        takePictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), CameraUseActivity.class));

            }
        });

        return view;
    }
}