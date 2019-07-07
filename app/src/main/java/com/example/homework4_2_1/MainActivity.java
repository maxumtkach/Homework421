package com.example.homework4_2_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button button;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        SamplesList sampleOne = new SamplesList("BMW", "It's car brand", R.drawable.x5, button, R.drawable.delete_forever);
        SamplesList sampleTwo = new SamplesList("Chernobyl", "It's world catastrophe", R.drawable.chernobyl, button, R.drawable.delete_forever);
        SamplesList sampleThree = new SamplesList("United States \nof America", "It's world power", R.drawable.usa, button, R.drawable.delete_forever);
        SamplesList sampleFour = new SamplesList("Parrot", "It's bird talker", R.drawable.parrot, button, R.drawable.delete_forever);
        final SamplesList sampleFive = new SamplesList("Boeing", "It's largest \naircraft manufacturer", R.drawable.boeing, button, R.drawable.delete_forever);

        final SampleAdapter sampleAdapter = new SampleAdapter(this);
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


    public void onClick(View v) {
        Toast.makeText(this, "hhhh", Toast.LENGTH_SHORT).show();

    }
}
