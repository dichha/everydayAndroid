package edu.uiowa.dichha.intentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);
    }
    public void onClick(View view){
        Intent intent = new Intent(this, Bacon.class);
        final EditText appleInput = (EditText) findViewById(R.id.applesInput);
        String userMessage = appleInput.getText().toString();
        intent.putExtra("applesMessage", userMessage);
        startActivity(intent);
    }


}
