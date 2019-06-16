package com.example.homework4_2_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        SamplesList sampleOne = new SamplesList("BMW", "It's car brand", R.drawable.x5);
        SamplesList sampleTwo = new SamplesList("Chernobyl", "It's world catastrophe", R.drawable.chernobyl);
        SamplesList sampleThree = new SamplesList("United States \nof America", "It's world power", R.drawable.usa);
        SamplesList sampleFour = new SamplesList("Parrot", "It's bird talker", R.drawable.parrot);
        SamplesList sampleFive = new SamplesList("Boeing", "It's largest \naircraft manufacturer", R.drawable.boeing);

        SampleAdapter sampleAdapter = new SampleAdapter(this);
        sampleAdapter.addSimples(sampleOne);
        sampleAdapter.addSimples(sampleTwo);
        sampleAdapter.addSimples(sampleThree);
        sampleAdapter.addSimples(sampleFour);
        sampleAdapter.addSimples(sampleFive);
        listView.setAdapter(sampleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_settings) {
            Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intentSettings);
        }

        if (id == R.id.action_open_check) {
            Intent intentSettings = new Intent(MainActivity.this, CheckBoxActivity.class);
            startActivity(intentSettings);
        }

        if (id == R.id.action_open_calendar) {
            Intent intentSettings = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intentSettings);
        }

        if (id == R.id.action_open_spinner) {
            Intent intentSettings = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intentSettings);
        }
        return super.onOptionsItemSelected(item);
    }
}
