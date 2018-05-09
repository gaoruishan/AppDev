package com.grs.knowledge.api;

import com.grs.knowledge.bean.DataResult;
import com.grs.knowledge.bean.KnowledgeTreeBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @作者:gaoruishan
 * @时间:2018/2/12/15:41
 * @邮箱:grs0515@163.com
 */

public interface KnowledgeApi {

	@GET("tree/json")
	Observable<DataResult<KnowledgeTreeBean>> getKnowledgeTree();
}
