package com.rm.homecenter.service;

import com.rm.homecenter.domain.FileAttribute;

import java.io.File;
import java.util.UUID;

/**
 * Created by mswzs on 2017/7/20.
 */
public class AppService {

    public static void processFile(File file, FileAttributeService fileAttributeService){
        if(file.isDirectory()) {
            File[] fileList = file.listFiles();
            for(File fileTemp : fileList) {
                processFile(fileTemp, fileAttributeService);
            }
        } else {
            FileAttribute fAttribute = new FileAttribute();
            fAttribute.setGuid(UUID.randomUUID().toString());
            fAttribute.setFileName(file.getName());
            fAttribute.setFilePath(file.getAbsolutePath().replaceAll("\\\\", "/"));
            fAttribute.setFileSize(file.length());
            int lastDot = file.getName().lastIndexOf(".");
            if(lastDot > 0) {
                fAttribute.setFileExtention(file.getName().substring(lastDot + 1, file.getName().length()));
            } else {
                file.delete();
            }
            fAttribute.setParentName(file.getParentFile().getName());
            //保存文件属性到数据库
            fileAttributeService.save(fAttribute);

        }
    }
}
