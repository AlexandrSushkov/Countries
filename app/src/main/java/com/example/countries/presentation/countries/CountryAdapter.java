package com.example.countries.presentation.countries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.countries.R;
import com.example.countries.data.model.Country;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Country> countries;
    private OnItemClickListener onItemClickListener;

    public CountryAdapter(List<Country> countries, OnItemClickListener onItemClickListener) {
        this.countries = countries;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

class ViewHolder extends RecyclerView.ViewHolder {

    private TextView countryTitle;
    private OnItemClickListener onItemClickListener;

    public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        countryTitle = itemView.findViewById(R.id.country_title);
        this.onItemClickListener = onItemClickListener;
    }

    void bind(Country country) {
        countryTitle.setText(country.name);
        if (onItemClickListener != null) {
            itemView.setOnClickListener(v -> onItemClickListener.onItemCLick(country));
        }
    }

}

interface OnItemClickListener {
    void onItemCLick(Country country);
}
