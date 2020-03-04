package com.qxf.pojo;

import java.util.Date;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/4
 * @Description: com.qxf.pojo
 */
public class Card {
    private String id;
    private String cardNum;
    private Date cardTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getCardTime() {
        return cardTime;
    }

    public void setCardTime(Date cardTime) {
        this.cardTime = cardTime;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", cardTime=" + cardTime +
                '}';
    }
}
