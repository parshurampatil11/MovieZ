package com.example.quack.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.quack.Adapter.MovieDetails;
import com.example.quack.R;
import com.example.quack.UrlSite.WebViewUrl;
import com.example.quack.UrlSite.YouTubeUrl;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView poster;
    TextView title,date,overview,rating;
    MovieDetails movieDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        poster = (ImageView) findViewById(R.id.poster);
        title = (TextView) findViewById(R.id.title);
        date = (TextView) findViewById(R.id.date);
        overview = (TextView) findViewById(R.id.overview);
        rating = (TextView) findViewById(R.id.rating);

        movieDetails = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE_DETAILS");

        if(movieDetails!=null){

            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+movieDetails.getBackdrop_path()).into(poster);
            title.setText(movieDetails.getOriginal_title());
            date.setText(movieDetails.getRelease_date());
            overview.setText(movieDetails.getOverview());
            String rate = Double.toString(movieDetails.getVote_average());
            rating.setText("Ratings: "+rate);

        }
        Button button = (Button) findViewById(R.id.trailorButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String youTubeUri = "https://www.youtube.com/results?q="+movieDetails.getOriginal_title()+"&sxsrf=ALeKk03TIsy_c1HE1ALUm-Pu-fLI4Wcz9w%3A1614601617462&source=lnms&tbm=vid&sa=X&ved=2ahUKEwjr2PLei4_vAhVOeX0KHU-ODzUQ_AUoA3oECAMQBQ&biw=1366&bih=630";
                Intent intent = new Intent(MovieDetailsActivity.this, YouTubeUrl.class);
                intent.putExtra("MOVIE_DETAIL",movieDetails);
                startActivity(intent);
            }
        });
        Button reviewButton = (Button) findViewById(R.id.reviewButton);

        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String googleReview = "https://www.google.com/search?q="+movieDetails.getOriginal_title()+"+world+review&client=ubuntu&hs=inP&channel=fs&sxsrf=ALeKk03Imn0pQz8fAKhjdJ2eqRmVUCzY3w:1614678111596&source=lnms&tbm=nws&sa=X&ved=2ahUKEwjPs5LaqJHvAhVA7XMBHdVrCDsQ_AUoAnoECAUQBA&biw=1366&bih=630";
                Intent intent = new Intent(MovieDetailsActivity.this, WebViewUrl.class);
                intent.putExtra("MOVIE_DETAIL",movieDetails);
                startActivity(intent);
            }
        });
    }

}