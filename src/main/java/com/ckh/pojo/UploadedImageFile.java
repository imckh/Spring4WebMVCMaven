package com.ckh.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by CKH on 2017/6/10 10:01.
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
