package com.example.demomelon.api;

import com.example.demomelon.model.entity.ActoresData;
import com.example.demomelon.model.entity.DetallesData;
import com.example.demomelon.model.entity.DetallesDos;
import com.example.demomelon.model.entity.EpisodiosData;
import com.example.demomelon.model.entity.SeriesData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ISerieService {

    @GET("search/series")
    Call<SeriesData> getSeriesSearch(@Header("Authorization")String token, @Query("name")String serie);

    //https://api.thetvdb.com/series/:id/episodes/query?airedSeason=1
    @GET("series/{id}/episodes/query")
    Call<EpisodiosData> getEpisode(@Header("Authorization")String token, @Path("id")String id, @Query("airedSeason")String numeroTemporadas);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("series/{id}")
    Call<DetallesData> getDetailsReult(@Header("Authorization")String token, @Path("id") String id);

    // https://{{endpoint}}/series/:id/actors
    @GET("series/{id}/actors")
    Call<ActoresData> getActors(@Header("Authorization")String token, @Path("id")String id);

}
