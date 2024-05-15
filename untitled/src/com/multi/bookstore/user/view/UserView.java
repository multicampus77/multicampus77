package com.multi.bookstore.user.view;

import com.multi.bookstore.Index;
import com.multi.bookstore.dsconfig.Session;
import com.multi.bookstore.user.controller.UserController;
import com.multi.bookstore.user.model.dao.UserDao;
import com.multi.bookstore.user.model.dto.User;
import com.multi.bookstore.user.service.UserService;

import java.util.Scanner;

public class UserView {

    UserController userController = new UserController();

    public void showCreate() {

        Scanner sc = new Scanner(System.in);
        String id = null;

        while (true) {
            System.out.println("아이디를 입력해주세요 : ");
            id = sc.next();

            int check = userController.idEqCheck(id);

            if (check == 1) {
                System.out.println("아이디가 중복입니다. \n 다시 입력해주세요.");
            } else {
                break;
            }
        }


        System.out.println("패스워드를 입력해주세요 : ");
        String pw = sc.next();

        System.out.println("이름을 입력해주세요 : ");
        String name = sc.next();

        System.out.println("이메일을 입력해주세요 : ");
        String email = sc.next();

        System.out.println("주소를 입력해주세요 : ");
        String address = sc.next();

        System.out.println("전화번호를 입력해주세요 : ");
        String phone = sc.next();

        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);

        System.out.println(user.toString());


        userController.createUser(user);


    }

    public void showLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("아이디를 입력해주세요.");
        String id = sc.next();

        System.out.println("비밀번호를 입력해주세요.");
        String pw = sc.next();

        User user = new User();
        user.setId(id);
        user.setPw(pw);

        userController.loginUser(user);

    }

    public void myPageView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 회원수정");
        System.out.println("2. 회원삭제");
        System.out.println("3. 본인 작성 글 조회");
        System.out.println("4. 장바구니");
        System.out.println("0. 돌아가기");
        System.out.println("9. 프로그램 종료");
        int ch = sc.nextInt();

        switch (ch) {
            case 1 :
                userUpdateView();
                break;
            case 2 :
                userDeleteView();
                break;
            case 3 :
                // 본인 작성글 조회 
                break;
            case 4 :
                // 장바구니
                break;
            case 0 :
                new Index().mainMenu();
                break;
            case 9 :
                return;

            default :
                System.out.println("제대로 된 값을 입력해주세요.");
                myPageView();
                break;
        }
    }

    public void userUpdateView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정 할 항목을 선택해주세요.");
        System.out.println("1. 패스워드");
        System.out.println("2. 이메일");
        System.out.println("3. 주소");
        System.out.println("4. 전화번호");
        System.out.println("0. 돌아가기");
        System.out.println("9. 프로그램종료");

        int ch = sc.nextInt();
        String updateStr = null;
        switch (ch) {
            case 1 :
                System.out.println("패스워드를 어떻게 수정 하시겠습니까?");
                break;
            case 2 :
                System.out.println("이메일을 어떻게 수정 하시겠습니까?");
                break;
            case 3 :
                System.out.println("주소를 어떻게 수정 하시겠습니까?");
                break;
            case 4 :
                System.out.println("전화번호를 어떻게 수정 하시겠습니까?");
                break;
            case 9 :
                return;
            case 0 :
                myPageView();
                break;
            default :
                System.out.println("제대로 된 값을 입력해주세요.");
                userUpdateView();
                break;
        }
        updateStr = sc.next();
        userController.updateUser(ch, updateStr);

    }

    public void userDeleteView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("정말 삭제 하시겠습니까? y/n");
        String ch2 = sc.next();

        if (ch2.equals("y")) {
            userController.deleteUser(Session.loginUserId);
        } else if (ch2.equals("n")){
            System.out.println("마이페이지로 이동합니다.");
            myPageView();
        } else {
            System.out.println("입력 값이 잘못 되었습니다.");
            myPageView();
        }
    }
}
