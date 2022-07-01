package com.taegit.lotto;

import com.taegit.shop.LottoSeller;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    private List<Integer> numbers;

    public LottoPaper() {
        numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        if (numbers.size() < 6) {
            numbers.add(number);
        } else {
            System.out.println("이미 로또 번호가 완성되었습니다.");
        }
    }

    public void printLottoNumbers() {
        System.out.print("[" );
        for (Integer each : numbers ) {
            System.out.print(each + ",");
        }
        System.out.println("]" );
    }

    public int compareWith(List<Integer> winNumbers ) {
        int countSameNumber = 0;
        for(Integer each : winNumbers) {
            if(this.numbers.contains(each)) {
                countSameNumber++;
            }
        }
        return countSameNumber;
    }

//    @Override
//    public String toString() {
//        return "LottoPaper{" +
//                "numbers=" + numbers +
//                '}';
//    }
}
