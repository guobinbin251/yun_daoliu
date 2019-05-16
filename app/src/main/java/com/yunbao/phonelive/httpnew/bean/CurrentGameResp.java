package com.yunbao.phonelive.httpnew.bean;

public class CurrentGameResp {
    private int gameType;
    private int gid;
    private int gameNum;
    private String gameStartTime;
    private int countdown;
    private int bet1;
    private int bet2;
    private int bet3;
    private int bet4;
    private int bet5;
    private float poolBalance;
    private int anchorUid;
    private int shoe;
    private int limitStart;
    private int limitEnd;


    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getGameNum() {
        return gameNum;
    }

    public void setGameNum(int gameNum) {
        this.gameNum = gameNum;
    }

    public String getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(String gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public int getAnchorUid() {
        return anchorUid;
    }

    public void setAnchorUid(int anchorUid) {
        this.anchorUid = anchorUid;
    }

    public int getShoe() {
        return shoe;
    }

    public void setShoe(int shoe) {
        this.shoe = shoe;
    }

    public int getBet1() {
        return bet1;
    }

    public void setBet1(int bet1) {
        this.bet1 = bet1;
    }

    public int getBet2() {
        return bet2;
    }

    public void setBet2(int bet2) {
        this.bet2 = bet2;
    }

    public int getBet3() {
        return bet3;
    }

    public void setBet3(int bet3) {
        this.bet3 = bet3;
    }

    public int getBet4() {
        return bet4;
    }

    public void setBet4(int bet4) {
        this.bet4 = bet4;
    }

    public int getBet5() {
        return bet5;
    }

    public void setBet5(int bet5) {
        this.bet5 = bet5;
    }

    public float getPoolBalance() {
        return poolBalance;
    }

    public void setPoolBalance(float poolBalance) {
        this.poolBalance = poolBalance;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd = limitEnd;
    }
}
