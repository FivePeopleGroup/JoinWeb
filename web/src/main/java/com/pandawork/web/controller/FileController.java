package com.pandawork.web.controller;

import com.pandawork.web.spring.AbstractController;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.pandawork.common.entity.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static java.lang.System.out;

/**
 * Created by 陈芳 on 2017/8/13.
 */
@Controller
@RequestMapping("/file")
public class FileController extends AbstractController {

    /**
     * 跳到上传页面
     * @return
     */
    @RequestMapping(value = "/toFile")
    public String toFile(){
        return "fileUpload";
    }


    /**
     * 对上传页面进行处理，并将上传内容放到数据库中
     * @param file
     * @param request
     * @param model
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
   public String upload( @RequestParam("file")CommonsMultipartFile file, HttpServletRequest request, ModelMap model, RedirectAttributes redirectAttributes) throws Exception {

        //获得原始文件名
        String filename = file.getOriginalFilename();
        System.out.println("原始文件名："+ filename);

        String newFileName =  UUID.randomUUID()+ filename;
//       UUID.randomUUID()局唯一标识符,是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，
        ServletContext sc = request.getSession().getServletContext();
        String path = sc.getRealPath("img")+"/";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        if (!file.isEmpty()){
            try{
                FileOutputStream fos = new FileOutputStream(path+newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while((b = in.read())!=-1){
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("msg","上传成功！");
        com.pandawork.common.entity.File file1 = new com.pandawork.common.entity.File();
        String name = "../../img/"+newFileName;
        file1.setName(name);
        file1.setVisible(0);
        fileService.addImage(file1);
        return "fileUpload";
    }

    /**
     * 列出全部
     * @param model
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public String listAll(Model model ,RedirectAttributes redirectAttributes) throws Exception {
    List<com.pandawork.common.entity.File> fileList = fileService.listAll();
    model.addAttribute("fileList",fileList);

    return  "fileList";
}

}