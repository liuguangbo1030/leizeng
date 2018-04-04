package com.udp.nb.service.helper;

import com.udp.nb.mapper.CarInfoMapper;
import com.udp.nb.mapper.ComPassMapper;
import com.udp.nb.mapper.ComWorksiteMapper;
import com.udp.nb.mapper.OrderMapper;
import com.udp.nb.entity.CarInfo;
import com.udp.nb.entity.ComPass;
import com.udp.nb.entity.ComWorksite;
import com.udp.nb.entity.Order;
import com.udp.nb.util.CommonUtil;
import com.udp.nb.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cloudy
 * @version 1.0
 * @date 18/1/23 下午9:03
 */
@Component
public class OrderServiceHelper {
    @Autowired
    private CarInfoMapper carInfoMapper;

    @Autowired
    private ComPassMapper comPassMapper;

    @Autowired
    private ComWorksiteMapper comWorksiteMapper;

    @Autowired
    private OrderMapper orderMapper;

    private static Logger logger = LoggerFactory.getLogger(OrderServiceHelper.class);

    /**
     * 查询设备信息
     * @param deviceId 设备id
     * @return
     */
    public ComPass getComPass(Integer deviceId) {
        if(null == deviceId || 0 >= deviceId)
            return null;
        ComPass comPass = comPassMapper.findComPass(deviceId);
        logger.info("查询设备信息的设备id：{},设备信息：{}", deviceId, comPass);
        return comPass;
    }

    /**
     * 查询工作站信息
     * @param worksiteId 工作站id
     * @return
     */
    public ComWorksite getComWorksite(Integer worksiteId) {
        if(null == worksiteId || 0 >= worksiteId)
            return null;
        ComWorksite comWorksite = comWorksiteMapper.findComWorksite(worksiteId);
        logger.info("查询工作站信息的工作站id：{},工作站信息：{}", worksiteId, comWorksite);
        return comWorksite;
    }

    /**
     * 车牌信息
     * @param carNumber
     * @return
     */
    public CarInfo getCarInfo(String carNumber) {
        if(CommonUtil.isStrEmpty(carNumber))
            return null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("car_number", carNumber);
        CarInfo carInfo = carInfoMapper.findCarInfo(map);
        logger.info("查询车牌信息的车牌号：{},车牌信息：{}", carNumber, carInfo);
        return carInfo;
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    public Integer addOrder(Order order) {
        if(null == order)
            return null;
        logger.info("添加的订单信息：{}", order.toString());
        orderMapper.addOrder(order);
        return order.getId();
    }

    /**
     * 查询订单
     * @param filter
     * @return
     */
    public Order findOrder(Map<String, Object> filter) {
        if(null == filter)
            return null;
        Order order = orderMapper.findOrder(filter);
        logger.info("查询订单信息的条件：{},订单信息：{}", filter, order);
        return order;
    }

    /**
     * 修改订单
     * @param order
     * @return
     */
    public Integer updateOrder(Order order) {
        if(null == order)
            return null;
        Integer flag = orderMapper.updateOrder(order);
        logger.info("修改订单信息的订单信息：{}，订单修改状态：{}", order, flag);
        return flag;
    }

    /**
     * 获取时间的16进制
     * @return
     */
    public static String getHex16Time() {
        String currentTime = DateUtils.getCurrentTimeStr();
        String year = currentTime.substring(2,4);
        String month = currentTime.substring(5,7);
        String day = currentTime.substring(8,10);
        String hour = currentTime.substring(11,13);
        String minute = currentTime.substring(14,16);
        String second = currentTime.substring(17,19);
        String timeHex = String.format("%02x", Integer.valueOf(year)) + String.format("%02x", Integer.valueOf(month))
                + String.format("%02x", Integer.valueOf(day)) + String.format("%02x", Integer.valueOf(hour))
                + String.format("%02x", Integer.valueOf(minute)) + String.format("%02x", Integer.valueOf(second));
        return timeHex;
    }

    private static String[] carNumberChinese = new String[]{
        "京","津","冀","晋","蒙","辽","吉","黑","沪","苏","浙",
        "皖","闽","赣","鲁","豫","鄂","湘","粤","桂","琼","渝",
        "川","贵","云","藏","陕","甘","青","宁","新","港","澳",
        "台","警","使","WJ","领","学"
    };

    private static String[] carNumberLetter = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    /**
     * 获取车牌号
     * @param carNumber
     * @return
     */
    public static String getCarnumber(String carNumber) {
        Integer first = Integer.parseInt(carNumber.substring(0, 2), 16);
        Integer second = Integer.parseInt(carNumber.substring(2, 4), 16);
        Integer third = Integer.parseInt(carNumber.substring(4, 6), 16);
        Integer fourth = Integer.parseInt(carNumber.substring(6, 8), 16);
        Integer fifth = Integer.parseInt(carNumber.substring(8, 10),16);
        Integer sixth = Integer.parseInt(carNumber.substring(10, 12), 16);
        Integer seventh = Integer.parseInt(carNumber.substring(12, 14), 16);
        Integer eighth = Integer.parseInt(carNumber.substring(14, 16), 16);
        Integer ninth = Integer.parseInt(carNumber.substring(16, 18),16);
        Integer tenth = Integer.parseInt(carNumber.substring(18, 20), 16);
        StringBuffer sb = new StringBuffer();
        sb.append(carNumberChinese[first]);
        sb.append(getCarLetter(second));
        sb.append(getCarLetter(third));
        sb.append(getCarLetter(fourth));
        sb.append(getCarLetter(fifth));
        sb.append(getCarLetter(sixth));
        sb.append(getCarLetter(seventh));
        sb.append(getCarLetter(eighth));
        sb.append(getCarLetter(ninth));
        sb.append(getCarLetter(tenth));
        return sb.toString();
    }

    /**
     * 获取车牌字母
     * @param letter
     * @return
     */
    public static String getCarLetter(Integer letter) {
        if(letter <= 57 && letter >= 48) {//表是是数字，因为传的是数字的asc码，从0开始
            letter = letter - 48;
            return letter.toString();
        }
        letter = letter - 65;
        if(letter <= 25 && letter >= 0) {//表是是字母，因为传的是字母的asc码
            return carNumberLetter[letter];
        }
        return "";
    }

    /**
     * 获取设备id
     * @param deviceid
     * @return
     */
    public static Integer getDeviceId(String deviceid) {
        if(deviceid != null) {
            return Integer.parseInt(deviceid, 16);
        }
        return null;
    }

    /**
     * 获取时间
     * @param time
     * @return
     */
    public static Integer getTime(String time) {
        Integer year = Integer.parseInt(time.substring(10,12), 16);
        Integer month = Integer.parseInt(time.substring(8,10), 16);
        Integer day = Integer.parseInt(time.substring(6,8), 16);
        Integer hour = Integer.parseInt(time.substring(4,6),16);
        Integer minute = Integer.parseInt(time.substring(2,4),16);
        Integer second = Integer.parseInt(time.substring(0,2), 16);
        StringBuffer sb = new StringBuffer();
        sb.append("20");
        sb.append(year);
        sb.append("-");
        sb.append(month);
        sb.append("-");
        sb.append(day);
        sb.append(" ");
        sb.append(hour);
        sb.append(":");
        sb.append(minute);
        sb.append(":");
        sb.append(second);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(sb.toString());
            long ts = date.getTime();
            String res = String.valueOf(ts).substring(0,10);
            return Integer.valueOf(res);
        } catch (Exception ex) {
            logger.error("获取上报时间异常", ex);
        }
        return null;
    }

    /**
     * 车辆入场
     * @param carNumber
     * @param deviceId
     * @param createTime
     * @return
     */
    public boolean carInput(String carNumber, Integer deviceId, Integer createTime) {
        ComPass comPass = getComPass(deviceId);
        if(comPass == null)
            return false;
        ComWorksite comWorksite = getComWorksite(comPass.getWorksiteId());
        if(comWorksite == null)
            return false;
        Order order = new Order();
        order.setComid(comWorksite.getComid());
        order.setCarNumber(carNumber);
        order.setCreateTime(createTime);
        order.setState(0);
        Integer orderId = addOrder(order);
        return false;
    }

    /**
     * 车辆出场
     * @param carNumber
     * @param deviceId
     * @param endime
     * @return
     */
    public boolean carOutput(String carNumber,  Integer deviceId, Integer endime) {
        ComPass comPass = getComPass(deviceId);
        if(comPass == null)
            return false;
        ComWorksite comWorksite = getComWorksite(comPass.getWorksiteId());
        if(comWorksite == null)
            return false;
        Map<String, Object> filter = new HashMap<String, Object>();
        filter.put("comid", comWorksite.getComid());
        filter.put("car_number", carNumber);
        filter.put("state", 0);
        Order order = findOrder(filter);
        if(order != null) {
            order.setEndTime(endime);
            updateOrder(order);
        }
        return false;
    }
}
