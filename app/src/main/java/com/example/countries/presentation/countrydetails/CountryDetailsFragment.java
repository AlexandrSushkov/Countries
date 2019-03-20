package com.example.countries.presentation.countrydetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.countries.R;
import com.example.countries.databinding.FragmentCountryDetailsBinding;
import com.example.countries.presentation.base.BaseFragment;
import com.example.countries.presentation.countries.CountryAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class CountryDetailsFragment extends BaseFragment {

    private FragmentCountryDetailsBinding binding;
    private CountryDetailsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_details, container, false);
        viewModel = ViewModelProviders.of(this, factory).get(CountryDetailsViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel.borders.observe(getViewLifecycleOwner(), countries -> binding.countriesList.setAdapter(new CountryAdapter(countries, null)));
    }
}
