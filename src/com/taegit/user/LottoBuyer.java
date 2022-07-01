package com.taegit.user;

import com.taegit.lotto.LottoPaper;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {

    private int amount;

    private List<LottoPaper> lottoBox;

    public LottoBuyer() {
        amount = 0;
        lottoBox = new ArrayList<>();
    }

    public void addLotto(LottoPaper lottoPaper) {
        lottoBox.add(lottoPaper);
    }

    public int plusAmount(int money) {
        return amount += money;
    }

    public int minusAmount(int money) {
        return amount -= money;
    }

    public List<LottoPaper> getLottoBox() {
        return lottoBox;
    }
}
