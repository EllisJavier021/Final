package com.example.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RowsAdapter extends RecyclerView.Adapter<RowsAdapter.ViewHolder> {
    // Store a member variable for the rows
    private ArrayList<Row> dataset;
    // Pass in the rows array into the constructor
    public RowsAdapter(ArrayList<Row> rows, Context c) {
        dataset = rows;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
// for any view that will be set as you render a row
        public TextView textViewColumn1, textViewColumn2, textViewColumn3;
        // Constructor accepts the entire item row
        public ViewHolder(View itemView) {
            super(itemView);
            textViewColumn1 = (TextView) itemView.findViewById(R.id.textView1);
            textViewColumn2 = (TextView) itemView.findViewById(R.id.textView2);
            textViewColumn3 = (TextView) itemView.findViewById(R.id.textView3);
//HERE: get hold of the other two TextView’s in row_layout and assign them to the corresponding the variables
        }
    }
    @Override
    public RowsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
// Inflate the custom layout
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RowsAdapter.ViewHolder viewHolder, int position) {
// Get the data row based on position
        Row row = dataset.get(position);
// Set item views for the given data row
        viewHolder.textViewColumn1.setText(row.column1);
        viewHolder.textViewColumn2.setText(row.column2);
        viewHolder.textViewColumn3.setText(row.column3);
//HERE: set the text of other TextViews in row_layout with the corresponding data from the row object
    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

