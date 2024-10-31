package com.example.simplemvc;

//import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Model model;
    Controller controller;
    EditText txtName, txtTitle, txtPhone, txtOffice, txtStation;


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

        model = new Model(this);
        controller = new Controller(model, this);
        model.setController(controller);

        txtName = findViewById(R.id.txtName);
        txtTitle = findViewById(R.id.txtTitle);
        txtPhone = findViewById(R.id.txtPhone);
        txtOffice = findViewById(R.id.txtOffice);
        txtStation = findViewById(R.id.txtStation);

        Button btnNew = findViewById(R.id.btnNew);

        findViewById(R.id.btnNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");
                txtTitle.setText("");
                txtPhone.setText("");
                txtOffice.setText("");
                txtStation.setText("");
            }
        });

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String title = txtTitle.getText().toString();
                String phone = txtPhone.getText().toString();
                String office = txtOffice.getText().toString();
                String station = txtStation.getText().toString();

                try {
                    controller.addContact(name, title, phone, office, station);
                    viewContacts();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void receiveMessage(String message) {
        System.out.println(message);
    }

    public void viewContacts() {
        controller.getAllContacts();
    }


}