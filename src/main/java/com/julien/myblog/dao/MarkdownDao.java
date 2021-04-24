package com.julien.myblog.dao;

import com.julien.myblog.bean.Markdown;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author julien
 * @date 2021-01-22 12:40
 * @function: dao
 */
@Component
@Mapper
public interface MarkdownDao {

    /**
     * 添加markdown博客文章
     * @param markdown
     * @return
     */
   @Insert("INSERT INTO t_markdown(userId, title, fristTime, cover, authority, content)\n" +
          " values (#{userId},#{title},now(),#{cover},#{authority},#{content});")
   public int addMarkdown(Markdown markdown);

    /**
     * 根据id查找文章
     * @param id
     * @return
     */
   @Select("select * from t_markdown where  id  = #{id};")
   public Markdown getMarkdownById(Integer id);


    /**
     * 获取最新的id
     * @return
     */
   @Select("SELECT MAX(id) from t_markdown;")
   public Integer selectLastId();

    /**
     * 查找所有的文章信息
     * @return
     */
  @Select("select * from t_markdown;")
    public List<Markdown> getMarkdownList();

    /**
     *
     * @param markdown
     * @return
     */
  @Update("UPDATE t_markdown set title = #{title},cover=#{cover},updateTime=NOW(),authority=0,content=#{content} where id = #{id};")
    public int editMarkdownbyId(Markdown markdown);

    /**
     *
     * @param id
     * @return
     */
  @Delete("delete from t_markdown where id = #{id}")
    public  int deleteMarkdownById(Integer id);
}
