package com.rm.homecenter.controller;

import com.rm.homecenter.constant.HomeCenterConstants;
import com.rm.homecenter.service.AppService;
import com.rm.homecenter.service.FileAttributeService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

/**
 * Created by mswzs on 2017/7/20.
 */
@Controller
@EnableConfigurationProperties
public class AppController {

    private FileAttributeService fileAttributeService;

    @RequestMapping(value="/startScan",method=RequestMethod.GET)
    public void startScan(){
        File rootFile = new File(HomeCenterConstants.PATH);
        AppService.processFile(rootFile, fileAttributeService);
    }

    public FileAttributeService getFileAttributeService() {
        return fileAttributeService;
    }

    public void setFileAttributeService(FileAttributeService fileAttributeService) {
        this.fileAttributeService = fileAttributeService;
    }
}
