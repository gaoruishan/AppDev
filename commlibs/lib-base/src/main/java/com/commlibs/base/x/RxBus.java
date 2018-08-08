package com.commlibs.base.x;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Singleton RxBus
 * 使用RxJava封装的组件间通讯的工具类
 * 主要作用:
 * 用于替代组件间通讯的传统做法: EventBus,BoardcastReceiver...
 * <p>
 * RxBus的使用:
 * 发送事件:
 * RxBus.getDefault().send(new UserEvent (1, "jeffery"));
 * <p>
 * public class UserEvent {
 * long id;
 * String name;
 * public User Event(long id,String name) {
 * this.id= id;
 * this.name= name;
 * }
 * public long getId() {
 * return id;
 * }
 * public String getName() {
 * return name;
 * }
 * }
 * <p>
 * 接收事件:
 * // rxSubscription是一个Subscription的全局变量，这段代码可以在onCreate/onStart等生命周期内
 * rxSubscription = RxBus.getDefault().toObserverable(UserEvent.class)
 * .subscribe(new Action1<UserEvent>() {
 *
 * @Override public void call(UserEvent userEvent) {
 * long id = userEvent.getId();
 * String name = userEvent.getName();
 * ...
 * }
 * },
 * new Action1<Throwable>() {
 * @Override public void call(Throwable throwable) {
 * // TODO: 处理异常
 * }
 * });
 * <p>
 * 记得在生命周期结束的地方取消订阅事件，防止RxJava可能引起的内存泄漏问题
 * @Override protected void onDestroy() {
 * super.onDestroy();
 * if(!rxSubscription.isUnsubscribed()) {
 * rxSubscription.unsubscribe();
 * }
 * }
 * <p>
 * Created by JefferyLeng on 2016/7/30.
 */
public class RxBus {

    /**
     * 内存中默认的实例
     */
    private static volatile RxBus sDefaultInstance;

    private final Subject<Object, Object> bus;

    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
     */
    public RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 获取 RxBus的实例
     *
     * @return
     */
    public static RxBus getDefault() {
        if (sDefaultInstance == null) {
            synchronized (RxBus.class) {
                sDefaultInstance = new RxBus();
            }
        }
        return sDefaultInstance;
    }

    /**
     * 发送一个新的事件
     *
     * @param o
     */
    public void send(Object o) {
        bus.onNext(o);
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     *
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }


}
