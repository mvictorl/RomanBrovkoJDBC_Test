package com.mvictorl.dao;

import com.mvictorl.entity.Address;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mvictorl on 7/11/17.
 */
public interface AddressDao {
    void add(Address address) throws SQLException;
    List<Address> getAll() throws SQLException;
    Address getById(Long id) throws SQLException;
    void update(Address address) throws SQLException;
    void  remove(Address address) throws SQLException;
}
