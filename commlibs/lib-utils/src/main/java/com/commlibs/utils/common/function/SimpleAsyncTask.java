package com.commlibs.utils.common.function;

/**
 * Created by ZhangTao on 1/17/17.
 */

import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;

import java.util.concurrent.Callable;

/**
 * Simplify the basic usage of {@link AsyncTask}.
 * <p>
 * Created by Oasis on 2016/11/6.
 */
public abstract class SimpleAsyncTask extends AsyncTask<Void, Void, Void> {

    @MainThread
    public static void execute(final Runnable do_in_background, final Runnable on_post_execute) {
        new SimpleAsyncTask() {
            @Override
            protected void doInBackground() {
                do_in_background.run();
            }

            @Override
            protected void onPostExecute() {
                on_post_execute.run();
            }
        }.execute();
    }

    /**
     * Execute background task and deal with the result in post-execute procedure
     */
    @MainThread
    public static <T> void execute(final Supplier<T> do_in_background, final Consumer<T> on_post_execute) {
        new AsyncTask<Void, Void, T>() {
            @Override
            protected T doInBackground(final Void... params) {
                return do_in_background.get();
            }

            @Override
            protected void onPostExecute(final T result) {
                on_post_execute.accept(result);
            }
        }.execute();
    }

    /**
     * Execute background task with possible exception caught in post-execute procedure
     */
    @MainThread
    public static void execute(final Callable<Exception> do_in_background, final Consumer<Exception> on_post_execute) {
        new AsyncTask<Void, Void, Exception>() {
            @Override
            protected Exception doInBackground(final Void... params) {
                try {
                    return do_in_background.call();
                } catch (final Exception e) {
                    return e;
                }
            }

            @Override
            protected void onPostExecute(final Exception result) {
                on_post_execute.accept(result);
            }
        }.execute();
    }

    @WorkerThread
    protected abstract void doInBackground();

    @MainThread
    protected abstract void onPostExecute();

    @Override
    @WorkerThread
    protected final Void doInBackground(final Void... params) {
        doInBackground();
        return null;
    }

    @Override
    @MainThread
    protected final void onPostExecute(final Void aVoid) {
        onPostExecute();
    }
}