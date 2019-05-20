package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData = new ArrayList<>(Arrays.asList(mountainNames));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //created the adapter with the layout elements defined earlier
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_textview, R.id.my_item_textview, listData);
        //get the listview and set the adapter
        ListView myListView = findViewById(R.id.my_listview);
        myListView.setAdapter(adapter);
        //listener event for clicking on a list item
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                //create intent and put data in it
                Intent intent = new Intent(MainActivity.this, MountainDetailsActivity.class);
                intent.putExtra("mtName", mountainNames[pos]);
                intent.putExtra("mtLocation", mountainLocations[pos]);
                intent.putExtra("mtHeight", mountainHeights[pos]);
                startActivity(intent);
            }
        });

        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.
    }
}
