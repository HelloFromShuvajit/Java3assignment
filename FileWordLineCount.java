import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWordLineCount {
    int countWords = 0;
    int countLines = 0;
    String filepath;
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        FileApp app = new FileApp();
        String[] filePaths = {"D:\\SampleTextFiles\\file1.txt","D:\\SampleTextFiles\\file2.txt","D:\\SampleTextFiles\\file3.txt"};
        app.processFiles(filePaths);                // this sends the filepaths to FileApp 
    }
    public FileWordLineCount(String filepath,int Words, int Lines){
            this.countLines= Lines;
            this.countWords= Words;
            this.filepath= filepath;
        }
    }
    class FileApp{
        public void processFiles(String[] filePaths) throws InterruptedException, ExecutionException{
            FileProcessor path =  new FileProcessor();
            List<CompletableFuture<FileWordLineCount>> futures = new ArrayList<>();         // This is a list of CompleteableFuture of FileWordLineCount, holds the values of lines words as FileWordLineCount needs 
            for(String filepath :filePaths){
                futures.add(path.processfile(filepath)); // This adds the CompleteableFuture objs
            }
            System.out.println("    Summery Report:     ");
            for(CompletableFuture <FileWordLineCount> file : futures){  // This loops gets every Filewordlinecount objs 
                FileWordLineCount reportFile =  file.get();     // This completes the completeablefuture
                System.out.println("File: "+reportFile.filepath+"\nNo of words: "+reportFile.countWords+"\nNo of lines: "+reportFile.countLines);
            }
        }
}
class FileProcessor{
    public CompletableFuture<FileWordLineCount> processfile(String filepath){
        
        CompletableFuture<FileWordLineCount> future = null;
        try {
            future = CompletableFuture.supplyAsync(() ->{               // future gets the FileWordLineCount obj after processing 
           BufferedReader reader = null;
           try {
            reader = new BufferedReader(new FileReader(filepath));
           } catch (FileNotFoundException e) {
            e.printStackTrace();
           }
           String line;
           int countWords= 0;
           int countLines = 0;
           try {
            while ((line=reader.readLine()) != null) {
                    countLines++;
                    String[] words = line.split("\\W+");
                    for(String word : words){
                        countWords++;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
            FileWordLineCount FWL = new FileWordLineCount(filepath,countWords,countLines);      // A FileWordLineCount obj is created
            return FWL;});
            future.get();               // This gets the value for task that has been assigned to future, a CompleteableFuture
        } catch (Exception e) {
            System.out.println("Error in fileprocessing.");
        }
        return future;          // This returns the future to FileApp
    }
}
