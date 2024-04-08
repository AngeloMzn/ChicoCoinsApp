package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.myapplication.databinding.MusicFragmentBinding;

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

        Button btn_BackHistory = view.findViewById(R.id.btn_BackHistory);

        btn_BackHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itBackHistory = new Intent(getActivity(), ChicoHistoryActivity.class);
                startActivity(itBackHistory);
            }
        });
        return binding.getRoot();
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