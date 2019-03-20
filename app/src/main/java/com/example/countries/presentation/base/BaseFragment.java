package com.example.countries.presentation.base;

import android.content.Context;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment {

    @Inject
    protected ViewModelProvider.Factory factory;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
