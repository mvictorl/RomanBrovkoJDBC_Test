package com.mvictorl.dao;

import com.mvictorl.entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mvictorl on 7/11/17.
 */
public interface EmplProjDao {
    void add(EmplProj emplProj) throws SQLException;
    List<EmplProj> getAll() throws SQLException;
    EmplProj getByEmplyeeIdAndProjectId(Long emplyeeId, Long projectId) throws SQLException;
    void update(EmplProj emplProj) throws SQLException;
    void remove(EmplProj emplProj) throws SQLException;
}
