package com.udp.nb.vo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;

/**
 * @version 1.0
 * @date 18/3/15 下午1:57
 */
public class NbClientVo {
    private ChannelHandlerContext ctx;
    private DatagramPacket packet;

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public DatagramPacket getPacket() {
        return packet;
    }

    public void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }
}
