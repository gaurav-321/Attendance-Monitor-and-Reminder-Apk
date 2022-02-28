package com.example.scholarexpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scholarexpert.databinding.ActivityMainBinding;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Integer presentLecture = 10;
    Integer absentLecture = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        fragmentReplacement(new AttendanceFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.attendance_menu:
                    fragmentReplacement(new AttendanceFragment());
                    break;
                case R.id.todo_menu:
                    fragmentReplacement(new todoFragment());
                    break;
                case R.id.image_menu:
                    fragmentReplacement(new folderFragment());
                    break;


            }
            return true;
        });
    }

    public void fragmentReplacement(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2, fragment);
        fragmentTransaction.commit();

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void all_subject_clicked(View view) {
        Button button1 = findViewById(R.id.all_subject_button);
        Button button2 = findViewById(R.id.all_subject_button2);
        button1.setBackground(getResources().getDrawable(R.drawable.atten_button_sel));
        button1.setTextColor(Color.BLACK);
        button2.setTextColor(Color.WHITE);
        button2.setBackground(getResources().getDrawable(R.drawable.atten_button_del));


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void timetable_clicked(View view) {
        Button button1 = findViewById(R.id.all_subject_button);
        Button button2 = findViewById(R.id.all_subject_button2);
        button1.setBackground(getResources().getDrawable(R.drawable.atten_button_del));
        button1.setTextColor(Color.WHITE);
        button2.setTextColor(Color.BLACK);
        button2.setBackground(getResources().getDrawable(R.drawable.atten_button_sel));


    }

    public void add_subject(View view) {
        ProgressBar progress = findViewById(R.id.progressBar);
        progress.setProgress(progress.getProgress() + 1);
        TextView progresstext = findViewById(R.id.textView4);
        TextView progresstext2 = findViewById(R.id.textView5);
        progresstext.setText(progress.getProgress() + "%");
        progresstext2.setText(progress.getProgress() + "%");
    }
    /*
    public void yes_button_click(View view){
        TextView textbox = findViewById(R.id.textView);
        presentLecture+=1;
        textbox.setText(""+presentLecture+"/"+(absentLecture+presentLecture));
    }
    public void no_button_click(View view){
        TextView textbox = findViewById(R.id.textView);
        absentLecture+=1;
        textbox.setText(""+presentLecture+"/"+(absentLecture+presentLecture));
    }
    */
}