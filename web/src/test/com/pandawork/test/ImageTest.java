package com.pandawork.test;

import com.pandawork.common.entity.Image;
import com.pandawork.service.ImageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * newframework
 * Created by TestUser on 2017/8/12.
 */

public class ImageTest extends AbstractTestCase {
    @Autowired
    ImageService imageService;

    /**
     * 增加
     * @throws Exception
     */
    @Test
    public void addImageTest() throws Exception {
    Image image = new Image();
    image.setName("lala");
    image.setVisible(0);
    imageService.addImage(image);
}

    /**
     * 删除
     * @throws Exception
     */
    @Test
    public void deleteTest()throws Exception{
     imageService.deleteImage(8);
}

    /**
     * 全部
     * @throws Exception
     */
    @Test
    public void listAllTest() throws Exception {
    System.out.println(imageService.listAll());
}

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
    Image image = new Image();
    image.setName("hhhh");
    image.setVisible(1);
    image.setId(7);
    imageService.updateImage(image);
}

    /**
     * 查找
     * @throws Exception
     */
    @Test
    public void queryByIdTest() throws Exception {
      imageService.queryById(7);
}
}
