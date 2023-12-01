package com.example.enicarevent.retrofit;

import com.example.enicarevent.model.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UtilisateurApi {



    @GET("/utilisateur/getall")
    Call<List<Utilisateur>> getUtilisateur();

    @POST("/utilisateur/add")
    Call<Utilisateur> save(@Body Utilisateur utilisateur);
}
