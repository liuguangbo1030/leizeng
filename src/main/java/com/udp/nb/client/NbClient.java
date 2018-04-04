package com.udp.nb.client;


import com.udp.nb.handler.NBClientHandler;
import com.udp.nb.service.helper.OrderServiceHelper;
import com.udp.nb.util.NBUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @date 18/3/14 下午5:17
 */
@Component
public class NbClient {

    private static Logger logger = LoggerFactory.getLogger(NbClient.class);

    @Autowired
    private NBClientHandler nbClientHandler;

    @Autowired
    private OrderServiceHelper orderServiceHelper;

    /**
     * 下发信息demo
     * @param ctx
     * @param packet
     * @param msg
     */
    public void sendPackage(ChannelHandlerContext ctx, DatagramPacket packet, String msg) throws InterruptedException {
        NBUtil.writeMsg(msg,ctx, packet);
    }
}
