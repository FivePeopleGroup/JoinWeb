package com.pandawork.test;

import com.pandawork.common.entity.File;
import com.pandawork.service.FileService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */

public class ImageTest extends AbstractTestCase {
    @Autowired
    FileService fileService;

    /**
     * 增加
     * @throws Exception
     */
    @Test
    public void addImageTest() throws Exception {
    File file = new File();
    file.setName("lala");
    file.setVisible(0);
    fileService.addImage(file);
}

    /**
     * 删除
     * @throws Exception
     */
    @Test
    public void deleteTest()throws Exception{
     fileService.deleteImage(8);
}

    /**
     * 全部
     * @throws Exception
     */
    @Test
    public void listAllTest() throws Exception {
    System.out.println(fileService.listAll());
}

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
    File file = new File();
    file.setName("hhhh");
    file.setVisible(1);
    file.setId(7);
    fileService.updateImage(file);
}

    /**
     * 查找
     * @throws Exception
     */
    @Test
    public void queryByIdTest() throws Exception {
      fileService.queryById(7);
}
}
