package com.itla.testappdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.itla.testappdb.R;
import com.itla.testappdb.entity.Subject;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvSubjectName;
        public TextView tvSubjectCredits;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSubjectName = itemView.findViewById(R.id.tvSubjectName);
            tvSubjectCredits = itemView.findViewById(R.id.tvSubjectCredits);
        }
    }

    private List<Subject> subjects;

    public SubjectAdapter(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public SubjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View SubjectView = inflater.inflate(R.layout.subject_list, parent, false);

        SubjectAdapter.ViewHolder viewHolder = new SubjectAdapter.ViewHolder(SubjectView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SubjectAdapter.ViewHolder viewHolder, int position) {
        Subject subject = this.subjects.get(position);

        TextView tvSubjectName = viewHolder.tvSubjectName;
        tvSubjectName.setText(subject.getName());

        TextView tvSubjectCredits = viewHolder.tvSubjectCredits;
        tvSubjectCredits.setText(subject.getCredits() + " creditos");
    }

    @Override
    public int getItemCount() {
        return this.subjects.size();
    }
}
