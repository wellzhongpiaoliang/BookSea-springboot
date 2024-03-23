package com.seabooks.controller;

import cn.hutool.core.io.FileUtil;
import com.seabooks.mapper.UserMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author 14745
 * @date 2023/12/8 21:58
 */
@RestController
@CrossOrigin()
@RequestMapping("/file")
public class FileController {
    @Autowired
    private UserMapper userMapper;
//    文件上传存储路径
    private static final String filePath = System.getProperty("user.dir") + "/src/main/resources/static/img/user/";

//    头像上传
//    produces = "application/json; charset=utf-8"解决响应数据时冒问号,乱码等
    @PostMapping(value="/upload",produces = "application/json; charset=utf-8")
    public String upload(MultipartFile file, Response response) throws IOException, InterruptedException {
        synchronized (FileController.class){
//            response.setCharacterEncoding("utf-8");
//            获取时间戳
            String flag = System.currentTimeMillis()+"-"+file.getOriginalFilename();
//            获取上传名
//            String fileName = file.getOriginalFilename();
            try {
//                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                FileUtil.writeBytes(file.getBytes(),filePath+flag);
                System.out.println("文件上传成功:"+flag);
                Thread.sleep(1L);
            }catch ( Exception e){
                System.out.println("上传失败");
            }
            return flag;
        }
    }
}
