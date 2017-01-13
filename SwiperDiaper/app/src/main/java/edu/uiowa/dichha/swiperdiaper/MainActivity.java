package edu.uiowa.dichha.swiperdiaper;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.MotionEvent;
import android.view.GestureDetector;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    private TextView dianesMessage;
    private GestureDetectorCompat gestureDetector;
    private Button dianesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dianesMessage = (TextView) findViewById(R.id.dianesMessage);
        dianesButton = (Button) findViewById(R.id.dianesButton);
        dianesButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        dianesMessage.setText("Just got tapped");
                    }
                }
        );

        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

    }
    ////// Gesture Begins //////

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        dianesMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        dianesMessage.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        dianesMessage.setText("onSingleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        dianesMessage.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        dianesMessage.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        dianesMessage.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        dianesMessage.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        dianesMessage.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        dianesMessage.setText("onFling");
        return true;
    }
    /////Gesture End //////


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //check for gestureDetectore before the default
        this.gestureDetector.onTouchEvent(event);
        //default
        return super.onTouchEvent(event);
    }
}
