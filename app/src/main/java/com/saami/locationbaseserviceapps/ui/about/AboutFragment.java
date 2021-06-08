package com.saami.locationbaseserviceapps.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.saami.locationbaseserviceapps.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment
{

    private FragmentAboutBinding binding;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState)
    {

        binding = FragmentAboutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.textAbout.setText("Made by Sam");

        return root;
    }

    @Override
    public void onDestroyView ()
    {
        super.onDestroyView();
        binding = null;
    }
}