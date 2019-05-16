package com.yunbao.phonelive.httpnew;

import com.yunbao.phonelive.http.HttpConsts;
import com.yunbao.phonelive.httpnew.bean.AdItem;
import com.yunbao.phonelive.httpnew.bean.GetAd;
import com.yunbao.phonelive.httpnew.callback.HttpCallBack;

import java.util.ArrayList;


/**
 * Created by MMM on 2018/6/7.
 * 跳转页面
 */
public class HttpService {

    public static void getAd(String account, HttpCallBack<ArrayList<AdItem>> listener) {
        GetAd ad = new GetAd();
        ad.setAccount(account);
        NewHttpUtils.post(HttpConsts.GET_AD, ad, listener);
    }
}
