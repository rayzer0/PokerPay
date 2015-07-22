package com.arcotek.pokerpay;

import java.math.BigDecimal;

/**
 * Created by miao.raymond on 7/22/2015.
 */
public class Player {
    public String name;
    public String number;
    public BigDecimal money;

    public Player(String name, String number, BigDecimal money) {
        this.name = name;
        this.number = number;
        this.money = money;
    }
    public Player(String name, BigDecimal money) {
        this.name = name;
        this.money = money;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
