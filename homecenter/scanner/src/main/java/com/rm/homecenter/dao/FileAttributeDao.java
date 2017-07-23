package com.rm.homecenter.dao;

import com.rm.homecenter.domain.FileAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mswzs on 2017/7/20.
 */
@Repository
public interface FileAttributeDao extends JpaRepository<FileAttribute, Long> {
    public FileAttribute save(FileAttribute fileAttribute);

    public FileAttribute findById(String id);

    public List<FileAttribute> findByFileName(String fileName);

    public List<FileAttribute> findAll();

}
