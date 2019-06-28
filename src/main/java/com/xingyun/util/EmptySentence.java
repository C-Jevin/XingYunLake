package com.xingyun.util;


import java.math.BigDecimal;

public class EmptySentence{


    public static Double judeEmpty(BigDecimal data){

        if(data==null){
            return 0d;
        }
        return data.doubleValue();


    }
}
