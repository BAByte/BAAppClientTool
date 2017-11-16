package com.example.ba.myjacksondemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by BA on 2017/11/9 0009.
 *
 * @Function :
 */

public class UesrInfo {
    @JsonIgnoreProperties(ignoreUnknown = true)

    private String id;//用户id
    private String loginPassword;//登录密码
    private String payPassword;//支付密码
    private String mobile;//手机号
    private String name;//真实姓名
    private String sex;//性别
    private String identity;//身份证号
    private String path;//用户头像位置
    private double balance;//余额
    private int jifen;//积分
    private String pingjia;//评价
    private float pingfen;//平均评分
    private int order_count;//历史接单数
    private int credit;//信誉值
    private boolean accept_able;//是否可接单
    private boolean send_able;//是否可发单
    private double longitude;//经度
    private double latitude;//纬度
    private String address;//用户当前定位地址
    private String role;//用户角色 normal:普通用户 courier:快递员
    private String state;//用户认证状态  0:未认证, 1:一级认证 ,2:二级认证,3:认证中，-1:认证失败
    private boolean pass;//是否免担保
    private Date forbidTime;//禁止接单日期
    private String loginStatus;//离线或在线：on:在线, off:离线
    private String openId; // 微信用户openId

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public Date getForbidTime() {
        return forbidTime;
    }

    public void setForbidTime(Date forbidTime) {
        this.forbidTime = forbidTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getJifen() {
        return jifen;
    }

    public void setJifen(int jifen) {
        this.jifen = jifen;
    }

    public String getPingjia() {
        return pingjia;
    }

    public void setPingjia(String pingjia) {
        this.pingjia = pingjia;
    }

    public float getPingfen() {
        return pingfen;
    }

    public void setPingfen(float pingfen) {
        this.pingfen = pingfen;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAccept_able() {
        return accept_able;
    }

    public void setAccept_able(boolean accept_able) {
        this.accept_able = accept_able;
    }

    public boolean isSend_able() {
        return send_able;
    }

    public void setSend_able(boolean send_able) {
        this.send_able = send_able;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", payPassword='" + payPassword + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", identity='" + identity + '\'' +
                ", path='" + path + '\'' +
                ", balance=" + balance +
                ", jifen=" + jifen +
                ", pingjia='" + pingjia + '\'' +
                ", pingfen=" + pingfen +
                ", order_count=" + order_count +
                ", credit=" + credit +
                ", accept_able=" + accept_able +
                ", send_able=" + send_able +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                ", pass=" + pass +
                ", forbidTime=" + forbidTime +
                ", loginStatus='" + loginStatus + '\'' +
                '}';
    }
}

