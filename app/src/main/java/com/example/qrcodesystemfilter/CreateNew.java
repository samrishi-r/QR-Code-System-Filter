package com.example.qrcodesystemfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateNew extends AppCompatActivity {

    EditText name;
    EditText C;
    EditText java;
    EditText cPlusPlus;
    EditText python;
    Button create;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        name = (EditText) findViewById(R.id.nameInput);
        C = (EditText) findViewById(R.id.CStatus);
        java = (EditText) findViewById(R.id.JavaStatus);
        cPlusPlus = (EditText) findViewById(R.id.CPlusPlusStatus);
        python = (EditText) findViewById(R.id.PythonStatus);
        create = (Button) findViewById(R.id.CreateNew);

        databaseReference = FirebaseDatabase.getInstance("https://qr-code-system-filter-default-rtdb.firebaseio.com/").getReference();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child(name.getText().toString()).child("C").setValue(C.getText().toString());
                databaseReference.child(name.getText().toString()).child("JAVA").setValue(java.getText().toString());
                databaseReference.child(name.getText().toString()).child("C++").setValue(cPlusPlus.getText().toString());
                databaseReference.child(name.getText().toString()).child("Python").setValue(python.getText().toString());
                Intent intent = new Intent(getApplicationContext(),Generator.class);
                intent.putExtra("name",name.getText().toString());
                startActivity(intent);
            }
        });
    }
}