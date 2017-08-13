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

import static java.lang.System.out;

/**
 * Created by wangh on 2017/8/13.
 */
@Controller
@RequestMapping("/image")
public class ImageController extends AbstractController {

    @RequestMapping(value = "/toFile")
    public String toFile(){
        return "fileUpload";
    }


    @RequestMapping(value = "/image", method = RequestMethod.POST)
   public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request, ModelMap model) {

        //获得原始文件名
        String filename = file.getOriginalFilename();
        System.out.println("原始文件名："+ filename);

        String newFileName = UUID.randomUUID()+filename;

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
            }
        }
        System.out.println("上传图片到：" + path + newFileName);
        model.addAttribute("fileUrl", path + newFileName);
        return "fileUpload";

    }
}