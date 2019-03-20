package com.example.countries.presentation.countries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.countries.R;
import com.example.countries.data.model.Country;
import com.example.countries.databinding.FragmentCountriesBinding;
import com.example.countries.presentation.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

public class CountriesFragment extends BaseFragment {

    private NavController navController;
    private CountriesViewModel countriesViewModel;
    private FragmentCountriesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(this);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_countries, container, false);
        countriesViewModel = ViewModelProviders.of(this, factory).get(CountriesViewModel.class);
        binding.setViewModel(countriesViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //I could do it better, set up recyclerView with DataBinding Adapter, but it takes more time,
        // so I did it in easiest and fastest way. Also due to this reason, dividers, DiffUtils etc.
        countriesViewModel.countriesLiveData.observe(getViewLifecycleOwner(),
                countries -> binding.productList.setAdapter(new CountryAdapter(countries, this::openCountryDetails)));
    }

    private void openCountryDetails(Country country) {
        NavDirections direction = CountriesFragmentDirections.openProductDetailsAction(country);
        navController.getGraph().findNode(R.id.country_details_destination).setLabel(country.name);
        navController.navigate(direction);
    }
}
