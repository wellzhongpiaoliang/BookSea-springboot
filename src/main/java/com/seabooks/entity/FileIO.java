package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 14745
 * @date 2023/12/8 21:45
 */
@Data
@Accessors(chain = true) // 不写默认为false，当该值为 true 时，对应字段的 setter 方法调用后，会返回当前对象
@NoArgsConstructor
@AllArgsConstructor
public class FileIO { // 文件上传
//    该实体无用
    private String virtualPath; //动态变化的路径
    private String fileName;    //文件名称  uuid.pdf
}
