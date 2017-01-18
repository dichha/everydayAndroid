package edu.uiowa.dichha.scenetransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionInflater;


public class SceneTransitionActivity extends AppCompatActivity {

    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;
    Transition transitionMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transition);

        //Preparing a root container
        rootContainer = (ViewGroup) findViewById(R.id.rootContainer);

        transitionMgr = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        //referencing scenes created in xml
        scene1 = Scene.getSceneForLayout(rootContainer,R.layout.scene1_layout, this);
        scene2 = Scene.getSceneForLayout(rootContainer, R.layout.scene2_layout, this);

        //Entering scene
        scene1.enter();

    }
    //Implementing the Transitions

    public void goToScene2(View view){
        TransitionManager.go(scene2, transitionMgr);
    }

    public void goToScene1(View view){
        TransitionManager.go(scene1, transitionMgr);
    }

}
