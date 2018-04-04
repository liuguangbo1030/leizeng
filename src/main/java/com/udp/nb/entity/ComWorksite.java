package com.udp.nb.entity;

/**
 * @author cloudy
 * @version 1.0
 * 岗亭表
 * @date 18/1/22 下午2:40
 */
public class ComWorksite {
    private Integer id;
    private Integer comid;
    private String worksiteName;
    private String description;
    private Integer netType;
    private String hostName;
    private String hostMemory;
    private String hostInternal;
    private Integer uploadTime;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getWorksiteName() {
        return worksiteName;
    }

    public void setWorksiteName(String worksiteName) {
        this.worksiteName = worksiteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostMemory() {
        return hostMemory;
    }

    public void setHostMemory(String hostMemory) {
        this.hostMemory = hostMemory;
    }

    public String getHostInternal() {
        return hostInternal;
    }

    public void setHostInternal(String hostInternal) {
        this.hostInternal = hostInternal;
    }

    public Integer getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Integer uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ComWorksite [id=" + id
                + ",comid=" + comid
                + ",worksiteName=" + worksiteName
                + ",description=" + description
                + ",netType=" + netType
                + ",hostName=" + hostName
                + ",hostMemory=" + hostMemory
                + ",hostInternal=" + hostInternal
                + ",uploadTime=" + uploadTime
                + ",state=" + state
                + "]";
    }
}
