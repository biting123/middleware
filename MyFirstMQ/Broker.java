package MyFirstMQ;

//订阅系统
import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    private final static int MAX_SIZE=10;

    private static ArrayBlockingQueue<String> postqueue =new ArrayBlockingQueue<>(MAX_SIZE) ;

    public static void inpost(String person){
        if(postqueue.size()<MAX_SIZE){
            postqueue.offer(person);
            System.out.println("订阅消息已存入，订阅人为"+person);
        }
        else{
            System.out.println("订阅人数已达到最大，无法订阅");
        }
    }

    public  static void outpost(){
        String person=postqueue.poll();
        if(person!=null){
        System.out.println("订阅图书已送达至"+person+"\t还有"+postqueue.size()+"订阅者");
        }
        else{
            System.out.println("订阅人数为零");
        }
    }
}
