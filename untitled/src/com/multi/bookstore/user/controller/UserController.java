package com.multi.bookstore.user.controller;

import com.multi.bookstore.Index;
import com.multi.bookstore.dsconfig.Session;
import com.multi.bookstore.user.model.dto.User;
import com.multi.bookstore.user.service.UserService;
import com.multi.bookstore.user.view.UserView;

import java.util.ArrayList;

public class UserController {

    private UserService userService = new UserService();

    public void createUser(User user) {

        int result = 0;

        result = userService.createUser(user);

        if (result == 1) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }

        new Index().showFirstView();


    }

    public int idEqCheck(String id) {

        int result = 0;

        result = userService.idEqCheck(id);

        return result;
    }

    public void loginUser(User user) {

        int result = 0;

        result = userService.loginUser(user);

        if (result == 0) {
            System.out.println("없는 회원 입니다. 다시 로그인 해주세요");
            new Index().showFirstView();
        } else {
            System.out.println("로그인 성공");
            Session.loginUserId = user.getId();
            new Index().mainMenu();
        }
    }

    public void deleteUser(String id) {
        int result = 0;

        result = userService.deleteUser(id);

        if (result == 0) {
            System.out.println("회원 삭제에 실패 했습니다.");
            new Index().mainMenu();
        } else {
            System.out.println("회원 삭제에 성공 했습니다.");
            Session.loginUserId = null;
            new Index().showFirstView();
        }

    }

    public void updateUser(int ch, String updateStr) {

        int result = 0;

        result = userService.updateUser(ch, updateStr, Session.loginUserId);

        if (result == 0) {
            System.out.println("회원 수정에 실패 했습니다.");
            new UserView().userUpdateView();
        } else {
            System.out.println("수정이 완료 되었습니다");
            new UserView().userUpdateView();
        }
    }

    public ArrayList<String> myReviewList() {

        ArrayList<String> list = new ArrayList<String>();

        list = userService.myReviewList(Session.loginUserId);

        if (list == null) {
            System.out.println("데이터가 없습니다.");
        }

        return list;
    }
}
