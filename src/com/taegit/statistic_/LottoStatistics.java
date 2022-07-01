package com.taegit.statistic_;

import com.taegit.lotto.LottoPaper;
import com.taegit.user.LottoBuyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final int FIRST_PLACE_AMOUNT = 2000000000;
    private static final int SECOND_PLACE_AMOUNT = 1500000;
    private static final int THIRD_PLACE_AMOUNT = 50000;
    private static final int FOURTH_PLACE_AMOUNT = 5000;

    private Integer firstPlaceCount;
    private Integer secondPlaceCount;
    private Integer thirdPlaceCount;
    private Integer fourthPlaceCount;

    private Double retrunRatio;

    public LottoStatistics() {
        firstPlaceCount = 0;
        secondPlaceCount = 0;
        thirdPlaceCount = 0;
        fourthPlaceCount = 0;
    }

    public void showMyLottoStatistics(LottoBuyer lottoBuyer, List<Integer> winNumbers) {
        List<LottoPaper> papers = lottoBuyer.getLottoBox();

        for(LottoPaper paper : papers) {
            switch (paper.compareWith(winNumbers)) {
                case 3: fourthPlaceCount++;break;
                case 4: thirdPlaceCount++;break;
                case 5: secondPlaceCount++;break;
                case 6: firstPlaceCount++;break;
                default : break;// 꽝
            }
        }

        // 수익률 계산하고
        calculateReturnRatio(papers.size());

        printCurrentStatistics();
    }

    private void calculateReturnRatio(int countPapers) {
        double totalPurchaseAmount = countPapers * 1000;
        double totalReturnAmount = FIRST_PLACE_AMOUNT*firstPlaceCount + SECOND_PLACE_AMOUNT*secondPlaceCount
                + THIRD_PLACE_AMOUNT*thirdPlaceCount + FOURTH_PLACE_AMOUNT*fourthPlaceCount;

        this.retrunRatio = (totalReturnAmount / totalPurchaseAmount) ; //* 100;
    }

    private void printCurrentStatistics() {
        System.out.println("당첨 통계");
        System.out.println("------------------");
        System.out.println("3개 일치 (" +FOURTH_PLACE_AMOUNT+"원) - " + fourthPlaceCount + "개");
        System.out.println("4개 일치 (" +THIRD_PLACE_AMOUNT+"원) - " + thirdPlaceCount + "개");
        System.out.println("5개 일치 (" +SECOND_PLACE_AMOUNT+"원) - " + secondPlaceCount + "개");
        System.out.println("6개 일치 (" +FIRST_PLACE_AMOUNT+"원) - " + firstPlaceCount + "개");
        System.out.println("총 수익률은 "+retrunRatio+"입니다.");
    }
}
