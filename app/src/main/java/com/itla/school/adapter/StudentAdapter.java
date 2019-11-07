package com.itla.school.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.itla.school.R;
import com.itla.school.entity.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvRegistrationNumber;
        public TextView tvCareer;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvRegistrationNumber = itemView.findViewById(R.id.tvRegistrationNumber);
            tvCareer = itemView.findViewById(R.id.tvCareer);
        }
    }

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View StudentView = inflater.inflate(R.layout.student_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(StudentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder viewHolder, int position) {
        Student student = this.students.get(position);

        TextView tvName = viewHolder.tvName;
        tvName.setText(student.getName());

        TextView tvRegistrationNumber = viewHolder.tvRegistrationNumber;
        tvRegistrationNumber.setText(student.getRegistrationNumber());

        TextView tvCareer = viewHolder.tvCareer;
        tvCareer.setText(student.getCareer().getName());
    }

    @Override
    public int getItemCount() {
        return this.students.size();
    }


}
