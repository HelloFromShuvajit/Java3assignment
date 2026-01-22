import java.util.Scanner;

class Loggerclass {
    public static Loggerclass logger=null;
    private Loggerclass(){

    }   
    public static Loggerclass getInstance(){
        if(logger==null){
            logger =  new Loggerclass();
        }
        return logger;
    }
    public void log(String message){
        System.out.println(Thread.currentThread().getName()+" is using the Logger class, and the message is: "+ message);
    }

}
class LogWriterThread extends Thread{
    
    String msg;
    Loggerclass log =  Loggerclass.getInstance();
    public LogWriterThread(String message){
    msg = message;
    }
    @Override
    public void run(){

        log.log(msg);
    }
}
public class Logger{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first message: ");
        String message1 = sc.nextLine();

        System.out.println("Enter the second message: ");
        String message2 = sc.nextLine();

        System.out.println("Enter the third message: ");
        String message3 = sc.nextLine();

        System.out.println("Enter the forth message: ");
        String message4 = sc.nextLine();
        sc.close();

        LogWriterThread thread1 = new LogWriterThread(message1);
        LogWriterThread thread2 = new LogWriterThread(message2);
        LogWriterThread thread3 = new LogWriterThread(message3);
        LogWriterThread thread4 = new LogWriterThread(message4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}