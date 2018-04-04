package com.udp.nb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @date 18/3/24 下午5:46
 */
@Component
@ConfigurationProperties(prefix = "ght")
public class GhtProperties {
    private String deviceidurl;

    public String getDeviceidurl() {
        return deviceidurl;
    }

    public void setDeviceidurl(String deviceidurl) {
        this.deviceidurl = deviceidurl;
    }
}
