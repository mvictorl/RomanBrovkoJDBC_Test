package com.mvictorl.service;

import com.mvictorl.dao.AddressDao;
import com.mvictorl.entity.Address;
import com.mvictorl.utilities.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvictorl on 7/11/17.
 */
public class AddressService extends Util implements AddressDao {
    Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);

            ps.setLong(1, address.getId());
            ps.setString(2, address.getCountry());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getStreet());
            ps.setInt(5, address.getPostCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null)
                ps.close();
            if(connection != null)
                connection.close();
        }
    }

    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getLong("ID"));
                address.setCountry(rs.getString("COUNTRY"));
                address.setCity(rs.getString("CITY"));
                address.setStreet(rs.getString("STREET"));
                address.setPostCode(rs.getInt("POST_CODE"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();
        }
        return addresses;
    }

    @Override
    public Address getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS WHERE ID=?";
        Address address = new Address();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            address.setId(rs.getLong("ID"));
            address.setCountry(rs.getString("COUNTRY"));
            address.setCity(rs.getString("CITY"));
            address.setStreet(rs.getString("STREET"));
            address.setPostCode(rs.getInt("POST_CODE"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null)
                preparedStatement.close();
            if(connection != null)
                connection.close();
        }
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement ps = null;
        String sql = "UPDATE ADDRESS SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setInt(4, address.getPostCode());
            ps.setLong(5, address.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null)
                ps.close();
            if(connection != null)
                connection.close();
        }

    }

    @Override
    public void remove(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ADDRESS WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null)
                preparedStatement.close();
            if(connection != null)
                connection.close();
        }
    }
}
