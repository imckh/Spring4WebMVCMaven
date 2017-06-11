package com.ckh.controller;

import com.ckh.pojo.UploadedImageFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang.RandomStringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by CKH on 2017/6/10 10:18.
 * 新建类UploadController 作为上传控制器
 * 准备方法upload 映射上传路径/uploadImage
 */
@Controller
public class UploadController {

    /**
     * 上传控制器
     * @param request HttpServletRequest
     * @param file UploadedImageFile 注入image
     * @return new ModelAndView("showUploadedFile")
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("/uploadImage")
//    方法的第二个参数UploadedImageFile 中已经注入好了 image
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IOException, IllegalStateException {
//        获取一个随机文件名。 因为用户可能上传相同文件名的文件，为了不覆盖原来的文件，通过随机文件名的办法来规避
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
//        根据request.getServletContext().getRealPath 获取到web目录下的image目录，用于存放上传后的文件
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
        newFile.getParentFile().mkdirs();
//        调用file.getImage().transferTo(newFile); 复制文件
        file.getImage().transferTo(newFile);

        ModelAndView modelAndView = new ModelAndView("showImage");
//        把生成的随机文件名提交给视图，用于后续的显示
        modelAndView.addObject("imageName", newFileName);
        return modelAndView;
    }
}
