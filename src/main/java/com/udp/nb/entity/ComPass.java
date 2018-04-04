package com.udp.nb.entity;

/**
 * @author cloudy
 * @version 1.0
 * 设备表
 * @date 18/1/22 下午2:41
 */
public class ComPass {
    private Integer id;
    private Integer worksiteId;
    private String passname;
    private Integer passtype;
    private String description;
    private Integer comid;
    private Integer state;
    private Integer monthSet;
    private Integer month2Set;
    private String channelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorksiteId() {
        return worksiteId;
    }

    public void setWorksiteId(Integer worksiteId) {
        this.worksiteId = worksiteId;
    }

    public String getPassname() {
        return passname;
    }

    public void setPassname(String passname) {
        this.passname = passname;
    }

    public Integer getPasstype() {
        return passtype;
    }

    public void setPasstype(Integer passtype) {
        this.passtype = passtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getMonthSet() {
        return monthSet;
    }

    public void setMonthSet(Integer monthSet) {
        this.monthSet = monthSet;
    }

    public Integer getMonth2Set() {
        return month2Set;
    }

    public void setMonth2Set(Integer month2Set) {
        this.month2Set = month2Set;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ComPass [id=" + id
                + ",worksiteId=" + worksiteId
                + ",passname=" + passname
                + ",passtype=" + passtype
                + ",description=" + description
                + ",comid=" + comid
                + ",state=" + state
                + ",monthSet=" + monthSet
                + ",month2Set=" + month2Set
                + ",channelId=" + channelId
                + "]";
    }
}
