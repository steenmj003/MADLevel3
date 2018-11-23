package com.hva.joris.studentportal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton goToAddPortalButton;
    ArrayList<PortalObject> portalObjects;
    ArrayAdapter<PortalObject> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        goToAddPortalButton = findViewById(R.id.floatingActionButton);
        listView = findViewById(R.id.listView);

        Intent intent = getIntent();
        portalObjects = intent.getParcelableArrayListExtra("PORTALOBJECTS");
        if (portalObjects == null) {
            portalObjects = new ArrayList<>();
        }
        updateUI();

        goToAddPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, AddPortalActivity.class);
                intent.putExtra("PORTALOBJECTS", portalObjects);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OverviewActivity.this, ShowPortalActivity.class);
                intent.putExtra("PORTALOBJECT", portalObjects.get(position));
                startActivity(intent);
            }
        });
    }

    private void updateUI() {
        if (adapter == null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, portalObjects);
            listView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
