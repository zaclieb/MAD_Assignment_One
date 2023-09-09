package com.example.assignmentone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ProfileFragment extends Fragment {

    private SharedViewModel viewModel;
    private ImageView imageView; // Declare the ImageView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);

        // Initialize the ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Get the button from your layout
        Button button = view.findViewById(R.id.changeImageButton);

        // Initialize ImageView
        imageView = view.findViewById(R.id.imageView);

        // Observe selectedAvatar changes
        viewModel.getSelectedAvatar().observe(getViewLifecycleOwner(), newAvatar -> {
            if (newAvatar != null) {
                imageView.setImageResource(newAvatar);
            }
        });

        // Add a click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the current fragment ID to 1 so the observer in MainActivity will change the fragment
                viewModel.setCurrentFragment(1);
            }
        });

        return view;
    }
}
