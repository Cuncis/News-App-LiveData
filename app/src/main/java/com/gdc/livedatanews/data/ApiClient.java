package com.gdc.livedatanews.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gdc.livedatanews.BuildConfig.BASE_URL;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static BlogApiService getBlogApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(BlogApiService.class);
    }

}
