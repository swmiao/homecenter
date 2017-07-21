package com.rm.homecenter.service.impl;

import com.rm.homecenter.dao.FileAttributeDao;
import com.rm.homecenter.domain.FileAttribute;
import com.rm.homecenter.service.FileAttributeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mswzs on 2017/7/20.
 */
@Service
public class FileAttributeServiceImpl implements FileAttributeService {

    private FileAttributeDao fileAttributeDao;

    public FileAttribute save(FileAttribute fileAttribute){
       return fileAttributeDao.save(fileAttribute);
    }

    public FileAttribute findById(String id){
        return fileAttributeDao.findById(id);
    }

    public List<FileAttribute> findByFileName(String fileName){
        return fileAttributeDao.findByFileName(fileName);
    }

    public FileAttributeDao getFileAttributeDao() {
        return fileAttributeDao;
    }

    public void setFileAttributeDao(FileAttributeDao fileAttributeDao) {
        this.fileAttributeDao = fileAttributeDao;
    }
}
