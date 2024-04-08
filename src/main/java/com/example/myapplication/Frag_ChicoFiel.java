package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_ChicoFiel#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_ChicoFiel extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int page = 0;

    public Frag_ChicoFiel() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frag3.
     */
    // TODO: Rename and change types and number of parameters
    public  Frag_ChicoFiel newInstance(String param1, String param2) {
        Frag_ChicoFiel fragment = new Frag_ChicoFiel();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chico_fiel, container, false);

        TextView textView = view.findViewById(R.id.txtview_fiel);

        String[] texto = getResources().getStringArray(R.array.array_string_fiel);

        switch (page){
            case 0:
                textView.setText(texto[0]);
                break;
            case 1:
                textView.setText(texto[1]);
                break;
            case 2:
                textView.setText(texto[2]);
            default:
                textView.setText(texto[0]);
                break;
        }

        return view;
    }


    public void updateContent(int position) {
        TextView textView = getView().findViewById(R.id.txtview_fiel);
        String[] texto = getResources().getStringArray(R.array.array_string_fiel);

        switch (position) {
            case 0:
                textView.setText(texto[0]);
                break;
            case 1:
                textView.setText(texto[1]);
                break;
            case 2:
                textView.setText(texto[2]);
                break;
            default:
                textView.setText(texto[0]);
                break;
        }
    }

}