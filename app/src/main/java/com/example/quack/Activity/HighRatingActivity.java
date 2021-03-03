package com.example.quack.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.quack.Adapter.MovieDetails;
import com.example.quack.Network.FetchHighRate;
import com.example.quack.R;

public class HighRatingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    final String HIGH_RATING_MOVIE = "Your API Key";
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_high_rating);
        gridView = (GridView) findViewById(R.id.grid_View);
        new FetchHighRate(HighRatingActivity.this,gridView).execute(HIGH_RATING_MOVIE);
        gridView.setOnItemClickListener(this::onItemClick);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this,MovieDetailsActivity.class);
        intent.putExtra("MOVIE_DETAILS",(MovieDetails) parent.getItemAtPosition(position));
        startActivity(intent);
    }
}
