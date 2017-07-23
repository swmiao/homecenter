package com.rm.homecenter.service;

import com.rm.homecenter.domain.FileAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by mswzs on 2017/7/20.
 */
public class AppService {
    static Logger log = LoggerFactory.getLogger(AppService.class);

    public static void processFile(File file, FileAttributeService fileAttributeService){
        if(file.isDirectory()) {
            File[] fileList = file.listFiles();
            for(File fileTemp : fileList) {
                try {
                    processFile(fileTemp, fileAttributeService);
                } catch (Exception e) {
                    log.error("Error to process file: " + fileTemp.getName() + e.getMessage());
                    throw e;
                }
            }
        } else {
            //保存文件属性到数据库
            List<FileAttribute> existingFAttributes = fileAttributeService.findByFileName(file.getName());
            if(existingFAttributes == null || existingFAttributes.size() == 0){
                fileAttributeService.save(getFileAttr(file));
            }

        }
    }

    public static FileAttribute getFileAttr(File file){
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
        return fAttribute;
    }
}
