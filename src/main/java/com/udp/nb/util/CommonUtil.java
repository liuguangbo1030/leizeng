package com.udp.nb.util;

import java.util.List;

/**
 * commonutil类
 * @author zhouxing
 * @version 1.0
 * @date 2016年9月5日
 */
public class CommonUtil {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isStrEmpty(String str) {
        if (null != str && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 判断集合是否为空
     *
     * @param list
     * @return
     */
    public static boolean isListEmpty(List list) {

        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean stringIsExists(String subject, String search) {
        if(isStrEmpty(subject) || isStrEmpty(search)) {
            return false;
        }
        if(subject.indexOf(search) != -1) {
            return true;
        }
        return false;
    }
}
