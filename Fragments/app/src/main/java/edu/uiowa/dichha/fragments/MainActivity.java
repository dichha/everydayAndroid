package edu.uiowa.dichha.fragments;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlineSelectedListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
        //Check whether the activity is using the layout version with
        //the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null){

            //However, if we're being restored from a previous state,
            //then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if(savedInstanceState != null){
                return;
            }

            //Create a new Fragment to be placed in the activity layout
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            //In case this activity was started with special instructions from an
            //Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction();//.add(R.id.fragment_container,firstFragment).commit();
        }
    }
    public void onArticleSelected(int position){
        // the user selected the headline of an article from the HeadlineFragment

        // capture the article fragment from the activity layout
        ArticleFragment articleFrag = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if(articleFrag != null){
            //If article frag is available, we're in two-pane layout...
            //call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);
        }else{
            //If the frag is not available, we're in the one-pane layout and must swap frags...

            //Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //Replace whatever is in the fragment_container view with this fragment,
            //and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            //Commit the transaction
            transaction.commit();
        }
    }
}
