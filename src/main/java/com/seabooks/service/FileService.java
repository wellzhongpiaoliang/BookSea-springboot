package com.seabooks.service;

import com.seabooks.entity.FileIO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 14745
 * @date 2023/12/8 21:49
 */
public interface FileService {
    //文件上传
    FileIO upload(MultipartFile file) throws IOException;
}
