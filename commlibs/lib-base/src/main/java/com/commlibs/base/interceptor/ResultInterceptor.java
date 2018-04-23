//package com.commlibs.base.interceptor;
//
//import android.content.Intent;
//import android.os.Handler;
//import android.os.Looper;
//import android.text.TextUtils;
//
//import com.commlibs.base.data.DataProvider;
//import com.commlibs.utils.App;
//import com.commlibs.utils.common.LogUtil;
//
//import org.loader.glin.Result;
//import org.loader.glin.interceptor.IResultInterceptor;
//import org.loader.okclient.OkClient;
//
//
//public class ResultInterceptor implements IResultInterceptor {
//
//    private static final String ACT_REFRESH_TOKEN = "hs.act.refresh.token";
//    private static final String ACT_REQUEST_FRIDGE_ID = "hs.act.request.fridge.id";
//    private static final String PKG_SERVICE = "com.haiersmart.user";
//
//    public static final int TOKEN_NULL = 9998;
//    public static final int TOKEN_INVALID = 9999;
//
//    public static final int DELAY_MS = 5000;
//
//    private Handler mHandler = new Handler(Looper.getMainLooper());
//
//    @Override
//    public boolean intercept(final Result<?> result) {
//        if (!result.isOK()) {
//            // check token
//            Object obj = result.getObj();
//            if (obj != null && TextUtils.isDigitsOnly(obj.toString())) {
//                int code = Integer.parseInt(obj.toString());
//                if (code == TOKEN_INVALID) {//token9999
//                    LogUtil.d("Glin", "has no authon_token, request for authon_token!!!");
//                    startService(ACT_REFRESH_TOKEN);
//                }
//            }
//
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    // check fridge_id
//                    if (canRequest(result.getMessage()) && TextUtils.isEmpty(fridgeId())) {
//                        // 自动获取fridge_id
//                        LogUtil.d("Glin", "has no fridge id, request for fridge id!!!");
//                        startService(ACT_REQUEST_FRIDGE_ID);
//                    }
//
//                    // check authon_token
//                    if (canRequest(result.getMessage()) && TextUtils.isEmpty(authToken())) {
//                        // 自动获取authon_token
//                        LogUtil.d("Glin", "has no authon_token, request for authon_token!!!");
//                        //TODO 暂时不请求
////                        requestAuthonToken();
//                    }
//                }
//            }, DELAY_MS);
//        }
//
//        return false;
//    }
//
//    private boolean canRequest(String msg) {
//        if (TextUtils.isEmpty(msg)) {
//            return true;
//        }
//
//        if (msg.equals(OkClient.MSG_ERROR_HTTP)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    private void startService(String act) {
//        Intent it = new Intent(act);
////        it.setPackage(App.get().getPackageName());
//        it.setPackage(PKG_SERVICE);
//        App.get().startService(it);
//    }
//
//    protected String fridgeId() {
//        return DataProvider.get().getFridge_id();
//    }
//
//    protected String authToken() {
//        return DataProvider.get().getAuthen_token();
//    }
//}