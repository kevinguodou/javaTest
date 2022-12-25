package com.example.demo.jdk.generics;

/**
 * @author dou.guo
 * @version NumberProxyTest, v 0.1 2022-10-11 10:49 上午 dou.guo Exp $
 */
public class NumberProxyTest {


    //？可能是Integer，也可以是Double
   static Number add(NumberProxy<? extends Number> number){
       //number.setFirst(<? extends Number>)  -》Number=object
       //<? extends Number> number.getFirst() -》 Number num = integer/double 可以读
       return number.getFirst().intValue() + number.getSecond().intValue();
    }

    //?可以是number，也可以是Object
    void sub(NumberProxy<? super Integer> number){
        //number.setFirst(<? super Integer>) 可以写
        //<? super Integer> number.getFirst() -》 Integer num = number/object 不能读
        number.setFirst(12);
        number.setFirst(34);
    }

    public static void main(String[] args) {
        NumberProxy<Integer> integerNumber = new NumberProxy();
        NumberProxy<Double> doubleNumber = new NumberProxy();
    }

}
