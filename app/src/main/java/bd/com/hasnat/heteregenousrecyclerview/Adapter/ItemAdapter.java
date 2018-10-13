package bd.com.hasnat.heteregenousrecyclerview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bd.com.hasnat.heteregenousrecyclerview.Model.Advertise;
import bd.com.hasnat.heteregenousrecyclerview.Model.Movie;
import bd.com.hasnat.heteregenousrecyclerview.R;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Object> itemList;
    private final static int MOVIE = 1;
    private final static int ADVERTISE = 2;

    public ItemAdapter(List<Object> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position) instanceof Movie){
            return MOVIE;
        } else if (itemList.get(position) instanceof Advertise){
            return ADVERTISE;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        switch (viewType){
            case MOVIE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_single_row, viewGroup, false);
                return new MovieViewHolder(view);
            case ADVERTISE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ad_row, viewGroup, false);
                return new AdViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = viewHolder.getItemViewType();
        switch (type){
            case MOVIE:
                MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;
                Movie movie = (Movie) itemList.get(i);
                movieViewHolder.movie_image.setImageResource(movie.getImage());
                movieViewHolder.movie_name.setText(movie.getMovieName());
                movieViewHolder.movie_cat_name.setText(movie.getMovieCategory());
                break;
            case ADVERTISE:
                AdViewHolder adViewHolder = (AdViewHolder) viewHolder;
                Advertise advertise = (Advertise) itemList.get(i);
                adViewHolder.ad_image.setImageResource(advertise.getImageAd());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{
        private ImageView movie_image;
        private TextView movie_name, movie_cat_name;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_image = itemView.findViewById(R.id.movie_image);
            movie_name = itemView.findViewById(R.id.movie_name);
            movie_cat_name = itemView.findViewById(R.id.movie_cat_name);
        }


    }

    public class AdViewHolder extends RecyclerView.ViewHolder{
        private ImageView ad_image;
        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            ad_image = itemView.findViewById(R.id.ad_image);
        }
    }
}
