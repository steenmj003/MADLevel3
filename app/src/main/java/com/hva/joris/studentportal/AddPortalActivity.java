package com.hva.joris.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPortalActivity extends AppCompatActivity {
    ArrayList<PortalObject> portalObjects;
    Button addPortalButton;
    EditText name;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        addPortalButton = findViewById(R.id.addPortalButton);
        name = findViewById(R.id.portalName);
        url = findViewById(R.id.portalUrl);

        Intent intent = getIntent();
        portalObjects = null;
        portalObjects = intent.getParcelableArrayListExtra("PORTALOBJECTS");

        addPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(url.getText().toString())) {
                    PortalObject portalObject = new PortalObject(name.getText().toString(), url.getText().toString());
                    Intent intent = new Intent(AddPortalActivity.this, OverviewActivity.class);
                    portalObjects.add(portalObject);
                    intent.putExtra("PORTALOBJECTS", portalObjects);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(AddPortalActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
