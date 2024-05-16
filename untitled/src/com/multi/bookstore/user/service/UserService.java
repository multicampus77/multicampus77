package com.multi.bookstore.user.service;

import com.multi.bookstore.user.model.dao.UserDao;
import com.multi.bookstore.user.model.dto.User;

import java.sql.Connection;
import java.util.ArrayList;

import static com.multi.bookstore.dsconfig.DSJDBCTemplate.*;

public class UserService {

    private final UserDao userDao;

    public UserService() {userDao = new UserDao();}

    public int createUser(User user) {
        int result = 0;
        Connection conn = getConnection();

        result = userDao.insertUser(conn, user);

        if (result > 0 ) commit(conn);

        else rollback(conn);

        return result;

    }

    public int idEqCheck(String id) {
        int result = 0;
        Connection conn = getConnection();

        result = userDao.idEqCheck(conn, id);

        return result;
    }

    public int loginUser(User user) {

        int result = 0;
        Connection conn = getConnection();

        result = userDao.loginUser(user);

        return result;

    }

    public int deleteUser(String id) {
        int result = 0;
        Connection conn = getConnection();

        result = userDao.deleteUser(conn, id);

        if (result > 0 ) commit(conn);

        else rollback(conn);

        return result;

    }

    public int updateUser(int ch, String updateStr, String loginUserId) {
        int result = 0;
        Connection conn = getConnection();

        result = userDao.updateUser(conn, ch, updateStr, loginUserId);

        if (result > 0 ) commit(conn);

        else rollback(conn);

        return result;
    }

    public ArrayList<String> myReviewList(String loginUserId) {
        ArrayList<String> list = new ArrayList<String>();
        Connection conn = getConnection();

        list = userDao.myReviewSelect(conn, loginUserId);

        return list;
    }
}
