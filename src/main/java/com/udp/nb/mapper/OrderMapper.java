package com.udp.nb.mapper;

import com.udp.nb.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author cloudy
 * @version 1.0
 * 订单信息
 * @date 18/1/22 上午11:34
 */
@Mapper
public interface OrderMapper {
    void addOrder(Order order);
    int updateOrder(Order order);
    Order findOrder(Map<String, Object> filter);
}
