package com.example.qrcodesystemfilter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Information extends AppCompatActivity {

    TextView cStatus;
    TextView javaStatus;
    TextView cPlusPlusStatus;
    TextView pythonStatus;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        cStatus = (TextView) findViewById(R.id.cStatus);
        javaStatus = (TextView) findViewById(R.id.JavaStatus);
        cPlusPlusStatus = (TextView) findViewById(R.id.cPlusPlusStatus);
        pythonStatus = (TextView) findViewById(R.id.pythonStatus);

        Intent i = getIntent();
        String system = i.getStringExtra("system");

        databaseReference = FirebaseDatabase.getInstance("https://qr-code-system-filter-default-rtdb.firebaseio.com/").getReference().child(system);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cStatus.setText(dataSnapshot.child("C").getValue().toString());
                javaStatus.setText(dataSnapshot.child("JAVA").getValue().toString());
                cPlusPlusStatus.setText(dataSnapshot.child("C++").getValue().toString());
                pythonStatus.setText(dataSnapshot.child("Python").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}