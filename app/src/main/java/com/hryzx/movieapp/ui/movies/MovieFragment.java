package com.hryzx.movieapp.ui.movies;

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
import com.hryzx.movieapp.databinding.FragmentMovieBinding;

import java.util.List;

public class MovieFragment extends Fragment {

    private FragmentMovieBinding fragmentMovieBinding;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false);
        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            MovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MovieViewModel.class);
            List<CinemaEntity> cinemas = viewModel.getMovies(this.getContext());

            MovieAdapter movieAdapter = new MovieAdapter();
            movieAdapter.setCinemas(cinemas);
            fragmentMovieBinding.rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentMovieBinding.rvMovies.setHasFixedSize(true);
            fragmentMovieBinding.rvMovies.setAdapter(movieAdapter);
        }
    }
}