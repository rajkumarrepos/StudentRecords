package com.spring.Energy.conversion;

import org.springframework.stereotype.Service;

@Service
public class Conversion implements Conversions {
    public String conversionOfNum(int num) {
        switch (num) {
            case 1:
                return "I";

            case 2:
                return "II";

            case 3:
                return "III";

            case 4:
                return "IV";

            case 5:
                return "V";

            case 6:
                return "VI";

            case 7:
                return "VII";

            case 8:
                return "VIII";

            case 9:
                return "IX";

            case 10:
                return "X";

            case 11:
                return "XI";

            case 12:
                return "XII";


            default:
            throw new IllegalStateException("Unexpected value: " );



        }
    }
}