import java.util.Random;
import java.util.*;
public class Runners {
        public static void main(String[] args) throws InterruptedException{

                Runner runnerA = new Runner("RunnerA");
                Thread threadA = new Thread(runnerA);
                
                Runner runnerB = new Runner("RunnerB");
                Thread threadB = new Thread(runnerB);
                
                Runner runnerC = new Runner("RunnerC");
                Thread threadC = new Thread(runnerC);
                threadC.start();
                threadB.start();
                threadA.start();
                threadA.join(); // join() stops the others threads while one running
                threadB.join();
                threadC.join();
        }
}
class Runner implements Runnable{
    String name;
    int distance=0;
    int trackDistance = 100;
    private Random random = new Random();
    public Runner(String name){
        this.name = name;
    }
    @Override 
    public void run()
    {
        while(distance < trackDistance){
        try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int coverDis = random.nextInt(20);
        distance +=coverDis;
        if(distance > trackDistance){
            distance = trackDistance;
        }
                    System.out.println("Distance covered by  " + name+" is" +distance );

        if(distance >= trackDistance)
        {
            System.out.println(name + " wins the race." );
                            System.exit(0); //This stops the whole program, which was needed to see which thread finishes the program 1st.

            
        }
  
        }

    }
}
