package com.udp.nb.handler;

import com.udp.nb.client.GhtClient;
import com.udp.nb.service.NettyService;
import com.udp.nb.service.helper.OrderServiceHelper;
import com.udp.nb.util.CRC16Util;
import com.udp.nb.util.ExecutorsUtil;
import com.udp.nb.util.NBUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cloudy
 * @version 1.0
 * @date 18/2/3 下午5:07
 */
@Component
public class OrderHandler {

    private Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    @Autowired
    private OrderServiceHelper orderServiceHelper;

    @Autowired
    private GhtClient ghtClient;

    /**
     * 处理接收到的udp数据
     * @param body
     * @return
     */
    public void handlerUdp(final String body, final ChannelHandlerContext ctx, final DatagramPacket packet, final String ip, final String port) {
        ExecutorsUtil.getExecutor().execute(new Runnable() {
            @Override
            public void run() {
            try {
                if (body.indexOf("aa55") >= 0 && body.indexOf("af") > 0) {
                    int length = body.length();
                    String str = body.substring(6, length - 6);
                    logger.info("请求数据信息：{}", str);
                    if (CRC16Util.crc16(str).equals(body.substring(length - 6, length - 2))) {
                        String type = body.substring(8, 10);
                        logger.info("请求类型信息：{}", type);
                        if (type.equals("fe")) {//请求心跳
                            logger.info("body信息：{}", body);
                            String data = body.substring(14, length - 6);
                            Integer deviceId = orderServiceHelper.getDeviceId(data.substring(0, 8));
                            if(!NettyService.userSocketMap.containsKey(deviceId.toString())) {//判断设备id的key是否存在
                                NettyService.userSocketMap.put(deviceId.toString(), ip);
                                //请求云平台修改设备ip
                                ghtClient.doDeviceRequest(deviceId.toString());
                            }
                            NettyService.nbClientMap.put(deviceId.toString(), NBUtil.putNbClient(ctx, packet));
                            if (body.substring(6, 8).equals("80")) {//要求回复
                                String msg1 = NBUtil.getBackMessage("00", "40", "FE", "0000", "");
                                NBUtil.doSendMessage(msg1, ctx, packet, false, ip, port);
                                Thread.sleep(50);
                                String msg2 = NBUtil.getBackMessage("00", "80", "d4", "0006", orderServiceHelper.getHex16Time());
                                NBUtil.doSendMessage(msg2.toUpperCase(), ctx, packet, true, ip, port);
                            }
                        } else if (type.equals("01")) {//上传实时车辆信息
                            String data = body.substring(14, length - 6);
                            String carNumber = orderServiceHelper.getCarnumber(data.substring(10, 30));
                            Integer deviceId = orderServiceHelper.getDeviceId(data.substring(0, 8));
                            Integer time = orderServiceHelper.getTime(data.substring(30, 42));
                            NettyService.nbClientMap.put(deviceId.toString(), NBUtil.putNbClient(ctx, packet));
                            if (data.substring(8, 10).equals("00")) {//进入
                                orderServiceHelper.carInput(carNumber, deviceId, time);
                            } else if (data.substring(8, 10).equals("01")) {//离开
                                orderServiceHelper.carOutput(carNumber, deviceId, time);
                            }
                            if (body.substring(6, 8).equals("80")) {//要求回复
                                String msg = NBUtil.getBackMessage("01", "40", "01", "0000", "");
                                NBUtil.doSendMessage(msg, ctx, packet, false, ip, port);
                            }
                        } else if(type.equals("0B")) {//设置系统参数

                        } else if(type.equals("D4")) {//下传系统时间

                        } else if(type.equals("D8")) {//白名单车牌下载

                        } else if(type.equals("D9")) {//黑名单车牌下载

                        }
                    } else {
                        logger.info("crc16编码不正确！");
                    }
                }
            } catch (Exception ex) {
                logger.error("订单处理异常:"+ex.getMessage());
            }
            }
        });
    }
}
