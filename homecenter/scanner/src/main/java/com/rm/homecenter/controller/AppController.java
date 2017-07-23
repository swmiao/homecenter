package com.rm.homecenter.controller;

import com.rm.homecenter.constant.HomeCenterConstants;
import com.rm.homecenter.domain.FileAttribute;
import com.rm.homecenter.service.AppService;
import com.rm.homecenter.service.FileAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by mswzs on 2017/7/20.
 */
@Controller
@EnableConfigurationProperties
public class AppController {

    @Autowired
    private FileAttributeService fileAttributeService;

    @RequestMapping(value="/startScan",method=RequestMethod.GET)
    public void startScan(HttpServletRequest request, HttpServletResponse response){
        try{
            File rootFile = new File(HomeCenterConstants.PATH);
            AppService.processFile(rootFile, fileAttributeService);
            response.getOutputStream().println("Save file metadata successsfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/homePage",method=RequestMethod.GET)
    public void homePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<FileAttribute> fileAttributeList = fileAttributeService.findAll();
    }

    public FileAttributeService getFileAttributeService() {
        return fileAttributeService;
    }

    public void setFileAttributeService(FileAttributeService fileAttributeService) {
        this.fileAttributeService = fileAttributeService;
    }
}
