package com.taegit.shop;

import com.taegit.lotto.LottoPaper;
import com.taegit.user.LottoBuyer;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private static final int LOTTO_FEE = 1000;

    private LottoGenerator lottoGenerator;

    public LottoSeller () {
        lottoGenerator = new LottoGenerator();
    }

    public void purchaseLottos(LottoBuyer buyer, int money) {
        int total = money / LOTTO_FEE;
        System.out.println("총 "+total+"개를 구매하셨습니다. (거스름돈이 있다면 제가 갖습니다.)");
        for (int i = 0 ; i < total ; i++ ) {
            buyer.addLotto(lottoGenerator.generateLotto());
        }
    }
}

