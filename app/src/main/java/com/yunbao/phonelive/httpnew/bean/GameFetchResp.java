package com.yunbao.phonelive.httpnew.bean;

public class GameFetchResp {

    private OpenedGame openedGame;
    private double balance;
    private double poolBalance;
    private Win win;
    public OpenedGame getOpenedGame() {
        return openedGame;
    }

    public void setOpenedGame(OpenedGame openedGame) {
        this.openedGame = openedGame;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPoolBalance() {
        return poolBalance;
    }

    public void setPoolBalance(double poolBalance) {
        this.poolBalance = poolBalance;
    }

    public Win getWin() {
        return win;
    }

    public void setWin(Win win) {
        this.win = win;
    }
}
