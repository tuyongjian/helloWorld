package com.tu.test;

/**
 * Created by tuyongjian on 2018/9/15.
 */
public class JavaDemo1 {
        static String s;
        public static void main (String[]args) {

          int total =0;
            for (int i = 0; i <4 ; i++) {
                if(i==1){
                    continue;
                }
                if (i==2){
                    break;
                }

                total+=i;
            }
            System.out.println(total);

            String str1= "hello";
            String str2= "he"+new String("llo");
            System.out.println(str1==str2);
            System.out.println(str1.equals(str2));
        }
}
