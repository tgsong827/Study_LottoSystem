package com.taegit;

import com.taegit.shop.LottoSeller;
import com.taegit.statistic_.LottoStatistics;
import com.taegit.user.LottoBuyer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int money = 0;
        while(money < 1000) {
            try {
                LottoBuyer lottoBuyer = new LottoBuyer();
                lottoBuyer.plusAmount(20000);

                System.out.println("로또 구입 금액을 입력해주세요.");
                money = sc.nextInt();
                if(money < 1000) {
                    throw new InputMismatchException();
                }
                if(lottoBuyer.minusAmount(money) < 0) {
                    System.out.println("그만큼 돈이 없습니다. 다시 시도해주세요.\n\n");
                    money = 0;
                } else {
                    LottoSeller lottoSeller = new LottoSeller();
                    lottoSeller.purchaseLottos(lottoBuyer, money);

                    boolean exit = false;
                    while (!exit) {
                        try {
                            System.out.println("\n\n지난 주 당첨 번호를 입력해 주세요.");
                            String winNumberStr = sc.next();
                            List<Integer> winNumbers = Arrays.stream(winNumberStr.split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

                            // lottobuyer가 갖고 있는 로또Box의 당첨 통계를 계산 해야함
                            LottoStatistics lottoStatistics = new LottoStatistics();
                            lottoStatistics.showMyLottoStatistics(lottoBuyer, winNumbers);

                            exit = true;
                        } catch (Exception e) {
                            System.out.println("잘 입력해주세요.");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("1000이상 숫자만 똑바로 입력하셈, 소수점 안됨");
            }
        }
    }
}
