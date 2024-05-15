package com.multi.bookstore;

import com.multi.bookstore.dsconfig.Session;
import com.multi.bookstore.user.view.UserView;

import java.util.Scanner;

public class Index {
    public void showFirstView() {

        Scanner sc = new Scanner(System.in);
        Session.loginUserId = null;

        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("9. 프로그램 종료");

        int ch = sc.nextInt();
        UserView userView = new UserView();

        switch (ch) {
            case 1:
                userView.showLogin();
                break;
            case 2:
                userView.showCreate();
                break;
            case 9:
                System.out.println("프로그램을 종료합니다.");
                return;
            default :
                System.out.println("제대로 된 값을 입력해주세요.");
                showFirstView();
                break;
        }
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 마이페이지");
        System.out.println("2. 도서 판매");
        System.out.println("3. 독후감 게시판");
        System.out.println("0. 로그아웃");
        System.out.println("9. 프로그램 종료");

        int ch = sc.nextInt();

        switch (ch) {
            
            case 1 : 
                // 마이페이지 이동
                new UserView().myPageView();
                break;
            case 2 :
                // 도서 판매 리스트 이동

                break;
            case 3 :
                // 독후감 게시판 이동

                break;
            case 0 : 
                // 로그아웃
                showFirstView();
                break;
            case 9 :
                // 프로그램 종료

                return;
            default :
                System.out.println("제대로 된 값을 입력해주세요.");
                mainMenu();
            break;
        }

    }

}
