package com.commlibs.base.net;

import android.content.Context;
import android.support.annotation.NonNull;

import com.commlibs.base.R;
import com.commlibs.base.net.cert.CertUtil;
import com.commlibs.base.net.interceptors.HttpLoggingInterceptor;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * 网络请求管理器
 * @作者:gaoruishan
 * @时间:2018/3/2/10:01
 * @邮箱:grs0515@163.com
 */

public class RetrofitManager {

	//超时时间
	public static final int TIMEOUT = 8000;
	private static RetrofitManager INSTANCE;

	private RetrofitManager() {

	}
	//单例
	public synchronized static RetrofitManager getInstance() {
		if (null == INSTANCE) {
			synchronized (RetrofitManager.class) {
				if (null == INSTANCE) {
					INSTANCE = new RetrofitManager();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * 支持json解析
	 * @param baseUrl
	 * @return
	 */
	public Retrofit getGsonRetrofit(String baseUrl) {
		OkHttpClient okHttpClient = getOkHttpClient();


		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.client(okHttpClient)
				.build();
		return retrofit;
	}

	/**
	 * 获取OkHttpClient
	 * @return
	 */
	@NonNull
	private OkHttpClient getOkHttpClient() {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Level.BODY);
		return new OkHttpClient.Builder()
				.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
				.addInterceptor(interceptor)
				.build();
	}

	/**
	 * 支持SSL加密
	 * @param context
	 * @return
	 */
	public OkHttpClient getOkHttpClientSSL(Context context) {
		SSLSocketFactory sslSocketFactory = null;
		try {
			sslSocketFactory = CertUtil.getSSLSocketFactory_Certificate(context,"BKS", R.raw.ucloud_cer);
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Level.BODY);
		return new OkHttpClient.Builder()
				.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
				.addInterceptor(interceptor)
				.sslSocketFactory(sslSocketFactory)
				.build();
	}
	/**
	 * 支持xml解析
	 * @param baseUrl
	 * @return
	 */
	public Retrofit getXmlRetrofit(String baseUrl) {

		OkHttpClient okHttpClient = getOkHttpClient();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(SimpleXmlConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.client(okHttpClient)
				.build();
		return retrofit;
	}
}
