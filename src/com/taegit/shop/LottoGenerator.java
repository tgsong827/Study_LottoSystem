package com.taegit.shop;

import com.taegit.lotto.LottoPaper;

import java.util.Random;

public class LottoGenerator {

    public LottoPaper generateLotto() {
        LottoPaper lottoPaper = new LottoPaper();

        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            int number = random.nextInt(45) + 1;
            lottoPaper.addNumber(number);
        }

        lottoPaper.printLottoNumbers();

        return lottoPaper;
    }
}
