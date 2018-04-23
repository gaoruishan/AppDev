package com.grs.test.api;

import com.commlibs.base.net.API;
import com.grs.test.bean.NewContent;
import com.grs.test.bean.RetResult;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * <p class="note">File Note</p>
 * Created by qibin on 2017/11/8.
 */

public interface NewContentApi {

    @POST(API.OL_SERVER_LINKCOOK + "content/findContent")
    Observable<RetResult<NewContent>> newContent(@Body RequestBody body);
}
