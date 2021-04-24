package com.julien.myblog.service.servimpl;

import com.julien.myblog.bean.Markdown;
import com.julien.myblog.dao.MarkdownDao;
import com.julien.myblog.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @function: impl
 * @author: 863978160@qq.com
 * @create: 2021-01-25 16:31
 **/

@Service
public class MarkdownServiceImpl  implements MarkdownService {

    private MarkdownDao markdownDao;

    @Autowired
    public void setMarkdownDao(MarkdownDao markdownDao) {
        this.markdownDao = markdownDao;
    }

    /**
     *  添加或者修改markdown文本，传入markdown对象
     * @param markdown
     * @return 0保存失败。1保存成功
     */
    @Override
    public int addMarkdown(Markdown markdown) {
        if (markdown.getId()==null){
            return  markdownDao.addMarkdown(markdown);
        }else{
            return editorMarkdown(markdown);
        }
    }

    @Override
    public int editorMarkdown(Markdown markdown) {
         return 1;
    }

    @Override
    public int deleteMarkdownById(Integer id) {
        return markdownDao.deleteMarkdownById(id);
    }


    @Override
    public Markdown getMarkdownById(Integer id) {
        return markdownDao.getMarkdownById(id);
    }

    @Override
    public List<Markdown> getMarkdownList() {
        return markdownDao.getMarkdownList();
    }
}
