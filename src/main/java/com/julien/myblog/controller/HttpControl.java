package com.julien.myblog.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * @function: control
 * @author: 863978160@qq.com
 * @create: 2021-02-04 11:12
 **/


@RestController
public class HttpControl {


    RestTemplate   restTemplate ;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @RequestMapping("/picUrl/{id}")
    public String getPicUrl(@PathVariable String id){
        String url = "https://service-n145ju68-1258218517.hk.apigw.tencentcs.com/release/hello/";
        String picUrl = Objects.requireNonNull(restTemplate.getForObject(url, JSONObject.class)).getJSONObject("album").getString("picUrl");
     //        获取对象
     //      的某个数值
        return  picUrl;
    }


    @RequestMapping("/getget")
    public String getget(){
        String url = "http://www.yeqiuyan.top/select/main.php";
        String picUrl = Objects.requireNonNull(restTemplate.getForObject(url, JSONObject.class)).getJSONObject("album").getString("picUrl");

        for(int i =0;i<100;i++){
           picUrl = restTemplate.getForObject(url,JSONObject.class).toString();
        }
        //        获取对象
        //      的某个数值
        return "hello world";
    }

    @RequestMapping("/hey")
    public String sendGetRequest() throws IOException {
        String url = "https://service-n145ju68-1258218517.hk.apigw.tencentcs.com/release/hello/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //默认值我GET
        con.setRequestMethod("POST");
        String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36 Edg/88.0.705.56";
        //添加请求头
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return  response.toString();
    }
}
