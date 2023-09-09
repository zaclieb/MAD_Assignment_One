package com.example.assignmentone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class AvatarItemFragment extends Fragment {
    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.avatar_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Initialize image buttons
        ImageButton avatarOne = view.findViewById(R.id.avatarOne);
        ImageButton avatarTwo = view.findViewById(R.id.avatarTwo);
        ImageButton avatarThree = view.findViewById(R.id.avatarThree);
        ImageButton avatarFour = view.findViewById(R.id.avatarFour);

        // Initialize back button
        Button backButton = view.findViewById(R.id.backButton);

        // Set onClickListener for each image button
        avatarOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setSelectedAvatar(R.drawable.avatar_one);
                Toast.makeText(getActivity(), "Avatar One Selected", Toast.LENGTH_SHORT).show();
            }
        });

        avatarTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setSelectedAvatar(R.drawable.avatar_two);
                Toast.makeText(getActivity(), "Avatar Two Selected", Toast.LENGTH_SHORT).show();
            }
        });

        avatarThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setSelectedAvatar(R.drawable.avatar_three);
                Toast.makeText(getActivity(), "Avatar Three Selected", Toast.LENGTH_SHORT).show();
            }
        });

        avatarFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setSelectedAvatar(R.drawable.avatar_four);
                Toast.makeText(getActivity(), "Avatar Four Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Set onClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ProfileFragment
                getFragmentManager().beginTransaction()
                        .replace(R.id.f_container, new ProfileFragment())
                        .commit();
            }
        });
    }
}
