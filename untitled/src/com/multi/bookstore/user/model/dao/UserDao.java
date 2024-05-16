package com.multi.bookstore.user.model.dao;

import com.multi.bookstore.user.model.dto.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.multi.bookstore.dsconfig.DSJDBCTemplate.close;
import static com.multi.bookstore.dsconfig.DSJDBCTemplate.conn;

public class UserDao {

    private Properties prop = null;
    public UserDao() {

        try {
            prop = new Properties();
            prop.load(new FileReader("resources/mappers/usermapper.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int insertUser(Connection conn, User user) {

        int result = 0;

        PreparedStatement ps = null;

        String sql = prop.getProperty("insertUser");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getPw());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }


        return result;

    }

    public int idEqCheck(Connection conn, String id) {

        int result = 0;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = prop.getProperty("idEqCheck");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();

            if(rs.next()){
                result = rs.getInt("count");
            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            close(ps);
            close(rs);
        }


        return result;


    }

    public int loginUser(User user) {

        int result = 0;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = prop.getProperty("loginUser");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getPw());

            rs = ps.executeQuery();

            if(rs.next()){
                result = rs.getInt("count");
            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            close(ps);
            close(rs);
        }

        return result;

    }

    public int deleteUser(Connection conn, String id) {

        int result = 0;
        PreparedStatement ps = null;
        String sql = prop.getProperty("deleteUser");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public int updateUser(Connection conn, int ch, String updateStr, String id) {

        int result = 0;
        PreparedStatement ps = null;
        String sql = null;
        switch (ch) {
            case 1 :
                sql = prop.getProperty("pwUpdate");
                break;
            case 2 :
                sql = prop.getProperty("emailUpdate");
                break;
            case 3 :
                sql = prop.getProperty("addressUpdate");
                break;
            case 4 :
                sql = prop.getProperty("phoneUpdate");
                break;
        }


        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,updateStr);
            ps.setString(2,id);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public ArrayList<String> myReviewSelect(Connection conn, String loginUserId) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<String>();

        String sql = prop.getProperty("myReviewSelect");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginUserId);
            rs = ps.executeQuery();

            while(rs.next()) {
                list.add(rs.getString("br_title"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
