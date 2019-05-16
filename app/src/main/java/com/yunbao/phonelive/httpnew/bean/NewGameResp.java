package com.yunbao.phonelive.httpnew.bean;

public class NewGameResp {
    private int id;//游戏ID
    private int uid;    //主播id
    private int shoe;//靴号
    private int gameNum;//当前靴的局号
    private int gameType; //游戏类型
    private int result; //结果 0是未开奖
    private String createTime;
    private int countDown; //倒计时
    private double poolBalance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getShoe() {
        return shoe;
    }

    public void setShoe(int shoe) {
        this.shoe = shoe;
    }

    public int getGameNum() {
        return gameNum;
    }

    public void setGameNum(int gameNum) {
        this.gameNum = gameNum;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public double getPoolBalance() {
        return poolBalance;
    }

    public void setPoolBalance(double poolBalance) {
        this.poolBalance = poolBalance;
    }
}
