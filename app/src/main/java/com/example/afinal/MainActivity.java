package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button1(View view)
    {
        Intent i = new Intent(this, results.class);
        i.putExtra("query", "SELECT Year, Title FROM movies order by Year DESC, Title;" );
        startActivity(i);
    }

    public void button2(View view)
    {
        Intent i = new Intent(this, results.class);
        i.putExtra("query", "select people.name, movies.title from movies \n" +
                "inner join directors, people on people.id=directors.person_id \n" +
                "and directors.movie_id=movies.id order by people.name ;" );
        startActivity(i);
    }

    public void button3(View view)
    {
        Intent i = new Intent(this, results.class);
        i.putExtra("query", "select people.name as Director, movies.title, ratings.rating \n" +
                "from movies inner join directors, people, ratings on \n" +
                "people.id=directors.person_id and directors.movie_id=movies.id \n" +
                "and ratings.movie_id=movies.Id order by rating desc;");
        startActivity(i);
    }

    public void button4(View view)
    {
        Intent i = new Intent(this, results.class);
        i.putExtra("query", "SELECT count([year]) as YearCount, year from movies group by year order by YearCount desc" );
        startActivity(i);
    }

    public void button5(View view)
    {
        Intent i = new Intent(this, results.class);
        i.putExtra("query", "select ratings.votes, ratings.rating, movies.title from movies inner join ratings on ratings.movie_id=movies.id order by votes desc" );
        startActivity(i);
    }
}
