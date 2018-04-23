package com.commlibs.utils.common;

import android.text.TextUtils;
import android.widget.Toast;

import com.commlibs.utils.App;


/**
 * Toast管理
 */
public class ToastUtil {

    public static Toast toast;

    public static void showShort(String text) {
        show(text, Toast.LENGTH_SHORT);
    }

    public static void showLong(String text) {
        show(text, Toast.LENGTH_LONG);
    }

    public static void showShort(int res) {
        show(App.get().getString(res), Toast.LENGTH_SHORT);
    }

    public static void showLong(int res) {
        show(App.get().getString(res), Toast.LENGTH_LONG);
    }

    public static void show(String text, int duration) {
        if (TextUtils.isEmpty(text)) { return;}
        text = contentChecker(text);
        if (toast == null) {
            toast = Toast.makeText(App.get(), text, duration);
        }

        toast.setText(text);
        toast.show();
    }

    /**
     * 内容过滤
     * @param content
     * @return
     */
    public static String contentChecker(String content) {
        if (content.isEmpty()) { return null;}
        if (content.contains("msg_error_http:okhttp")) { return "网络请求失败";}
        return content;
    }
}