package com.udp.nb.entity;

import java.math.BigDecimal;

/**
 * @author cloudy
 * @version 1.0
 * 订单信息
 * @date 18/1/22 上午11:19
 */
public class Order {
    private Integer id;
    private Integer createTime;
    private Integer comid;
    private Integer uin;
    private BigDecimal total;
    private Integer state;
    private Integer endTime;
    private Integer autoPay;
    private Integer payType;
    private Integer uid;
    private String carNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getUin() {
        return uin;
    }

    public void setUin(Integer uin) {
        this.uin = uin;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(Integer autoPay) {
        this.autoPay = autoPay;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Order [id=" + id
                + ",createTime=" + createTime
                + ",comid=" + comid
                + ",uin=" + uin
                + ",total=" + total
                + ",state=" + state
                + ",endTime=" + endTime
                + ",autoPay=" + autoPay
                + ",statpayTypeus=" + payType
                + ",uid=" + uid
                + ",carNumber=" + carNumber
                + "]";
    }
}
