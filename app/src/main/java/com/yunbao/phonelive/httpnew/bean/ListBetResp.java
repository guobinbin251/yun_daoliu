package com.yunbao.phonelive.httpnew.bean;

import java.util.ArrayList;

public class ListBetResp {

    private int count;
    private ArrayList<ListBet> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<ListBet> getList() {
        return list;
    }

    public void setList(ArrayList<ListBet> list) {
        this.list = list;
    }

    public class ListBet {
        private double wagerTotal;
        private int game_num;
        private String open_time;
        private String nicename;
        private int bet5;
        private double validWater;
        private double zd;
        private double bet3;
        private double xd;
        private double bet4;
        private double bet1;
        private double bet2;
        private double result;
        private int anchor_uid;
        private double win;
        private int shoe;
        private double balance;

        public double getWagerTotal() {
            return wagerTotal;
        }

        public void setWagerTotal(double wagerTotal) {
            this.wagerTotal = wagerTotal;
        }

        public int getGame_num() {
            return game_num;
        }

        public void setGame_num(int game_num) {
            this.game_num = game_num;
        }

        public String getOpen_time() {
            return open_time;
        }

        public void setOpen_time(String open_time) {
            this.open_time = open_time;
        }

        public int getBet5() {
            return bet5;
        }

        public void setBet5(int bet5) {
            this.bet5 = bet5;
        }

        public double getValidWater() {
            return validWater;
        }

        public void setValidWater(double validWater) {
            this.validWater = validWater;
        }

        public double getZd() {
            return zd;
        }

        public void setZd(double zd) {
            this.zd = zd;
        }

        public double getBet3() {
            return bet3;
        }

        public void setBet3(double bet3) {
            this.bet3 = bet3;
        }

        public double getXd() {
            return xd;
        }

        public void setXd(double xd) {
            this.xd = xd;
        }

        public double getBet4() {
            return bet4;
        }

        public void setBet4(double bet4) {
            this.bet4 = bet4;
        }

        public double getBet1() {
            return bet1;
        }

        public void setBet1(double bet1) {
            this.bet1 = bet1;
        }

        public double getBet2() {
            return bet2;
        }

        public void setBet2(double bet2) {
            this.bet2 = bet2;
        }

        public double getResult() {
            return result;
        }

        public void setResult(double result) {
            this.result = result;
        }

        public int getAnchor_uid() {
            return anchor_uid;
        }

        public void setAnchor_uid(int anchor_uid) {
            this.anchor_uid = anchor_uid;
        }

        public double getWin() {
            return win;
        }

        public void setWin(double win) {
            this.win = win;
        }

        public int getShoe() {
            return shoe;
        }

        public void setShoe(int shoe) {
            this.shoe = shoe;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getNicename() {
            return nicename;
        }

        public void setNicename(String nicename) {
            this.nicename = nicename;
        }

    }


}
