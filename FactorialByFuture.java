import java.util.*;
import java.util.concurrent.*;
public class FactorialByFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        int number;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Task());
        System.out.println("Thread is doing the calculation, please wait.");
        int result =  future.get();
    System.out.println("factorial of is " +result);
    executorService.shutdown();
    }
}
class Task implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of which you want to have factorial: ");
        int number = sc.nextInt();
                sc.nextLine();
        int result = factorial(number);

        return result;
    }
    int factorial(int number) throws Exception{
        int factorial = 1;
            if (number == 1 || number == 0) {
                return factorial;
            }
            else if (number > 1 ) {
                int fact = factorial(number - 1);
                factorial= fact* number;
            }
            return factorial;
    }
}