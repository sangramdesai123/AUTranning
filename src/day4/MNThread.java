package day4;

class MNThread extends Thread{
    String name = "";
    static Integer num = 1;
    public void run(){
        while(num <= 100){

            synchronized(num){

                System.out.println(name + " " +num);
                num++;

            }

            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}


        }
    }
    public static void main(String args[]){
        MNThread t1 = new MNThread();
        t1.name = "Thread one";
        MNThread t2 = new MNThread();
        t2.name = "Thread two";
        MNThread t3 = new MNThread();
        t3.name = "Thread three";
        t1.start();
        t2.start();
        t3.start();
    }
}