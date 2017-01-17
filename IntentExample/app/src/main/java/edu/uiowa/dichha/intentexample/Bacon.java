package edu.uiowa.dichha.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        Bundle applesData = getIntent().getExtras();
        if(applesData == null){
            return;
        }
        String applesMessage = applesData.getString("applesMessage");
        final TextView baconText = (TextView) findViewById(R.id.baconText);
        Log.i("DEBUG", applesMessage);
        baconText.setText(applesMessage);
    }
    public void onClick(View view){
        Intent intent = new Intent(this, Apples.class);
        startActivity(intent);
    }
}
