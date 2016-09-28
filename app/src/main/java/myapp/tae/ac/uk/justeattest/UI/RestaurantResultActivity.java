package myapp.tae.ac.uk.justeattest.UI;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.justeattest.Constants.Constants;
import myapp.tae.ac.uk.justeattest.Model.Restaurant;
import myapp.tae.ac.uk.justeattest.R;
import myapp.tae.ac.uk.justeattest.UI.adapter.RestaurantListAdapter;

/**
 * Created by Kalpesh on 20/06/16.
 */
public class RestaurantResultActivity extends AppCompatActivity {
    @Bind(R.id.rcRestaurantList)
    RecyclerView rcRestaurantList;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private RestaurantListAdapter adapter;
    private List<Restaurant> restaurants;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_results_activity);
        ButterKnife.bind(this);
        setupToolbar();
        if(savedInstanceState==null){
            restaurants = getIntent().getParcelableArrayListExtra(Constants.RESTAURANT_LIST);
        }else {
            restaurants = savedInstanceState.getParcelableArrayList(Constants.RESTAURANT_LIST);
        }
        adapter = new RestaurantListAdapter(this, restaurants);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcRestaurantList.setLayoutManager(linearLayoutManager);
        rcRestaurantList.setAdapter(adapter);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(Constants.RESTAURANT_LIST, (ArrayList<? extends Parcelable>) restaurants);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
