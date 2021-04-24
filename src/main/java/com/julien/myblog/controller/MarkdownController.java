package com.julien.myblog.controller;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.julien.myblog.anotation.UserLoginToken;
import com.julien.myblog.bean.Markdown;
import com.julien.myblog.dao.MarkdownDao;
import com.julien.myblog.service.MarkdownService;
import com.julien.myblog.service.servimpl.MarkdownServiceImpl;
import com.julien.myblog.utils.TokenUtil;
import io.swagger.models.auth.In;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @function: Markdown
 * @author: 863978160@qq.com
 * @create: 2021-01-21 16:08
 **/


@Controller
public class MarkdownController {

    private MarkdownService markdownService;
    private MarkdownDao markdownDao;

    @Autowired
    public void setMarkdownDao(MarkdownDao markdownDao) {
        this.markdownDao = markdownDao;
    }

    @Autowired
    public void setMarkdownService(MarkdownServiceImpl markdownService) {
        this.markdownService = markdownService;
    }

    @RequestMapping("/upload")
    public void imageUpload( @RequestParam(value = "editormd-image-file",required = false) MultipartFile file,HttpServletResponse response
    ) throws IOException {

        // 项目根目录新建一个upload文件夹
        String rootPath = System.getProperty("user.dir")+"/upload/";
        String fileName =  file.getOriginalFilename();
        File newFile = new File(rootPath);
        if (!newFile.exists()){
            if (newFile.mkdirs()){
                LoggerFactory.getLogger(getClass()).info("根目录upload文件夹初始化成功..... ");
            }
        }

        File dest = new File(rootPath,fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"../api/" + fileName + "\"}" );
    }

    @ResponseBody
    @UserLoginToken
    @PostMapping("/saving")
    public Integer hello(@RequestParam(required = true) Integer id,
                    @RequestParam(required = true) String title,
                    @RequestHeader("Authorization") String token,
                    @RequestParam(required = true) String content){
        Integer UserId   = (Integer) Integer.parseInt(JWT.decode(token).getAudience().get(0));
        Markdown md = new Markdown(id,UserId,title,"null","../api/he.png","null",0,content);
        if (id==0){
            if (markdownDao.addMarkdown(md)==1){
                return markdownDao.selectLastId();
            }
            return id;
        }else {
            if (markdownDao.getMarkdownById(id)==null){
                System.out.println("非法注入");
                return id;
            }else {
                markdownDao.editMarkdownbyId(md);
                return id;
            }
        }
    }

    /**
     * 通过id读取
     * @return text
     */
    @ResponseBody
    @GetMapping("/md/{id}")
    public Markdown getMarkdownById(
            @PathVariable(value = "id",required = true) Integer id){
        return markdownService.getMarkdownById(id);
    }


    @ResponseBody
    @GetMapping("/rmd/{id}")
    public JSONObject deleteMarkdownById(@PathVariable(value = "id",required = true) Integer id){
        JSONObject json= new JSONObject();
        if (markdownService.deleteMarkdownById(id)==1){
            json.put("code","1");
        }else {
            json.put("code", 0);
        }
        return json;
    }

    @ResponseBody
    @GetMapping("/markdownlist")
    public List<Markdown> getAllMarkdown(){
        return markdownService.getMarkdownList();
    }
}
