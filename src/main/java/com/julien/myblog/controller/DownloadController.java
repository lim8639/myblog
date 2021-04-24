package com.julien.myblog.controller;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @function: download
 * @author: 863978160@qq.com
 * @create: 2021-02-23 21:15
 **/

@Controller
public class DownloadController {
    @RequestMapping("/download")
    public void DownloadFile(HttpServletResponse response) throws IOException {
        File file  = new File("C:\\Users\\julien\\Downloads\\Video\\大秦赋.mkv");
        InputStream inputStream = new FileInputStream(file);
//        OutputStream outputStream  = response.getOutputStream();
        OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\julien\\Downloads\\Video\\小秦赋.mkv"));
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("正在下载文件");
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename="+"大秦赋.mkv");
        //读取目标文件，通过response将目标文件写到客户端
        //获取目标文件的绝对路径
        int len;
        byte[] buffer = new byte[1024];
        while((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
    }
}
