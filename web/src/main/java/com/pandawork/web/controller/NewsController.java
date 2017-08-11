package com.pandawork.web.controller;

import com.pandawork.common.entity.News;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

/**
 * Created by 侯淑婷 on 2017/8/11.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends AbstractController{

    /**
     * 添加前的操作
     * @return 返回
     */
    @RequestMapping(value = "/to_add",method = RequestMethod.GET)
    public String toAddNews(){
            return "add_news";
    }

    /**
     * 添加操作
     * @param news news
     * @return 返回
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addNews(News news){
        try{
            newsService.addNews(news);
            return "redirect:/news/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 删除新闻
     * @param id id
     * @return 返回
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteNews(@PathVariable("id")int id){
        try{
            newsService.deleteNews(id);
            return "redirect:/news/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    /**
     * 跳转到修改页面
     * @param id id
     * @param model model
     * @return 返回
     */
    @RequestMapping(value = "/to_edit/{id}",method = RequestMethod.POST)
    public String editNews(@PathVariable("id") int id,Model model){
        try{
            News news = new News();
            news = newsService.queryById(id);
            model.addAttribute("news",news);
            return "edit";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 修改新闻操作
     * @param news news
     * @param id id
     * @param model model
     * @return 返回
     */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String updateNews(News news,@PathVariable("id")int id,Model model){
        try{
            news.setId(id);
            newsService.updateNews(news);
            model.addAttribute("news",news);
            return "select_news";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 浏览新闻页面
     * @param id id
     * @param model model
     * @return 返回
     */
    @RequestMapping(value = "/select/{id}",method = RequestMethod.POST)
    public String selectNews(@PathVariable("id")int id,Model model){
        try{
            News news = new News();
            news = newsService.queryById(id);
            model.addAttribute("news",news);
            return "select";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据关键字查询新闻
     * @param keyWord keyWord
     * @param model model
     * @return 返回
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String queryByKeyWord(@Param("keyWord") String keyWord, Model model){
        try{
            List<News> newsList = Collections.emptyList();
            newsList = newsService.queryByKeyWord(keyWord);
            model.addAttribute("newsList",newsList);
            return "search_news";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 新闻列表
     * @param model model
     * @return 返回
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String newsList(Model model){
        try{
            List<News> newsList = Collections.emptyList();
            newsList = newsService.listAll();
            model.addAttribute("newsList",newsList);
            return "home";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

}
