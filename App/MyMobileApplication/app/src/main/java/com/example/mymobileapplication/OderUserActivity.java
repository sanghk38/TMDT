package com.example.mymobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mymobileapplication.adapter.UserLocalStore;
import com.example.mymobileapplication.data.User;
import com.example.mymobileapplication.data.Uxer;

public class OderUserActivity extends AppCompatActivity {
   TextView idMyOrder;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_user);
        idMyOrder = findViewById(R.id.idOder);
        userLocalStore = new UserLocalStore(this);
        Uxer user = userLocalStore.getLoggedInUser();
        User users = userLocalStore.getLoggedInUser1();
        idMyOrder.setText(user.email);

    }
}