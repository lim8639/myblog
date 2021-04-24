package com.julien.myblog.controller;

import com.julien.myblog.utils.IpUtil;
import com.julien.myblog.utils.iputil.IPSeeker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @function: con
 * @author: 863978160@qq.com
 * @create: 2021-01-20 23:02
 **/

@RestController
public class NewNode {


    @Autowired
    IPSeeker ipSeeker;

    @RequestMapping("/v5")
    public String getNode(HttpServletRequest httpServletRequest){
        String ip = IpUtil.getIpAddr(httpServletRequest);

       return ipSeeker.getArea(ip)+ipSeeker.getCountry(ip);


    }
}
