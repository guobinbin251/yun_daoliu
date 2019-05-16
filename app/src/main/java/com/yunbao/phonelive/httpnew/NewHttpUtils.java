package com.yunbao.phonelive.httpnew;


import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.tencent.cos.xml.utils.SharePreferenceUtils;
import com.yunbao.phonelive.Constants;
import com.yunbao.phonelive.activity.LoginActivity;
import com.yunbao.phonelive.httpnew.callback.HttpCallBack;
import com.yunbao.phonelive.httpnew.response.HttpResponse;
import com.yunbao.phonelive.utils.SpUtil;
import com.yunbao.phonelive.utils.ToastUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Andy Guo on 2016/12/22.
 * <p>
 * 网络连接封装工具类
 * <p>
 * OkHttp
 * 增加了Https的支持  Andy Guo on 2017/6/23.
 * Http优化调用方式，兼容后台的三种方式
 * 将callback以前单一返回字符串修改为底层剥离，直接返回上层用到实体类。在UI线程中  Andy Guo on 2017/7/13.
 */

public class NewHttpUtils {

    private static NewHttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    private static final String TAG = "newHttp";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String TOKEN = "token";

    private NewHttpUtils() {
        /**
         * 构建OkHttpClient
         */


        mOkHttpClient = new OkHttpClient.Builder()
                /**
                 * 设置连接的超时时间
                 */
                .connectTimeout(30000L, TimeUnit.MILLISECONDS)
                /**
                 * 请求的超时时间
                 */
                .readTimeout(30000L, TimeUnit.MILLISECONDS)
                /**
                 * 设置响应的超时时间
                 */
                .writeTimeout(30000L, TimeUnit.MILLISECONDS)
                //.Hande (new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER))


                /*.hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String url, SSLSession session) {
                        return url != null && (url.contains("192.168.35") || url.contains("gwtrader.net") || url.contains("phgsa.cn"));
                    }
                })*/

                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())//配置
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())//配
                .build();


        /**
         * 获取主线程的handler
         */
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 通过单例模式 构造对象
     *
     * @return OkHttpUtils
     */
    private synchronized static NewHttpUtils getInstance() {

        if (mInstance == null) {
            mInstance = new NewHttpUtils();
        }
        return mInstance;
    }

    /**
     * get请求
     * 暂时不封装get参数，业务层放入url中
     *
     * @param url      请求url
     * @param listener 监听回调
     */
    public static void get(@NonNull String url, HttpCallBack listener) {
        getInstance().getRequest(url, listener);
    }

    /**
     * post请求
     *
     * @param url      请求url
     * @param obj      参数
     * @param callBack 监听回调
     */
    public static void post(@NonNull String url, Object obj, HttpCallBack callBack) {
        getInstance().postRequest(url, obj, callBack);
    }


    /**
     * put请求
     *
     * @param url      请求url
     * @param obj      参数
     * @param callBack 监听回调
     */
    public static void put(@NonNull String url, Object obj, HttpCallBack callBack) {
        getInstance().putRequest(url, obj, callBack);
    }

    /**
     * delete请求
     *
     * @param url      请求url
     * @param obj      参数
     * @param callBack 监听回调
     */
    public static void delete(@NonNull String url, Object obj, HttpCallBack callBack) {
        getInstance().deleteRequest(url, obj, callBack);
    }

    /**
     * 构造Get请求
     *
     * @param url      请求的url
     * @param callBack 结果回调的方法
     */
    private void getRequest(@NonNull String url, final HttpCallBack callBack) {
        Log.d("newHttp", "url = " + url);
        final Request request = new Request.Builder().url(url).build();
        deliveryResult(request, callBack);
    }

    private void postRequest(@NonNull String url, @Nullable Object obj, HttpCallBack callBack) {

        /*
        //form表单的提交方式
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null) {
            Iterator<String> iterator = map.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next();
                builder.add(key, map.get(key));
            }
        }*/

        String json;
        if (obj != null) {
            json = JsonUtils.toJson(obj);
        } else {
            json = "";
        }
        Log.d(TAG, "http json = " + json);
        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json);
        Log.d(TAG, "http url = " + url);
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, "application/json")
                .addHeader(TOKEN, SpUtil.getInstance().getStringValue(SpUtil.NEW_TOKEN))
                .post(requestBody)
                .build();

        deliveryResult(request, callBack);
    }


    private void putRequest(@NonNull String url, @Nullable Object obj, HttpCallBack callBack) {
        String json = JsonUtils.toJson(obj);
        Log.d(TAG, "http json = " + json);
        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json);
        Log.d(TAG, "http url = " + url);
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();

        deliveryResult(request, callBack);
    }

    private void deleteRequest(@NonNull String url, @Nullable Object obj, HttpCallBack callBack) {
        String json = JsonUtils.toJson(obj);
        Log.d(TAG, "http json = " + json);
        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json);
        Log.d(TAG, "http url = " + url);
        Request request = new Request.Builder()
                .url(url)
                .delete(requestBody)
                .build();

        deliveryResult(request, callBack);
    }

    /**
     * 处理请求、返回结果
     *
     * @param request
     * @param callBack
     */
    private void deliveryResult(final Request request, @Nullable final HttpCallBack callBack) {

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
                try {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack != null) {
                                Log.e(TAG, "网络异常");
                                callBack.onFailure(Constants.RET_NET_ERROR, "网络异常");
                            }
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onResponse(Call call, @NonNull final Response response) throws IOException {
                final String resp = response.body().string();
                Log.d(TAG, "http resp = " + resp);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callBack != null) {
                            try {
                                HttpResponse<?> ret = JsonUtils.fromJson(resp, new TypeToken<HttpResponse<?>>() {
                                }.getType());
                                if (ret.getCode() == 0) {
                                    String jsonStr = JsonUtils.toJson(ret.getData());
                                    Object Obj = JsonUtils.fromJson(jsonStr, callBack.mType);
                                    callBack.onSuccess(Obj);
                                }else if(ret.getCode() == 999){
                                    ToastUtil.show("登录已失效，请重新登录");
                                    LoginActivity.forward();   ///999说明是token失效，这里直接跳转登录页面
                                } else {
                                    callBack.onFailure(ret.getCode(), ret.getMsg());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                callBack.onFailure(Constants.RET_DATA_CODE, "data error");
                            }
                        }
                    }
                });

            }
        });
    }

    private X509TrustManager systemDefaultTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:"
                        + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e) {
            throw new AssertionError(); // The system has no TLS. Just give up.
        }
    }

    private SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager trustManager) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustManager}, null);
            return sslContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError(); // The system has no TLS. Just give up.
        }
    }
}
