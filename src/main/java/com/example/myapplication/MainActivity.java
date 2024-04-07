package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;




public class MainActivity extends AppCompatActivity {
    private ListView list;
    private FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.listHistoriaChico);
        String[] lista = new String[]{"Chico mentiroso", "Chico infiel", "Chico o mais fiel"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        list.setAdapter(adapter);


        Frag_ChicoMentiroso fragChicoMentiroso = new Frag_ChicoMentiroso();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.direito, fragChicoMentiroso);
        ft.commit();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = fm.beginTransaction();
                switch (position){
                    case 0:
                        Frag_ChicoMentiroso fragChicoMentiroso = new Frag_ChicoMentiroso();
                        ft.replace(R.id.direito, fragChicoMentiroso);
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
                        Frag_ChicoFiel fragChicoFiel = new Frag_ChicoFiel();

                        ft.replace(R.id.direito, fragChicoFiel);
                        ft.addToBackStack("pilha");
                        ft.commit();
                        break;


                }
            }
        });
    }
}