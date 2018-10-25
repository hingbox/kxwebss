package com.bootdo.test;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @ProjectName: bootdo
 * @Package: com.bootdo.test
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/25 18:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/25 18:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public static void main(String[]aa) throws FileNotFoundException {
        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());
    }


}