import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class AssignmentFileReader{
    public static void main(String[] args) {
        String filePath = "D:\\Java\\input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String words[] = line.split("\\W+");
                for(String word: words){
                    if(word.equals("Java")){
                        count++;
                    }
                }

                System.out.println("Number of occurrences of the word 'Java' in the file: " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}