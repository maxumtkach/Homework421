package com.example.homework4_2_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {

    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndtDateCalendar;
    private Button mBtnOK;

    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initViews();
        mChooseStartDate.setOnClickListener(clickStartListener);
        mChooseEndDate.setOnClickListener(clickEndListener);

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i+"-"+i1+"-"+i2;
                mChooseStartDate.setText("Дата-время старта задачи: " + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mEndtDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i+"-"+i1+"-"+i2;
                mChooseEndDate.setText("Дата-время окончания задачи: " + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mBtnOK.setOnClickListener(clickBtnOkListener);
    }

    private void initViews() {
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mEndtDateCalendar = findViewById(R.id.endtDateCalendar);
        mBtnOK = findViewById(R.id.btnOK);

        mStartDateCalendar.setVisibility(View.GONE);
        mEndtDateCalendar.setVisibility(View.GONE);
    }

    private final View.OnClickListener clickStartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mStartDateCalendar.setVisibility(View.VISIBLE);
            mEndtDateCalendar.setVisibility(View.GONE);
        }
    };

    private final View.OnClickListener clickEndListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mEndtDateCalendar.setVisibility(View.VISIBLE);
            mStartDateCalendar.setVisibility(View.GONE);
        }
    };

    private final View.OnClickListener clickBtnOkListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (mStartDate > mEndDate){
                Toast.makeText(CalendarActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                mChooseStartDate.setText("Дата-время старта задачи:");
                mChooseEndDate.setText("Дата-время окончания задачи:");
            } else {
                Toast.makeText(CalendarActivity.this, "старт: " + mStartDateTxt +"\n"+ " окончаниe: " + mEndDateTxt, Toast.LENGTH_LONG).show();
            }
        }
    };
}
