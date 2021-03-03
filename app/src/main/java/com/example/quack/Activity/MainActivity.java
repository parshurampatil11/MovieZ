package com.example.quack.Activity;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import com.example.quack.Adapter.MovieDetails;
import com.example.quack.Network.FetchMovie;
import com.example.quack.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;

    final String BOX_MOVIE = "Your API Key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.list_View);
        gridView.setOnItemClickListener(this::onItemClick);
        new FetchMovie(MainActivity.this,gridView).execute(BOX_MOVIE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.invisible_para,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id){

            case R.id.highRating:
                Intent intent = new Intent(MainActivity.this,HighRatingActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this,MovieDetailsActivity.class);
        intent.putExtra("MOVIE_DETAILS",(MovieDetails) parent.getItemAtPosition(position));
        startActivity(intent);

    }

}
