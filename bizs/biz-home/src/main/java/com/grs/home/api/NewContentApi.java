package com.grs.home.api;

import com.grs.home.bean.RetResult;
import com.grs.home.bean.NewContent;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * <p class="note">File Note</p>
 * Created by qibin on 2017/11/8.
 */

public interface NewContentApi {

    @POST("content/findContent")
    Observable<RetResult<NewContent>> newContent(@Body RequestBody body);
}
