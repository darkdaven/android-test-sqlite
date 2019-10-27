package com.itla.testappdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.itla.testappdb.R;
import com.itla.testappdb.entity.Career;
import com.itla.testappdb.entity.Student;

import java.util.List;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCareerName;
        public TextView tvSubjects;
        public TextView tvCredits;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCareerName = itemView.findViewById(R.id.tvCareerName);
            tvSubjects = itemView.findViewById(R.id.tvSubjects);
            tvCredits = itemView.findViewById(R.id.tvCredits);
        }
    }

    private List<Career> careers;

    public CareerAdapter(List<Career> careers) {
        this.careers = careers;
    }

    @Override
    public CareerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View CareerView = inflater.inflate(R.layout.career_list, parent, false);

        CareerAdapter.ViewHolder viewHolder = new CareerAdapter.ViewHolder(CareerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CareerAdapter.ViewHolder viewHolder, int position) {
        final Career career = this.careers.get(position);

        TextView tvCareerName = viewHolder.tvCareerName;
        tvCareerName.setText(career.getName());

        TextView tvSubjects = viewHolder.tvSubjects;
        tvSubjects.setText(career.getSubjects() + " materias");

        TextView tvCredits = viewHolder.tvCredits;
        tvCredits.setText(career.getCredits() + " creditos");
    }

    @Override
    public int getItemCount() {
        return this.careers.size();
    }
}
