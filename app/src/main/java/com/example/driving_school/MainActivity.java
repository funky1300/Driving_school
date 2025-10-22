package com.example.driving_school;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText name, phone_number, email;
    Button date_bt, time_bt, save_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.name = findViewById(R.id.name);
        this.phone_number = findViewById(R.id.phone_number);
        this.email = findViewById(R.id.email);

        this.date_bt = findViewById(R.id.date_bt);
        this.time_bt = findViewById(R.id.time_bt);
        this.save_bt = findViewById(R.id.save_bt);

        date_bt.setOnClickListener(this);
        time_bt.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == date_bt)
        {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
            datePickerDialog.show();
        }
        if(v == time_bt)
        {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, hour, minute, true);
            timePickerDialog.show();
        }

        if(v == save_bt)
        {
            String name_text = name.getText().toString();
            String phone_number_text = phone_number.getText().toString();
            String email_text = email.getText().toString();
            String date_text = date_bt.getText().toString();
            String time_text = time_bt.getText().toString();
            driving_lesson lesson = new driving_lesson(name_text, phone_number_text, email_text, date_text, time_text);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(lesson.toString());
            builder.setTitle("lesson");
            builder.setPositiveButton("ok", null);
            builder.setNegativeButton("cancel", null);
            EditText et = new EditText(this);
            et.setText(lesson.toString());
            et.setBackgroundColor(Color.BLUE);
            builder.setView(et);

            builder.create().show();
        }

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
        date_bt.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;
        time_bt.setText(time);
    }
}