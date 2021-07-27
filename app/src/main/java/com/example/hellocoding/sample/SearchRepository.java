package com.example.hellocoding.sample;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class SearchRepository {

    public MutableLiveData<NYTModel> liveData = new MutableLiveData<NYTModel>();

    public void fetchArticles(String searchTerm) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SearchService service = retrofit.create(SearchService.class);

        service.getArticles(searchTerm).enqueue(new Callback<NYTModel>() {
            @Override
             public void onResponse(Call<NYTModel> call, Response<NYTModel> response) {
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                    return;
                }
        }

            @Override
            public void onFailure(Call<NYTModel> call, Throwable t) {
            }
        });
    }

    public interface SearchService {
        @GET("/svc/search/v2/articlesearch.json?api-key=5IAtsEMOGCsZwlj67Wb4zAHPjNDfmkXs")
        public Call<NYTModel> getArticles(@Query("q") String query);
    }
}

