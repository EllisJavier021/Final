package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        String q = i.getStringExtra("query");

        ArrayList<Row> rows = queryDatabase(q);

        RecyclerView rv = (RecyclerView) findViewById(R.id.queryresults);

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        RowsAdapter adapter = new RowsAdapter(rows, this);

        rv.setAdapter(adapter);
    }

    ArrayList<Row> queryDatabase(String query)
    {
        ArrayList<Row> queryResult = new ArrayList<Row>();
        try{
            SQLiteDatabase db = openOrCreateDatabase("imdb.db", Context.MODE_PRIVATE, null);
            Cursor cursor  = db.rawQuery(query, null);

            while(cursor.moveToNext())
            {
                String[] rowvalues  = new String[3];
                for(int i = 0; i < cursor.getColumnCount(); i++)
                {
                    rowvalues[i] = cursor.getString(i);
                }
                Row r = new Row(rowvalues[0], rowvalues[1], rowvalues[2]);
                queryResult.add(r);
            }
            cursor.close();
            db.close();
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error opening/querying the database", Toast.LENGTH_LONG).show();
        }
        return queryResult;
    }


}
