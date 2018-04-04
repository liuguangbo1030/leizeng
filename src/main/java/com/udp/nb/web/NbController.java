package com.udp.nb.web;

import com.alibaba.fastjson.JSON;
import com.udp.nb.client.NbClient;
import com.udp.nb.service.NettyService;
import com.udp.nb.vo.NbClientVo;
import com.udp.nb.vo.NbWhiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @date 18/3/14 下午5:52
 */
@RestController
@RequestMapping("/nb")
public class NbController {

    @Autowired
    private NbClient nbClient;


    @RequestMapping(value = "/nbWhite", method = RequestMethod.POST)
    public String nbWhite(HttpServletRequest req) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("flag", "true");
        map.put("msg", "操作成功！");
        try {
            String deviceId = req.getParameter("deviceId");//设备id
            String type = req.getParameter("type");//操作类型(1:添加，2：修改，3：删除，4：下载)
            String data = req.getParameter("data");//车牌及时间数据
            List<NbWhiteVo> nbWhiteVoList = JSON.parseArray(data, NbWhiteVo.class);
            for (NbWhiteVo nbWhiteVo : nbWhiteVoList) {
                System.out.println(nbWhiteVo.getCarnumber());
            }
            NbClientVo nbClientMap = NettyService.nbClientMap.get(deviceId);
            if (nbClientMap == null) {
                map.put("flag", "false");
                map.put("msg", "设备不存在！");
            } else {
                String serial = "";//序号
                String businessType = "";//业务类型
                String orderType = "";//命令类型
                nbClient.sendPackage(nbClientMap.getCtx(), nbClientMap.getPacket(), "AA550040D400008E0DAF");
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return JSON.toJSONString(map);
    }
}
