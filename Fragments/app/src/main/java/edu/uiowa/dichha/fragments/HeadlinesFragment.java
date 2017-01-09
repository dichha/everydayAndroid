package edu.uiowa.dichha.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by dichha on 1/9/2017.
 */

public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mCallback;

    //Container Activity must implement this interface
    public interface OnHeadlineSelectedListener{
        public void onArticleSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        //Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headlines));
    }
    @Override
    public void onStart(){
        super.onStart();
        //When in two-pane layout, set the listview to highlight the selected list item
        //(We do this during onStart because at the point the listview is available.)
        if(getFragmentManager().findFragmentById(R.id.article_fragment) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        //This makes sure that the container activity has implemented
        //the callback interface. If not, it throws an exception
        try{
            mCallback = (OnHeadlineSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        // Notify the parent activity of selected item
        mCallback.onArticleSelected(position);

        //Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position,true);
    }
}
