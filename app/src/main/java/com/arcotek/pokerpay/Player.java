package com.arcotek.pokerpay;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * Created by miao.raymond on 7/22/2015.
 */
public class Player implements Parcelable {
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

    @Override
    public String toString() {
        return name +"     $"+ money;
    }

    protected Player(Parcel in) {
        name = in.readString();
        number = in.readString();
        money = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(number);
        dest.writeValue(money);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}