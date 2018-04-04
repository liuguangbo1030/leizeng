package com.udp.nb.handler;

import com.udp.nb.service.NettyService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cloudy
 * @version 1.0
 * UDP接收数据处理类
 * @date 18/1/21 下午7:41
 */
@Component
public class NBServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static Logger logger = LoggerFactory.getLogger(NBServerHandler.class);

    @Autowired
    private OrderHandler orderHandler;

    @Override
    public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        // 读取收到的数据
        String ip = packet.sender().getHostString();
        String port = String.valueOf(packet.sender().getPort());
        String key = ip+":"+port;
        NettyService.userSocketMap.put(key, "1");
        System.out.println("setmap"+NettyService.userSocketMap);
        ByteBuf buf = (ByteBuf) packet.copy().content();
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < req.length; i++) {
            int v = req[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        String body = stringBuilder.toString();
        logger.info("接收到客户端的16进制请求数据:{}", body);
        //处理udp请求
        orderHandler.handlerUdp(body.toLowerCase(), ctx, packet, ip, port);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();//刷新后才将数据发出到SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
