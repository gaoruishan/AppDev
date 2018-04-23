package org.xutils.common;

import org.xutils.common.task.AbsTask;

/**
 * Created by wyouflf on 15/6/11.
 * 任务管理接口
 */
public interface TaskController {

    /**
     * 在UI线程执行runnable.
     * 如果已在UI线程, 则直接执行.
     *
     * @param runnable 子线程
     */
    void autoPost(Runnable runnable);

    /**
     * 在UI线程执行runnable.
     * post到msg queue.
     *
     * @param runnable 子线程
     */
    void post(Runnable runnable);

    /**
     * 在UI线程执行runnable.
     *
     * @param runnable 子线程
     * @param delayMillis 延迟时间(单位毫秒)
     */
    void postDelayed(Runnable runnable, long delayMillis);

    /**
     * 在后台线程执行runnable
     *
     * @param runnable 子线程
     */
    void run(Runnable runnable);

    /**
     * 移除post或postDelayed提交的, 未执行的runnable
     *
     * @param runnable 子线程
     */
    void removeCallbacks(Runnable runnable);

    /**
     * 开始一个异步任务
     *
     * @param task 任务
     * @param <T> 泛型
     * @return 任务
     */
    <T> AbsTask<T> start(AbsTask<T> task);

    /**
     * 同步执行一个任务
     *
     * @param task 任务
     * @param <T> 泛型
     * @return 任务
     * @throws Throwable 异常
     */
    <T> T startSync(AbsTask<T> task) throws Throwable;

    /**
     * 批量执行异步任务
     *
     * @param groupCallback
     * @param tasks 任务
     * @param <T> 泛型
     * @return 回调
     */
    <T extends AbsTask<?>> Callback.Cancelable startTasks(Callback.GroupCallback<T> groupCallback, T... tasks);
}
