import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class AssignmentFileWriter {
    public static void main(String[] args){
        String fileName = "D:\\Java\\output.txt";
        String text;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the text to write to the file:");
        text = s.nextLine();
        try (FileWriter writer = new FileWriter(fileName)){
            writer.write(text);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
