package com.rm.homecenter.dao;

import com.rm.homecenter.domain.FileCatalog;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by mswzs on 2017/7/20.
 */
public interface FileCatalogDao extends Repository<FileCatalog, String> {
    public FileCatalog save(FileCatalog fileCatalog);

    public FileCatalog findById(String id);

    public List<FileCatalog> findByCatalogName(String catalogName);

    public List<FileCatalog> findByFileExtention(String fileExtention);
}
