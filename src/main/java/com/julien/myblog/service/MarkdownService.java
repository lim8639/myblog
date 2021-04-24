package com.julien.myblog.service;

import com.julien.myblog.bean.Markdown;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author julien
 * @date 2021-01-25 16:28
 * @function: Service
 */

@Service
public interface MarkdownService {
    /**
     *
     * @param markdown
     * @return
     */
    public int addMarkdown(Markdown markdown);

    public int editorMarkdown(Markdown markdown);

    public int deleteMarkdownById(Integer id);

    public Markdown getMarkdownById(Integer id);

    public List<Markdown> getMarkdownList();
}
