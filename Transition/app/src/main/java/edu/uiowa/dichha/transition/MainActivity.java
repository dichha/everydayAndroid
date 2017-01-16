package edu.uiowa.dichha.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {
    ViewGroup dianesLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dianesLayout = (ViewGroup) findViewById(R.id.dianesLayout);

        dianesLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        moveButton();
                        return true;
                    }
                }
        );
    }
    public void moveButton(){
        View dianesButton = (View) findViewById(R.id.dianesButton);
        //default slow transition
        TransitionManager.beginDelayedTransition(dianesLayout);

        //Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        dianesButton.setLayoutParams(positionRules);
        //Change the size of the button

        ViewGroup.LayoutParams sizeRules = dianesButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;

        dianesButton.setLayoutParams(sizeRules);



    }
}
