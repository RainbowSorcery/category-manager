package com.lyra.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.lyra.config.AliOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

@Component
public class UploadUtils {
    @Autowired
    private AliOSSProperties aliOSSProperties;

    public String upload(String fileName, byte[] fileByte) {
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKey();
        String accessKeySecret =  aliOSSProperties.getSecretKey();
        String bucketName = aliOSSProperties.getBucket();


        OSS ossClient = null;
        try {
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(fileByte));
        } catch (OSSException e){
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }

        return aliOSSProperties.getDomain() + "/" + fileName;
    }
}
