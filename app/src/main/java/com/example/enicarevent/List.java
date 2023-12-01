package com.example.enicarevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.enicarevent.adapter.UtilisateurAdapter;
import com.example.enicarevent.model.Utilisateur;
import com.example.enicarevent.retrofit.RetrofitService;
import com.example.enicarevent.retrofit.UtilisateurApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List<U> extends AppCompatActivity {
    private RecyclerView rv;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        b=findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        }

        );

        loadUtilisateur();
    }

    private void loadUtilisateur() {
        RetrofitService retrofitService =   new RetrofitService();
        UtilisateurApi utilisateurApi =retrofitService.getRetrofit().create(UtilisateurApi.class);
        utilisateurApi.getUtilisateur().enqueue(new Callback<java.util.List<Utilisateur>>() {
            @Override
            public void onResponse(Call<java.util.List<Utilisateur>> call, Response<java.util.List<Utilisateur>> response) {
                populateListVirw (response.body());
            }

            @Override
            public void onFailure(Call<java.util.List<Utilisateur>> call, Throwable t) {
                Toast.makeText(List.this,"okok bb!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateListVirw(java.util.List<Utilisateur> body) {
        UtilisateurAdapter utilisateurAdapter=new UtilisateurAdapter(body);
        rv.setAdapter(utilisateurAdapter);
    }
}