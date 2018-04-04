package com.udp.nb.client;

import com.udp.nb.config.GhtProperties;
import com.udp.nb.util.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @date 18/3/24 下午3:44
 */
@Component
public class GhtClient {

    private Logger logger = LoggerFactory.getLogger(GhtClient.class);

    @Autowired
    private GhtProperties ghtProperties;

    /**
     * 设备第一次连接请求云平台
     * @param deviceId
     * @return
     */
    public String doDeviceRequest(String deviceId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("equipmentId", deviceId);
        HttpRequestUtil.doGet(ghtProperties.getDeviceidurl(), map);
        return null;
    }
}
