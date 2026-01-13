import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadingADireactory {
    public static void main(String[] args) throws InterruptedException  {
        ReadingADireactory read = new ReadingADireactory();     // how to read a directory
        read.extracted();
    }
    private void extracted() throws InterruptedException                
    {
                ExecutorService executorService = Executors.newFixedThreadPool(10);     //This creates a pool of threads that work concurrently and give result together not seperately
                executorService.submit(new MyTask("Task 1"));       // This enables the pool of thread to work

        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}
    class MyTask implements Runnable{
        private String name;

        public MyTask(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            File dir = new File("D:\\SampleTextFiles");     // using File class to read every files in the directory 
        File[] files = dir.listFiles();
            int totalCount =0;
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                     try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                String words[] = line.split("\\W+");
                for(String word: words){
                        count++;
                }
                        System.out.println("Total number of words in this file"+file+" is : " + count+". \nTask completed by :" + name);

                }
                totalCount+=count;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        }   
            }            

        } System.out.println("Required result:\nTotal number of words in all the files is : " + totalCount);
    }
}