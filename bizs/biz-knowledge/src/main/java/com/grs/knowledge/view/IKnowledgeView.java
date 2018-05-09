package com.grs.knowledge.view;

import com.commlibs.base.mvp.IView;
import com.grs.knowledge.bean.KnowledgeTreeBean;

import java.util.List;

/**
 * @作者:gaoruishan
 * @时间:2018/2/12/15:41
 * @邮箱:grs0515@163.com
 */
public interface IKnowledgeView extends IView {

	void onKnowledgeList(List<KnowledgeTreeBean> content, boolean isCache);

	void onKnowledgeEmpty(boolean isCache);

	void onKnowledgeFailed(String msg);
}
