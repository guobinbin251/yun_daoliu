package com.yunbao.phonelive.httpnew.bean;

public class NewLoginResp {
    private NewLoginUser user;
    private double poolBalance;
    private double balance;
    private String token;

    public void setUser(NewLoginUser user){
        this.user = user;
    }
    public NewLoginUser getUser(){
        return this.user;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }

    public double getPoolBalance() {
        return poolBalance;
    }

    public void setPoolBalance(double poolBalance) {
        this.poolBalance = poolBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
