package com.example.hellocoding.sample;

import java.util.List;


// API Key: 5IAtsEMOGCsZwlj67Wb4zAHPjNDfmkXs
// BaseUrl: https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=5IAtsEMOGCsZwlj67Wb4zAHPjNDfmkXs

//@GET("/svc/search/v2/articlesearch.json?api-key=5IAtsEMOGCsZwlj67Wb4zAHPjNDfmkXs")
//public Call<NYTModel> getArticles(@Query("q") String query);

public class NYTModel {
    public String status;
    public Response response;
}

class Response {
    List<Docs> docs;
}

class Docs {
    public String snippet;
}
