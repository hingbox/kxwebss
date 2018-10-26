package com.bootdo.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author duh
 * @create 2018/10/25 16:16
 * @email duh@elab-plus.com
 **/
public class HttpClientUtils {
    /**
     * 发送 get请求
     */
    public static String doGet(String url) {
        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse httpResponse = httpCilent.execute(httpGet);
            BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent())));
            String info = "";
            StringBuffer sb = new StringBuffer();
            while (null != (info = br.readLine())){
                //System.out.println(info);
                sb.append(info);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        doGet("http://www.baidu.com");
    }
}
