package com.itla.school.database.connection;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.itla.school.dao.CareerDao;
import com.itla.school.dao.CareerSubjectDao;
import com.itla.school.dao.StudentDao;
import com.itla.school.dao.SubjectDao;
import com.itla.school.entity.Career;
import com.itla.school.entity.CareerSubject;
import com.itla.school.entity.Student;
import com.itla.school.entity.Subject;


@Database(entities = {Career.class, CareerSubject.class, Student.class, Subject.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CareerDao careerDao();

    public abstract StudentDao studentDao();

    public abstract SubjectDao subjectDao();

    public abstract CareerSubjectDao careerSubjectDao();

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {

        if (instance == null)
            instance = Room.
                    databaseBuilder(context, AppDatabase.class, "school.db")
                    .allowMainThreadQueries()
                    .build();

        return instance;
    }
}
