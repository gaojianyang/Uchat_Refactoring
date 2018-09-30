package com.personal.xiri.data.net;

import com.personal.xiri.data.entity.SkinEntity;
import com.personal.xiri.domin.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Gaojianyang on 18/9/11.
 * github https://github.com/gaojianyang
 */
public interface SkinApi {
    @GET("skin/recent")
    Observable<Response<List<SkinEntity>>> getRecentSkins();

    @POST("skin/create")
    Observable<Response<Integer>> createSkin(@Body SkinEntity skinEntity);

    @POST("skin/update")
    Observable<Response<Integer>> updateSkin(@Body SkinEntity skinEntity);

}
