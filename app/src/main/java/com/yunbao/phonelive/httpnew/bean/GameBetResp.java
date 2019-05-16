package com.yunbao.phonelive.httpnew.bean;

public class GameBetResp {

    private GameBet2 bet;

    private double balance;

    public GameBet2 getBet() {
        return bet;
    }

    public void setBet(GameBet2 bet) {
        this.bet = bet;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
