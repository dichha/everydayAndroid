package edu.uiowa.dichha.smartbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button dianesButton = (Button)findViewById(R.id.dianesButton);
        /*
        dianesButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    TextView dianesText = (TextView) findViewById(R.id.dianesText);
                    dianesText.setText("Good Job Hoss");
                }

        });
        */
        dianesButton.setOnClickListener(
                new Button.OnClickListener(){
                        public void onClick(View v){
                            TextView dianesText = (TextView) findViewById(R.id.dianesText);
                            dianesText.setText("Good Job Hoss");
                        }

                }
        );
        dianesButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView dianesText = (TextView) findViewById(R.id.dianesText);
                        dianesText.setText("Holy holy, that was a long one!");
                        return true;
                    }
                }
        );






    }
}
