package com.udp.nb.mapper;

import com.udp.nb.entity.ComWorksite;
import org.apache.ibatis.annotations.Param;

/**
 * @author cloudy
 * @version 1.0
 * 岗亭表
 * @date 18/1/22 下午4:11
 */
public interface ComWorksiteMapper {
    ComWorksite findComWorksite(@Param("id") Integer id);
}
