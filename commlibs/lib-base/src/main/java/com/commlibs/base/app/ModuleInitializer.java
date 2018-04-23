package com.commlibs.base.app;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.commlibs.base.image.GlideOptionsFactory;
import com.commlibs.utils.common.LogUtil;



/**
 * <p class="note">File Note</p>
 */

public class ModuleInitializer {

    public static final String DEVICE_PEMISSIONS = Manifest.permission.READ_PHONE_STATE;

    public static void init(Application application, boolean debugMode, @DrawableRes int defaultDrawable) {
        LogUtil.setEnable(debugMode);
//        configNet(debugMode);
        configImageLoader(application, defaultDrawable);
//        DataProvider.setDevice(new DeviceBean(application));
//        DataProvider.setUser_id(UserUtils.userIdFromSp());
    }

    public static void configDevice(@NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (DataProvider.getDevice() != null) { return;}
        int count = permissions.length;

        for (int i = 0; i < count; i++) {
            if (DEVICE_PEMISSIONS.equals(permissions[i]) && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
//                DataProvider.getDevice().setImeiAndMac();
                break;
            }
        }
    }

//    private static void configNet(boolean debug) {
//        configNet(debug, new ResultInterceptor());
//    }
//
//    private static void configNet(boolean debug, IResultInterceptor interceptor) {
//        String cacheDir = Environment.getExternalStorageDirectory() + Constant.DIR_CACHE;
//
//        Http.HttpConfiguration xcookConfig = new Http.HttpConfiguration()
//                .baseUrl("").debug(debug).timeout(5 * 1000)
//                .cacheDir(cacheDir).cacheSize(1024 * 1024)
//                .resultInterceptor(interceptor)
//                .parser(new JsonParserFactory(Http.INNER));
//
//        Http.HttpConfiguration linkcookConfig = xcookConfig.copy()
//                .parser(new JsonParserFactory(Http.OUTER))
//                .resultInterceptor(null);
//
//        Http.HttpConfiguration generalConfig = linkcookConfig.copy()
//                .parser(new JsonParserFactory(Http.GENERAL))
//                .resultInterceptor(null);
//
//        Http.init(xcookConfig, linkcookConfig, generalConfig);
//    }

    private static void configImageLoader(Context ctx, int defaultIcon) {
        GlideOptionsFactory.init(ctx, defaultIcon);
    }
}
