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

        SamplesList sampleOne = new SamplesList("Sample1", "It's Settings", R.drawable.settings);
        SamplesList sampleTwo = new SamplesList("Sample2", "It's Notebook", R.drawable.notebook);
        SamplesList sampleThree = new SamplesList("Sample3", "It's CheckBox", R.drawable.check_box);
        SamplesList sampleFour = new SamplesList("Sample4", "It's Calendar", R.drawable.settings);
        SamplesList sampleFive = new SamplesList("Sample5", "It's Spinner", R.drawable.settings);

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
