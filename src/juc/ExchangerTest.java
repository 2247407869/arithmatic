package juc;

import java.util.concurrent.Exchanger;
public class ExchangerTest implements Runnable{
    private  Exchanger<String> exchange ;
    private  String name;
    private	 String str;
    public ExchangerTest(Exchanger<String> exchange, String name, String str){
        this.exchange=exchange;
        this.name=name;
        this.str=str;
    }
    @Override
    public void run(){  //线程同步用了synchronized否则无法保证s的正确性
        try{
            System.out.println(name+"线程自己的数据是："+str);
            String s=exchange.exchange(str);    //交换数据
            System.out.println(name+"获取另一个线程的数据："+s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        Exchanger<String> ex=new Exchanger<String>();
        new Thread(new ExchangerTest(ex,"zhou","Hello")).start();
        new Thread(new ExchangerTest(ex,"yu","World")).start();
    }
}
