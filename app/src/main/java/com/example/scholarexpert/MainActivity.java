package com.example.scholarexpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scholarexpert.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Integer presentLecture = 10;
    Integer absentLecture = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
}