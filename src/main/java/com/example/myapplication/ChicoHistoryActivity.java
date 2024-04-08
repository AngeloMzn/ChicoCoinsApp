package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;




public class ChicoHistoryActivity extends AppCompatActivity {
    private ListView listHistoriaChico;
    private Spinner spinnerPage;
    private FragmentManager fm = getSupportFragmentManager();
    private Spinner spinner;
    private String spinnerPageItem = "0";
    private Button btn_music;
    private Button btn_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history_chico);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listHistoriaChico = findViewById(R.id.listHistoriaChico);
        ArrayAdapter adapterList = ArrayAdapter.createFromResource(this,R.array.list_HistoriaChico, android.R.layout.simple_list_item_1);
        listHistoriaChico.setAdapter(adapterList);

        spinnerPage = findViewById(R.id.spinnerPage);

        Frag_ChicoFiel fragChicoFiel = new Frag_ChicoFiel();
        fragChicoFiel.newInstance(spinnerPageItem, "");
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.direito, fragChicoFiel);
        ft.commit();

        spinnerPage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.direito);
                if (currentFragment instanceof Frag_ChicoFiel) {
                    Frag_ChicoFiel fragChicoFiel = (Frag_ChicoFiel) currentFragment;

                    switch (position){
                        case 0:
                            fragChicoFiel.updateContent(0);
                            break;
                        case 1:
                            fragChicoFiel.updateContent(1);
                            break;
                        case 2:
                            fragChicoFiel.updateContent(2);
                            break;
                    }
                } else if (currentFragment instanceof Frag_ChicoInfiel) {
                    Frag_ChicoInfiel fragChicoInfiel = (Frag_ChicoInfiel) currentFragment;

                    switch (position){
                        case 0:
                            fragChicoInfiel.updateContent(0);
                            break;
                        case 1:
                            fragChicoInfiel.updateContent(1);
                            break;
                        case 2:
                            fragChicoInfiel.updateContent(2);
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        listHistoriaChico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = fm.beginTransaction();
                switch (position){
                    case 0:
                        Frag_ChicoFiel fragChicoFiel = new Frag_ChicoFiel();

                        ft.replace(R.id.direito, fragChicoFiel);
                        ft.addToBackStack("pilha");
                        ft.commit();

                        break;
                    case 1:
                        Frag_ChicoInfiel fragChicoInfiel = new Frag_ChicoInfiel();
                        ft.replace(R.id.direito, fragChicoInfiel);
                        ft.addToBackStack("pilha");
                        ft.commit();
                        break;
                    case 2:
                        Frag_ChicoMentiroso fragChicoMentiroso = new Frag_ChicoMentiroso();
                        ft.replace(R.id.direito, fragChicoMentiroso);
                        ft.addToBackStack("pilha");
                        ft.commit();
                        break;


                }
            }
        });

        Button btn_music = findViewById(R.id.btn_music);

        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itMusic = new Intent(ChicoHistoryActivity.this, EditMusicActivity.class);
                startActivity(itMusic);
            }
        });

        Button btn_home = findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itHome = new Intent(ChicoHistoryActivity.this, MainActivity.class);
                startActivity(itHome);
            }
        });
    }
}