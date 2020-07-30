package com.hrbeu.Dao;

import com.hrbeu.Entity.Emp;
import com.hrbeu.Utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public List<Emp> selectAllByPage(int page,int count){
        List<Emp> emps = new ArrayList<Emp>();
        Emp emp = null;
        connection = DBUtil.getConnection();
        String sql="select * from employee limit ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,count*page-count);
            preparedStatement.setInt(2,count);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String EMPID = resultSet.getString(1);
                String DEPTNO = resultSet.getString(2);
                String EMPNAME = resultSet.getString(3);
                int AGE = resultSet.getInt(4);
                String ADDRESS = resultSet.getString(5);
                int SAL = resultSet.getInt(6);
                emp = new Emp(EMPID,DEPTNO,EMPNAME,AGE,ADDRESS,SAL);
                emps.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return emps;
    }


    public int selectAllCount(){
        connection = DBUtil.getConnection();
        int count =0;
        String sql="select count(*) from employee";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return count;
    }

    public void insert(Object...objects){
        connection = DBUtil.getConnection();
        String sql = "insert into employee(EMPID,DEPTNO,EMPNAME,AGE,ADDRESS,SAL) values(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<objects.length;i++){
                preparedStatement.setObject(i+1,objects[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }


    public void deleteById(String id){
        connection = DBUtil.getConnection();
        String sql = "delete from employee where EMPID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }

    public Emp selectById(String id){
        Emp emp = null;
        connection = DBUtil.getConnection();
        String sql="select * from employee where EMPID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String EMPID = resultSet.getString(1);
                String DEPTNO = resultSet.getString(2);
                String EMPNAME = resultSet.getString(3);
                int AGE = resultSet.getInt(4);
                String ADDRESS = resultSet.getString(5);
                int SAL = resultSet.getInt(6);
                emp = new Emp(EMPID,DEPTNO,EMPNAME,AGE,ADDRESS,SAL);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return emp;

    }

    public void update(Object...objects){
        connection = DBUtil.getConnection();
        String sql = "update employee set DEPTNO=?,EMPNAME=?,AGE=?,ADDRESS=?,SAL=? where EMPID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<objects.length;i++){
                preparedStatement.setObject(i+1,objects[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);

    }

}
