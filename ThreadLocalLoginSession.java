import java.util.HashMap;
import java.util.Map;

public class ThreadLocalLoginSession{
    
    public static ThreadLocal<Map<Integer, String>> UserMapLocalThread = ThreadLocal.withInitial(HashMap::new);
    public static void setSessiondata(int userID, String userName){
        Map<Integer,String> data = UserMapLocalThread.get();
        data.put(userID,userName);
    }
    public static Map<Integer,String> getSessiondata(){
        return UserMapLocalThread.get();
    }
    public static void main(String[] args){
        Thread thread1 = new Thread(()->{

            try {
                setSessiondata(1,"Shuvajit");
                System.out.println(Thread.currentThread().getName()+" Session data: "+ getSessiondata());
            } catch (Exception e) {
                e.printStackTrace();    
            }
        });
        Thread thread2 = new Thread(() ->{
     try {
                setSessiondata(2,"Deep");
                System.out.println(Thread.currentThread().getName()+" Session data: "+ getSessiondata());
            } catch (Exception e) {
                e.printStackTrace();    
            }
    });
    Thread thread3 = new Thread(()->{

            try {
                setSessiondata(3,"Ankan");
                System.out.println(Thread.currentThread().getName()+" Session data: "+ getSessiondata());
            } catch (Exception e) {
                e.printStackTrace();    
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}