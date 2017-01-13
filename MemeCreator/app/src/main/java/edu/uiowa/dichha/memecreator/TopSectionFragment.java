package edu.uiowa.dichha.memecreator;

/**
 * Created by dichha on 1/13/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


//extends is used so that the java class is a Fragment
public class TopSectionFragment extends Fragment{
    private static EditText topEditText;
    private static EditText bottomEditText;
    TopSectionListener activityCommander;
    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);
        topEditText = (EditText) view.findViewById(R.id.topTextInput);
        bottomEditText = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        buttonClicked(view);
                    }
                }
        );
        return view;
    }
    //Calls when button is clicked
    public void buttonClicked(View view){
        activityCommander.createMeme(topEditText.getText().toString(), bottomEditText.getText().toString());
    }
}
