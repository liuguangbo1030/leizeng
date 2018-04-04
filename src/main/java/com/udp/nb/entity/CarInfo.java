package com.udp.nb.entity;

/**
 * @author cloudy
 * @version 1.0
 * 车牌信息
 * @date 18/1/22 下午2:42
 */
public class CarInfo {
    private Integer id;
    private Integer uin;
    private String carNumber;
    private Integer state;
    private Integer createTime;
    private Integer isAuth;
    private Integer isComuse;
    private String picUrl1;
    private String picUrl2;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUin() {
        return uin;
    }

    public void setUin(Integer uin) {
        this.uin = uin;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public Integer getIsComuse() {
        return isComuse;
    }

    public void setIsComuse(Integer isComuse) {
        this.isComuse = isComuse;
    }

    public String getPicUrl1() {
        return picUrl1;
    }

    public void setPicUrl1(String picUrl1) {
        this.picUrl1 = picUrl1;
    }

    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CarInfo [id=" + id
                + ",uin=" + uin
                + ",carNumber=" + carNumber
                + ",state=" + state
                + ",createTime=" + createTime
                + ",isAuth=" + isAuth
                + ",isComuse=" + isComuse
                + ",picUrl1=" + picUrl1
                + ",picUrl2=" + picUrl2
                + ",remark=" + remark
                + "]";
    }
}
