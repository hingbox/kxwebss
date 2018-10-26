package com.bootdo.test;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

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
//        //获取跟目录
//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        if(!path.exists()) path = new File("");
//        System.out.println("path:"+path.getAbsolutePath());
        String url="1212";
        Pattern pattern = Pattern
                .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
        System.out.println(pattern.matcher(url).matches());
    }


}