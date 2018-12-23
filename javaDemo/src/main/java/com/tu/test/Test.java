package com.tu.test;

/**
 * Created by tuyongjian on 2018/12/23.
 */
public class Test {

    // true打印数字，false 打印字母
    private boolean flag = true;

    public synchronized void printNum(String s){
        try {
            if(!flag){
              super.wait();
            }
            System.out.print(s);
            flag = false;
            super.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void printLetter(String s){
        try {
            if(flag){
                super.wait();
            }
            System.out.printf(s);
            flag = true;
            super.notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    public static class LetterPrintThread extends Thread{
        public Test test;
        public LetterPrintThread(String name,Test test){
            super(name);
            this.test = test;
        }
        public void run(){
            for (int i=1; i<=26;i++){
                int temp = i+64;
                char c = (char) temp;
                test.printLetter(c+" ");
            }
        }
    }

    public static class NumberPrintThread extends Thread{
        public Test test;
        public NumberPrintThread(String name,Test test){
            super(name);
            this.test = test;
        }
        public void run(){
            for (int i = 1; i <= 26; i++) {
                String str = (2 * i - 1) + " " + 2 * i + " ";
                test.printNum(str);
            }
        }
    }



    public static void main(String[] args) {
        Test test = new Test();
        new LetterPrintThread("字母打印",test).start();
        new NumberPrintThread("数字打印",test).start();

    }
}
