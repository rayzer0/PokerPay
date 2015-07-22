package com.arcotek.pokerpay;

/**
 * Created by miao.raymond on 7/22/2015.
 */
public class Player {
    public String name;
    public String number;
    public String money;

    public Player(String name, String number, String money) {
        this.name = name;
        this.number = number;
        this.money = money;
    }
    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
