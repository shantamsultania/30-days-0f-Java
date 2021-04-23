package com.example.myapplication;

import Api.RestApi;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //    private List<DataModel> dataModelList;
//    String TAG = "APItry";
    RestApi restApi = new RestApi();

    private Button getBtn, sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBtn = findViewById(R.id.getButton);
        sendBtn = findViewById(R.id.sendBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restApi.setContext(MainActivity.this);
                restApi.getAllDataModelList();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                restApi.setContext(MainActivity.this);
                restApi.addDataModel();
            }
        });


    }


}
