 

## 1. 配置web.xml允许访问*.jpg    

在web.xml中新增加一段
```xml
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.jpg</url-pattern>
</servlet-mapping>
```
表示允许访问*.jpg<br>
为什么要加这一段呢？ 因为配置springmvc的servlet的时候，使用的路径是"/"，导致静态资源在默认情况下不能访问，所以要加上这一段，允许访问jpg。 并且必须加在springmvc的servlet之前
如果你配置spring-mvc使用的路径是/*.do，就不会有这个问题了。<br>
注： 这里仅仅是允许访问jpg,如果你要显示png,gif那么需要额外进行配置
代码比较
## 2. 配置springmvc-servlet.xml    

新增加一段配置
 
`<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>`
 
开放对上传功能的支持

注意 需要maven添加
```xml
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.1</version>
</dependency>
```

## 3. upload.jsp 上传页面    

上传页面，需要注意的是form 的两个属性必须提供
`method="post"` 和 `enctype="multipart/form-data"` 缺一不可
上传组件 增加一个属性 accept="image/*" 表示只能选择图片进行上传
留意 `<input type="file" name="image" accept="image/*" />` 这个`image`，后面会用到这个`image`
```xml
<form action="/uploadImage" method="post" enctype="multipart/form-data">
    选择图片:<input type="file" name="image" accept="image/*" /> <br/> 
    <input type="submit" value="上传"/>
</form>
```

## 4. 准备UploadedImageFile    

在`UploadedImageFile`中封装`MultipartFile`类型的字段 `image `，用于接受页面的注入

这里的字段 `image`必须和上传页面`upload.jsp`中的`image`
`<input type="file" name="image" accept="image/*" />`
保持一致
```java
import org.springframework.web.multipart.MultipartFile;
 
public class UploadedImageFile {
    MultipartFile image;
 
    public MultipartFile getImage() {
        return image;
    }
 
    public void setImage(MultipartFile image) {
        this.image = image;
    }
 
}
```

## 5. UploadController 上传控制器

新建类`UploadController` 作为上传控制器
准备方法upload 映射上传路径`/uploadImage`
1. 方法的第二个参数`UploadedImageFile` 中已经注入好了 `image`
2. 通过 `RandomStringUtils.randomAlphanumeric(10);`获取一个随机文件名。 因为用户可能上传相同文件名的文件，为了不覆盖原来的文件，通过随机文件名的办法来规避
3. 根据`request.getServletContext().getRealPath` 获取到`web`目录下的`image`目录，用于存放上传后的文件。
4. 调用`file.getImage().transferTo(newFile);` 复制文件
5. 把生成的随机文件名提交给视图，用于后续的显示
```java
package controller;
 
import java.io.File;
import java.io.IOException;
 
import javax.servlet.http.HttpServletRequest;
 
import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import pojo.UploadedImageFile;
 
@Controller
public class UploadController {
 
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
 
        // 这里要和jsp对应
        ModelAndView mav = new ModelAndView("showImage");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}
```

## 6. showImage.jsp 显示图片的页面

在`webapp` 下新建文件`showImage.jsp` 显示上传的图片
`<img src="image/${imageName}"/>`

## 7. 测试    

上传后的文件位置
`C:\Programing\tools\Tomcat 9.0\webapps\ROOT\image\twq315nHEO.jpg`

参考
[HOW2J-springMVC上传文件](http://how2j.cn/k/springmvc/springmvc-upload/621.html?p=9001)