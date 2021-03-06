package com.example.pustikom.adapterplay.com.example.pustikom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pustikom.adapterplay.R;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;
import com.example.pustikom.adapterplay.com.example.pustikom.user.StudentList;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pustikom on 07/10/16.
 */

public class StudentArrayAdapter extends ArrayAdapter<Student> {

    public StudentArrayAdapter(Context context, StudentList studentArrayList) {
        super(context, 0, studentArrayList);
    }

    public View getView(int position, View view, ViewGroup parent){
        Student student = getItem(position);
        if(view==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.student_instance,parent,false);
        }

        TextView idView = (TextView) view.findViewById(R.id.student_id);
        TextView noregView = (TextView) view.findViewById(R.id.student_noreg);
        TextView nameView = (TextView) view.findViewById(R.id.student_name);
        TextView genderView = (TextView) view.findViewById(R.id.student_gender);
        TextView mailView = (TextView) view.findViewById(R.id.student_email);
        TextView phoneView = (TextView) view.findViewById(R.id.student_phone);

        //set content
        idView.setText(student.getId() + "");
        noregView.setText(student.getNoreg());
        nameView.setText(student.getName());
        //Todo: Instead of display number 0 or 1, display String L or P DONE
        //genderView.setText(student.getGender() + "");
        if(student.getGender() == 0){
            genderView.setText("L");
        }
        else if(student.getGender() == 1){
            genderView.setText("P");
        }
        mailView.setText(student.getMail());
        phoneView.setText(student.getPhone());
        return view;
    }
}
