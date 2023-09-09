package com.example.assignmentone;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Integer> currentFragment = new MutableLiveData<>();
    private final MutableLiveData<Integer> selectedAvatar = new MutableLiveData<>();

    public MutableLiveData<Integer> getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(int fragmentId) {
        currentFragment.setValue(fragmentId);
    }

    public MutableLiveData<Integer> getSelectedAvatar() {
        return selectedAvatar;
    }

    public void setSelectedAvatar(int avatarDrawableId) {
        selectedAvatar.setValue(avatarDrawableId);
    }
}

