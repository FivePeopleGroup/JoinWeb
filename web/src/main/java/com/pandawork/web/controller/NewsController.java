package com.pandawork.web.controller;

import com.pandawork.common.entity.News;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by 侯淑婷 on 2017/8/11.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends AbstractController{

    /**
     * 添加前的操作
     * @param request
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/to_add/{userId}",method = RequestMethod.GET)
    public String toAddNews(HttpServletRequest request,Model model,@PathVariable("userId") int id){
        String message = request.getParameter("message");
        model.addAttribute("message",message);
        model.addAttribute("userId",id);
        return "add_news";
    }

    /**
     * 添加操作
     * @param news news
     * @return 返回
     */
    @RequestMapping(value = "/add/{userId}",method = RequestMethod.POST)
    public String addNews(News news,Model model,RedirectAttributes redirectAttributes,@PathVariable("userId") int userId){
        try{
            if(news.getTitle().equals("")||news.getContent().equals("")){
                redirectAttributes.addAttribute("message","输入的标题或内容不能为空，请重新填写！");
                return "redirect:/news/to_add/" + userId ;
            }
            else{
                newsService.addNews(news);
                return "redirect:/user/qq/" + userId;
            }
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
    @RequestMapping(value = "/delete/{newsId}/{userId}",method = RequestMethod.GET)
    public String deleteNews(@PathVariable("newsId")int newsId,@PathVariable("userId") int id){
        try{
            newsService.deleteNews(newsId);
            return "redirect:/user/qq/" + id;
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
    @RequestMapping(value = "/to_edit/{newsId}/{userId}",method = RequestMethod.GET)
    public String editNews(@PathVariable("newsId") int id, Model model, HttpServletRequest request,@PathVariable("userId") int userId){
        try{
            String message = request.getParameter("message");
            News news = new News();
            news = newsService.queryById(id);
            model.addAttribute("news",news);
            model.addAttribute("userId",userId);
            model.addAttribute("message",message);
            return "edit_news";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }



    /**editTwo
     * 修改新闻操作
     * @param news news
     * @param id id
     * @param model model
     * @return 返回
     */
    @RequestMapping(value = "/edit/{newsId}/{userId}",method = RequestMethod.POST)
    public String updateNews(News news, @PathVariable("newsId")int id, Model model, RedirectAttributes redirectAttributes,@PathVariable("userId") int userId){
        try{
            if(news.getContent().equals("")||news.getTitle().equals("")){
                redirectAttributes.addAttribute("message","修改的标题或内容不能为空，请重新修改！");
                return "redirect:/news/to_edit/" + id + "/"+ userId;
            }//使用RedirectAttributes
            news.setId(id);
            newsService.updateNews(news);
            model.addAttribute("news",news);
            return "redirect:/user/qq/" + userId;
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
    @RequestMapping(value = "/select/{id}/{userId}",method = RequestMethod.GET)
    public String selectNews(@PathVariable("id")int id,@PathVariable("userId")int userId, Model model){
        try{
            News news = new News();
            news = newsService.queryById(id);
            model.addAttribute("news",news);
            model.addAttribute("userId",userId);
            return "select_news";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/  selectTwo/{id}/{userId}",method = RequestMethod.GET)
    public String   selectTwo(@PathVariable("id")int id,@PathVariable("userId")int userId, Model model){
        try{
            News news = new News();
            news = newsService.queryById(id);
            model.addAttribute("news",news);
            model.addAttribute("userId",userId);
            return "select_news_two";
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
    @RequestMapping(value = "/searchHome/{userId}",method = RequestMethod.POST)
    public String queryByKeyWordHome(@RequestParam String keyWord, Model model,RedirectAttributes redirectAttributes,@PathVariable("userId") int id){
        try{
            if(Assert.isNull(keyWord)){
                redirectAttributes.addAttribute("message","搜索栏无内容，请重新填写！");
                return "redirect:/news/list";
            }
            List<News> newsList = Collections.emptyList();
            newsList = newsService.queryByKeyWord(keyWord);
            if(Assert.isEmpty(newsList)){
                redirectAttributes.addAttribute("message","没有搜索到相关新闻！");
                return "redirect:/news/list";
            }
            model.addAttribute("newsList",newsList);
            model.addAttribute("userId",id);
            return "search_news";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/searchMain/{userId}",method = RequestMethod.POST)
    public String queryByKeyWordMain(@RequestParam String keyWord, Model model,RedirectAttributes redirectAttributes,@PathVariable("userId") int id){
        try{
            if(Assert.isNull(keyWord)){
                model.addAttribute("message","搜索栏无内容，请重新填写！");
                User user = userService.queryUserById(id);
                List<News> newsList = newsService.listAll();
                model.addAttribute("list",newsList);
                model.addAttribute("user",user);
                return "zhuoyin";
            }
            List<News> newsList1 = Collections.emptyList();
            newsList1 = newsService.queryByKeyWord(keyWord);
            if(Assert.isEmpty(newsList1)){
                model.addAttribute("message","没有搜索到相关新闻！");
                User user = userService.queryUserById(id);
                List<News> newsList = newsService.listAll();
                model.addAttribute("list",newsList);
                model.addAttribute("user",user);
                return "zhuoyin";
            }
            model.addAttribute("newsList",newsList1);
            model.addAttribute("UserId",id);
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
    public String newsList(Model model,HttpServletRequest request){
        try{
            String message = request.getParameter("message");
            List<News> newsList = Collections.emptyList();
            newsList = newsService.listAll();
            model.addAttribute("newsList",newsList);
            model.addAttribute("message",message);
            return "home";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/zhuoyin",method = RequestMethod.GET)
    public String testList(Model model,HttpServletRequest request){
        try{
            List<News> newsList = Collections.emptyList();
            newsList = newsService.listAll();
            model.addAttribute("newsList",newsList);
            List<com.pandawork.common.entity.File> fileList = fileService.listAll();
            model.addAttribute("fileList",fileList);
            return "zhuoyin";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

}
