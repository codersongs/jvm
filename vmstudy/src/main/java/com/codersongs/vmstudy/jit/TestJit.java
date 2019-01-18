package com.codersongs.vmstudy.jit;

/**
 * @author wusongsong
 * @date 2019/1/8
 */
public class TestJit {
    public static double calcPi(){
        double ret = 0;
        for (int i = 0; i < 10000; i++) {
            ret += ((i&1) == 0 ? -1:1)*1.0/(2*i-1);
        }
        return  ret * 4;
    }

    public static void met(){
        int a = 0, b = 0;
        b = a + b;
    }

    public static void main(String[] args) throws Exception {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            calcPi();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("count is:" + (end - start) + "ms");
        for (int i = 0; i < 500; i++) {
            met();
        }
        Thread.sleep(1000);
    }
    
}
