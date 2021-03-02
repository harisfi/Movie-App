package com.hryzx.movieapp.ui.tv_shows;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hryzx.movieapp.R;
import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.databinding.ItemsMoviesBinding;
import com.hryzx.movieapp.ui.detail.DetailCinemaActivity;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.CinemaViewHolder> {
    private final List<CinemaEntity> listCinemas = new ArrayList<>();

    void setCinemas(List<CinemaEntity> listCinemas) {
        if (listCinemas == null) return;
        this.listCinemas.clear();
        this.listCinemas.addAll(listCinemas);
    }

    @NonNull
    @Override
    public CinemaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsMoviesBinding binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CinemaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CinemaViewHolder holder, int position) {
        CinemaEntity cinema = listCinemas.get(position);
        holder.bind(cinema);
    }

    @Override
    public int getItemCount() {
        return listCinemas.size();
    }

    static class CinemaViewHolder extends RecyclerView.ViewHolder {

        private final ItemsMoviesBinding binding;

        CinemaViewHolder(ItemsMoviesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CinemaEntity cinema) {
            binding.tvItemTitle.setText(cinema.getTitle());
            binding.tvItemDate.setText(itemView.getResources().getString(R.string.date, cinema.getReleaseDate()));
            binding.tvItemOverview.setText(cinema.getOverview());
            binding.tvItemRating.setText(String.valueOf(cinema.getRating()));
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailCinemaActivity.class);
                intent.putExtra(DetailCinemaActivity.EXTRA_MOVIE, cinema.getCinemaId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(cinema.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}