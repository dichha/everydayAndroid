package edu.uiowa.dichha.memecreator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.widget.TextView;



/**
 * Created by dichha on 1/13/2017.
 */

public class BottomPictureFragment extends Fragment {
    private static TextView topMemeText;
    private static TextView bottomMemeText;
    final private static String TAG = "DEBUG";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        topMemeText = (TextView) view.findViewById(R.id.topMemeText);
        bottomMemeText = (TextView) view.findViewById(R.id.bottomMemeText);
        return view;
    }
    public void setMemeText(String top, String bottom){
        topMemeText.setText(top);
        bottomMemeText.setText(bottom);
        /*Log.d(TAG,top);
        Log.d(TAG,bottom);*/
    }
}
