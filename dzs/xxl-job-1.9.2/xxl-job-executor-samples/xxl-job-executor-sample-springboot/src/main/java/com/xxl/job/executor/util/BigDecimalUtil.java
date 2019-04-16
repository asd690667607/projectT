package com.xxl.job.executor.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
//防止工具类在外部实例化
private BigDecimalUtil(){

}
public static BigDecimal add(double v1, double v2){
BigDecimal b1 = new BigDecimal(Double.toString(v1));
BigDecimal b2 = new BigDecimal(Double.toString(v2));
return b1.add(b2);
}

public static BigDecimal sub(double v1,double v2){
BigDecimal b1 = new BigDecimal(Double.toString(v1));
BigDecimal b2 = new BigDecimal(Double.toString(v2));
return b1.subtract(b2);
}


public static BigDecimal mul(double v1,double v2){
BigDecimal b1 = new BigDecimal(Double.toString(v1));
BigDecimal b2 = new BigDecimal(Double.toString(v2));
return b1.multiply(b2);
}

public static BigDecimal div(double v1,double v2){
BigDecimal b1 = new BigDecimal(Double.toString(v1));
BigDecimal b2 = new BigDecimal(Double.toString(v2));
return b1.divide(b2,2,BigDecimal.ROUND_HALF_DOWN);//不四舍五入,保留2位小数
}

}
