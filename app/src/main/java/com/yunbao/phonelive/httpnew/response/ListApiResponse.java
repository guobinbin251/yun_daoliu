package com.yunbao.phonelive.httpnew.response;

import java.util.ArrayList;

/**
 * Created by Andy Guo on 2016/12/21.
 */

public class ListApiResponse<T> {

    private int code;
    private ArrayList<T> date;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<T> getDate() {
        return date;
    }

    public void setDate(ArrayList<T> date) {
        this.date = date;
    }
}

