package com.example.enicarevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enicarevent.model.Utilisateur;
import com.example.enicarevent.retrofit.RetrofitService;
import com.example.enicarevent.retrofit.UtilisateurApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizializefunction();
    }

    private void inizializefunction() {
        EditText Inom;
        EditText IPrenom;
        EditText IEmail;
        EditText IClasse;
        EditText IMotdp;
        EditText IRole;
        EditText InomC;
        Button b;
        TextView e;

        Inom =findViewById(R.id.nom);
        IPrenom =findViewById(R.id.Prenom);
        IEmail =findViewById(R.id.email);
        IClasse =findViewById(R.id.classe);
        IMotdp =findViewById(R.id.mdp);
        IRole =findViewById(R.id.role);
        InomC =findViewById(R.id.nomC);
        b=findViewById(R.id.button);
        e=findViewById(R.id.aaa);

        RetrofitService retrofitService =   new RetrofitService();
        UtilisateurApi utilisateurApi =retrofitService.getRetrofit().create(UtilisateurApi.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom =Inom.getText().toString();
                String Prenom =IPrenom.getText().toString();
                String email =IEmail.getText().toString();
                String Classe =IClasse.getText().toString();
                String Motdepasse =IMotdp.getText().toString();
                String role =IRole.getText().toString();
                String nomclub =InomC.getText().toString();
                Utilisateur utilisateur =new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(Prenom);
                utilisateur.setEmail(email);
                utilisateur.setClasse(Classe);
                utilisateur.setMotdepasse(Motdepasse);
                utilisateur.setRole(role);
                utilisateur.setNomClub(nomclub);
                e.setText(utilisateur.getPrenom());
                utilisateurApi.save(utilisateur)
                        .enqueue(new Callback<Utilisateur>() {
                            @Override
                            public void onResponse(Call<Utilisateur>    call, Response<Utilisateur> response) {
                                Toast.makeText(MainActivity.this,"save success !",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Utilisateur> call, Throwable t) {
                                Toast.makeText(MainActivity.this,"save FAiled !",Toast.LENGTH_SHORT).show();
                                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"dali");
                            }
                        });




            }
        });





    }
}