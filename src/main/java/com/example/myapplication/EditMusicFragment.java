package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.myapplication.databinding.MusicFragmentBinding;

import java.util.Arrays;
import java.util.List;

public class EditMusicFragment extends Fragment {

    private MusicFragmentBinding binding;
    private Button btn_BackHistory;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = MusicFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        GridView gridView = view.findViewById(R.id.grid_editMusic);
        List<Integer> songResources = Arrays.asList(R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4, R.raw.song5, R.raw.song6);
        final GridAdapter adapter = new GridAdapter(requireContext(), songResources);
        gridView.setAdapter(adapter);

        Button btn_BackHistory = view.findViewById(R.id.btn_BackHistory);


        btn_BackHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.stop();
                Intent itBackHistory = new Intent(getActivity(), ChicoHistoryActivity.class);
                startActivity(itBackHistory);
            }
        });

        // Configurando botão para pausar e continuar a música
        Button btn_pause_continue = view.findViewById(R.id.btn_pause_continue);
        btn_pause_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getIsPlaying()) {
                    adapter.pauseMusic();
                } else {
                    adapter.resumeMusic();
                }
            }
        });

        return view;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}