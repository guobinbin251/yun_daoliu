package com.yunbao.phonelive.httpnew;

import com.yunbao.phonelive.http.HttpConsts;
import com.yunbao.phonelive.httpnew.bean.AgentInfo;
import com.yunbao.phonelive.httpnew.bean.AgentInfoReq;
import com.yunbao.phonelive.httpnew.bean.AgentUpdateReq;
import com.yunbao.phonelive.httpnew.bean.Binding;
import com.yunbao.phonelive.httpnew.bean.ChangePwd;
import com.yunbao.phonelive.httpnew.bean.CsResp;
import com.yunbao.phonelive.httpnew.bean.CurrentGame;
import com.yunbao.phonelive.httpnew.bean.CurrentGameResp;
import com.yunbao.phonelive.httpnew.bean.GameBet;
import com.yunbao.phonelive.httpnew.bean.GameBetResp;
import com.yunbao.phonelive.httpnew.bean.GameBetTotalResp;
import com.yunbao.phonelive.httpnew.bean.GameFetch;
import com.yunbao.phonelive.httpnew.bean.GameFetchResp;
import com.yunbao.phonelive.httpnew.bean.GameOpen;
import com.yunbao.phonelive.httpnew.bean.GameResp;
import com.yunbao.phonelive.httpnew.bean.GameShoeResp;
import com.yunbao.phonelive.httpnew.bean.ListBet;
import com.yunbao.phonelive.httpnew.bean.ListBetResp;
import com.yunbao.phonelive.httpnew.bean.ListWaterResp;
import com.yunbao.phonelive.httpnew.bean.NewGame;
import com.yunbao.phonelive.httpnew.bean.NewGameResp;
import com.yunbao.phonelive.httpnew.bean.NewLogin;
import com.yunbao.phonelive.httpnew.bean.NewLoginResp;
import com.yunbao.phonelive.httpnew.bean.NewRegister;
import com.yunbao.phonelive.httpnew.bean.NewRegisterResp;
import com.yunbao.phonelive.httpnew.bean.ShoeResult;
import com.yunbao.phonelive.httpnew.bean.Withdraw;
import com.yunbao.phonelive.httpnew.callback.HttpCallBack;

import java.util.ArrayList;


/**
 * Created by MMM on 2018/6/7.
 * 跳转页面
 */
public class HttpService {


    public static void signUp(String account, String pwd, String referral, String tId, HttpCallBack<NewRegisterResp> listener) {
        NewRegister register = new NewRegister();
        register.setAccount(account);
        register.setPwd(pwd);
        register.setReferral(referral);
        register.setTid(tId);
        NewHttpUtils.post(HttpConsts.NEW_REGISTER, register, listener);
    }

    public static void login(String account, String pwd,String nicename, HttpCallBack<NewLoginResp> listener) {
        NewLogin login = new NewLogin();
        login.setAccount(account);
        login.setPwd(pwd);
        login.setNicename(nicename);
        NewHttpUtils.post(HttpConsts.NEW_LOGIN, login, listener);
    }


    public static void binding(String realName, String accountId, String bankName, HttpCallBack<Object> listener) {
        Binding binding = new Binding();
        binding.setBankCardNo(accountId);
        binding.setBankName(bankName);
        binding.setRealname(realName);
        NewHttpUtils.post(HttpConsts.NEW_BINDING, binding, listener);
    }


    public static void withdraw(double amount, HttpCallBack<Double> listener) {
        Withdraw withdraw = new Withdraw();
        withdraw.setAmount(amount);
        NewHttpUtils.post(HttpConsts.NEW_WITHDRAW, withdraw, listener);
    }

    public static void newGame(int gameType, HttpCallBack<NewGameResp> listener) {
        NewGame newGame = new NewGame();
        newGame.setGameType(gameType);
        NewHttpUtils.post(HttpConsts.NEW_GAME_NEW, newGame, listener);
    }

    public static void newShoeNew(HttpCallBack<GameShoeResp> listener) {
        NewHttpUtils.post(HttpConsts.NEW_GAME_SHOE_NEW, null, listener);
    }

    //当前游戏
    public static void currentGame(String tid, HttpCallBack<CurrentGameResp> listener) {
        CurrentGame currentGame = new CurrentGame();
        currentGame.setTid(tid);
        NewHttpUtils.post(HttpConsts.NEW_GAME_CURRENT, currentGame, listener);
    }

    //下注
    public static void gameBet(GameBet bet, HttpCallBack<GameBetResp> listener) {

        NewHttpUtils.post(HttpConsts.NEW_GAME_BET, bet, listener);
    }

    //开奖
    public static void gameOpen(GameOpen gameOpen, HttpCallBack<GameResp> listener) {
        NewHttpUtils.post(HttpConsts.NEW_GAME_OPEN, gameOpen, listener);
    }

    //当前游戏
    public static void gameFetch(int gid, HttpCallBack<GameFetchResp> listener) {
        GameFetch gameFetch = new GameFetch();
        gameFetch.setGid(gid);
        NewHttpUtils.post(HttpConsts.NEW_GAME_RESULT_FETCH, gameFetch, listener);
    }

    //当前游戏
    public static void gameBetTotal(int gid, HttpCallBack<GameBetTotalResp> listener) {
        GameFetch gameFetch = new GameFetch();
        gameFetch.setGid(gid);
        NewHttpUtils.post(HttpConsts.NEW_GAME_BET_TOTAL, gameFetch, listener);
    }

    //查询记录
    public static void gameListBet(ListBet list, HttpCallBack<ListBetResp> listener) {
        NewHttpUtils.post(HttpConsts.NEW_GAME_LIST_BET, list, listener);
    }

    //
    public static void gameListWater(ListBet list, HttpCallBack<ListWaterResp> listener) {
        NewHttpUtils.post(HttpConsts.NEW_GAME_LIST_WATER, list, listener);
    }

    //查询记录
    public static void csInfo(HttpCallBack<CsResp> listener) {
        NewHttpUtils.post(HttpConsts.NEW_GAME_CS_INFO, null, listener);
    }

    //查询记录
    public static void newRoom(int gameType, String name, HttpCallBack<Object> listener) {
        NewGame newGame = new NewGame();
        newGame.setGameType(gameType);
        newGame.setNicename(name);
        NewHttpUtils.post(HttpConsts.NEW_GAME_OPEN_ROOM, newGame, listener);
    }

    //当靴结果
    public static void shoeResult(String anchorTid, int shoe, HttpCallBack<ArrayList<String>> listener) {
        ShoeResult result = new ShoeResult();
        result.setAnchorTid(anchorTid);
        result.setShoe(shoe);
        NewHttpUtils.post(HttpConsts.NEW_GAME_SHOE_RESULT, result, listener);
    }

    //查询洗码率
    public static void getAgent(long uid, HttpCallBack<ArrayList<AgentInfo>> listener) {
        AgentInfoReq req = new AgentInfoReq();
        req.setUid(uid);
        NewHttpUtils.post(HttpConsts.NEW_AGENT_SUB, req, listener);
    }

    //查询洗码率
    public static void updateAgent(long uid, int ximaRate,HttpCallBack<Object> listener) {
        AgentUpdateReq req = new AgentUpdateReq();
        req.setSubUid(uid);
        req.setXimaRate(ximaRate);
        NewHttpUtils.post(HttpConsts.NEW_AGENT_SUB_UPDATE, req, listener);
    }

    //修改登陆密码
    public static void changePasswd(String oldPwd, String newPwd,HttpCallBack<Object> listener) {
        ChangePwd req = new ChangePwd();
        req.setOldPwd(oldPwd);
        req.setNewPwd(newPwd);
        NewHttpUtils.post(HttpConsts.NEW_AGENT_CHANGE_PWD, req, listener);
    }
}
