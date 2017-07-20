package com.rm.homecenter.dao;

import com.rm.homecenter.domain.FileAttribute;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by mswzs on 2017/7/20.
 */
public interface FileAttributeDao extends Repository<FileAttribute, String> {
    public FileAttribute save(FileAttribute fileAttribute);

    public FileAttribute findById(String id);

    public List<FileAttribute> findByFileName(String fileName);

}
