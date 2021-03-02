package com.hryzx.movieapp.ui.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hryzx.movieapp.R;
import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.databinding.ItemsCastListBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailCinemaAdapter extends RecyclerView.Adapter<DetailCinemaAdapter.CastViewHolder> {

    private final List<CastEntity> listCasts = new ArrayList<>();

    void setCasts(List<CastEntity> casts) {
        if (casts == null) return;
        listCasts.clear();
        listCasts.addAll(casts);
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsCastListBinding binding = ItemsCastListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CastViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder viewHolder, int position) {
        CastEntity cast = listCasts.get(position);
        viewHolder.bind(cast);
    }

    @Override
    public int getItemCount() {
        return listCasts.size();
    }

    static class CastViewHolder extends RecyclerView.ViewHolder {
        private final ItemsCastListBinding binding;

        CastViewHolder(ItemsCastListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CastEntity cast) {
            Glide.with(itemView.getContext())
                    .load(cast.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgCast);
        }
    }
}