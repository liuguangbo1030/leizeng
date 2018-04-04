package com.udp.nb.mapper;

import com.udp.nb.entity.ComPass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author cloudy
 * @version 1.0
 * 设备信息
 * @date 18/1/22 下午2:45
 */
@Mapper
public interface ComPassMapper {
    ComPass findComPass(@Param("id") Integer id);
}
