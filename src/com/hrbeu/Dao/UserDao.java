package com.hrbeu.Dao;

import com.hrbeu.Entity.User;
import com.hrbeu.Utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public String selectByName(String username){
        connection = DBUtil.getConnection();
        String password = null;
        String sql = "select * from user where username=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                password = resultSet.getString(3);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return password;
    }

}
