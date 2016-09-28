package myapp.tae.ac.uk.justeattest.UI.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.justeattest.Interfaces.OnListItemClickListener;
import myapp.tae.ac.uk.justeattest.Model.CuisineType;
import myapp.tae.ac.uk.justeattest.Model.Restaurant;
import myapp.tae.ac.uk.justeattest.R;

/**
 * Created by Kalpesh on 20/06/16.
 */
public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {
    private Context context;
    private List<Restaurant> restaurants;

    public RestaurantListAdapter(Context context, List<Restaurant> restaurants){
        this.context = context;
        this.restaurants = restaurants;
    }

    @Override
    public RestaurantListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.ViewHolder holder, int position) {
        final Restaurant restaurant = restaurants.get(position);
        Glide.with(context).load(restaurant.getLogo().get(0).getStandardResolutionURL())
                .into(holder.ivCoverImage);
        holder.tvRestaurantName.setText(restaurant.getName());
        holder.rbRestaurantListRate.setRating(restaurant.getRatingStars().floatValue());
        holder.rateCount.setText("("+restaurant.getNumberOfRatings()+")");
        holder.tvCuisine.setText(getCuisineTypesInText(restaurant.getCuisineTypes()));
        if(restaurant.getIsHalal()){
            holder.tvHalal.setText("Yes");
        }else
            holder.tvHalal.setText("No");
        if(restaurant.getIsOpenNow())
            holder.tvCloseOpenStatus.setText("OPEN");
        else
            holder.tvCloseOpenStatus.setText("CLOSED");
        holder.setListItemClickListener(new OnListItemClickListener() {
            @Override
            public void onListItemClicked(View view, int position) {
                Toast.makeText(context, "Restaurant "+restaurant.getName()+"is Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getCuisineTypesInText(List<CuisineType> cuisineTypes) {
        String cuisines = "";
        for (int i = 0; i < cuisineTypes.size(); i++) {
            cuisines+=cuisineTypes.get(i).getName();
            if(i<cuisineTypes.size()-1)
                cuisines+=", ";
        }
        return cuisines;
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.ivCoverImage)
        ImageView ivCoverImage;
        @Bind(R.id.tvRestaurantName)
        TextView tvRestaurantName;
        @Bind(R.id.rbListRating)
        RatingBar rbRestaurantListRate;
        @Bind(R.id.tvListItemRating)
        TextView rateCount;
        @Bind(R.id.tvCuisine)
        TextView tvCuisine;
        @Bind(R.id.tvHalalYesNo)
        TextView tvHalal;
        @Bind(R.id.tvCloseOpen)
        TextView tvCloseOpenStatus;

        private OnListItemClickListener listItemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
                ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setListItemClickListener(OnListItemClickListener listItemClickListener){
            this.listItemClickListener = listItemClickListener;
        }
        @Override
        public void onClick(View v) {
            if(listItemClickListener!=null)
                listItemClickListener.onListItemClicked(v, getLayoutPosition());
        }
    }
}
