package com.example.demo.things.imgupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {
    //创建文件上传类型白名单
    private static final List<String> CONTENT_TYPE = Arrays.asList("image/png", "image/jpeg");
    //创建日志常量对象
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

    @Override
    public String uploadImages(MultipartFile file) {

        //判断是否为图片文件
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件上传类型
        String contentType = file.getContentType();
        //判断是否为白名单中的类型
        if (!CONTENT_TYPE.contains(contentType)) {
            //输出日志为什么错误1.创建日志常量2.输出原因
            LOGGER.info("文件类型不合法 {}", originalFilename);
            return null;
        }
        //判断文件内容
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage != null) {
                //保存
                Random rand = new Random();
                int z = rand.nextInt(1000);
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                String time = df.format(new Date());
                time = time.concat(String.valueOf(z));
                originalFilename = time + originalFilename;
                file.transferTo(new File("D:\\nginx\\html\\test\\image\\" + originalFilename));
            }
            //返回访问路径
            return "http://localhost/test/image/" + originalFilename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
