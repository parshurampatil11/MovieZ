package com.example.quack.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.quack.R;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter {

    private List<MovieDetails> movieDetailsList;
    private int resource;
    private Context context;

    public MovieArrayAdapter(Context context, int resource,List<MovieDetails> movieDetailsList) {
        super(context, resource, movieDetailsList);
        this.context = context;
        this.resource = resource;
        this.movieDetailsList = movieDetailsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MovieDetails movieDetails = movieDetailsList.get(position);

        View view = convertView;

        if(view==null) {

            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+movieDetails.getPoster_path()).into(imageView);

        return view;
    }

    @Nullable
    @Override
    public Object getItem(int position) {

        return movieDetailsList.get(position);
    }
}
