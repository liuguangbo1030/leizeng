package com.udp.nb.service;


import com.udp.nb.handler.NBServerHandler;
import com.udp.nb.vo.NbClientVo;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author cloudy
 * @version 1.0
 * Netty UDP监控类
 * @date 18/1/21 下午6:29
 */
@Service("nettyService")
public class NettyService {

    private static Logger logger = LoggerFactory.getLogger(NettyService.class);

    @Value("${server.udpport}")
    private int port;

    @Autowired
    private NBServerHandler nBServerHandler;

    //保存信息在要重发的时候判断是否接收到信息
    public static ConcurrentMap<String, String> userSocketMap = new ConcurrentHashMap<String, String>();
    //保存客户端的信息，下发信息时会用到，以设备id为key
    public static ConcurrentMap<String, NbClientVo> nbClientMap = new ConcurrentHashMap<String, NbClientVo>();

    /**
     * 启动
     */
    public void start() {
        logger.info("start udp server port:{}",port);
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(nBServerHandler);
            Channel channel = bootstrap.bind(port).sync().channel();
            channel.closeFuture().await();
            logger.info("start udp server success");
        } catch (InterruptedException e) {
            logger.error("start udp server error: {}", e.getMessage());
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
