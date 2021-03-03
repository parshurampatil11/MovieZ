package com.example.quack.Network;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;

import com.example.quack.Adapter.MovieArrayAdapter;
import com.example.quack.Adapter.MovieDetails;
import com.example.quack.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FetchMovie extends AsyncTask<String, Void, String> {

    private Context context;
    private GridView gridView;

    public FetchMovie(Context context,GridView gridView){
        this.context = context;
        this.gridView = gridView;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        URL url = null;
        try {
            url = new URL(strings[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String str = bufferedReader.readLine();

            bufferedReader.close();
            urlConnection.disconnect();
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ArrayList<MovieDetails> movieList = new ArrayList<MovieDetails>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s);

            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String original_title = jsonObject1.getString("original_title");
                double vote_average = jsonObject1.getDouble("vote_average");
                String overview = jsonObject1.getString("overview");
                String release_date = jsonObject1.getString("release_date");
                String poster_path = jsonObject1.getString("poster_path");
                String backdrop_path = jsonObject1.getString("backdrop_path");

                MovieDetails movieDetails = new MovieDetails(original_title,vote_average,overview,release_date,poster_path,backdrop_path);
                movieList.add(movieDetails);

            }
            MovieArrayAdapter movieArrayAdapter = new MovieArrayAdapter(context, R.layout.movie_list,movieList);
            gridView.setAdapter(movieArrayAdapter);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
