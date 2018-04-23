
package com.commlibs.base.list;

import java.util.List;


/**
 * <p class="note">base request list interface</p>
 * */
public interface IBaseRequest<T> {

    /** 请求第一页数据*/
    void newData();
    /** 获取数据*/
    void getData();

    /** 请求数据*/
    void request();

    /**
     * 数据成功后调用
     * @param pageSize 有多少页 如果为-1 则代表无限页  0或1代表一页
     * @param datas 数据集
     */
    void onSuccess(int pageSize, List<T> datas);
    /** 数据获取失败后调用*/
    void onFailed(String msg);
}
