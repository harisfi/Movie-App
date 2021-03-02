package com.hryzx.movieapp.ui.tv_shows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.databinding.FragmentTvShowBinding;

import java.util.List;

public class TvShowFragment extends Fragment {

    private FragmentTvShowBinding fragmentTvShowBinding;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false);
        return fragmentTvShowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            TvShowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvShowViewModel.class);
            List<CinemaEntity> cinemas = viewModel.getTvShows(this.getContext());

            TvShowAdapter tvShowAdapter = new TvShowAdapter();
            tvShowAdapter.setCinemas(cinemas);
            fragmentTvShowBinding.rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvShowBinding.rvTvShows.setHasFixedSize(true);
            fragmentTvShowBinding.rvTvShows.setAdapter(tvShowAdapter);
        }
    }
}