package com.rm.homecenter.service.impl;

import com.rm.homecenter.dao.FileCatalogDao;
import com.rm.homecenter.domain.FileCatalog;
import com.rm.homecenter.service.FileCatalogService;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mswzs on 2017/7/20.
 */
@Service
public class FileCatalogServiceImpl implements FileCatalogService {
    private FileCatalogDao fileCatalogDao;

    @Override
    public FileCatalog save(FileCatalog fileCatalog) {
        return fileCatalogDao.save(fileCatalog);
    }

    @Override
    public FileCatalog findById(String id) {
        return fileCatalogDao.findById(id);
    }

    @Override
    public List<FileCatalog> findByCatalogName(String catalogName) {
        return fileCatalogDao.findByCatalogName(catalogName);
    }

    @Override
    public List<FileCatalog> findByFileExtention(String fileExtention) {
        return fileCatalogDao.findByFileExtention(fileExtention);
    }

    public FileCatalogDao getFileCatalogDao() {
        return fileCatalogDao;
    }

    public void setFileCatalogDao(FileCatalogDao fileCatalogDao) {
        this.fileCatalogDao = fileCatalogDao;
    }
}
