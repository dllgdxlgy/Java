package lgy.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LGY
 * @create 2022-11-10 15:17
 */
public class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello,i am running!";
    }

    public static void main(String[] args) {
        CallerTask task = new CallerTask();
        FutureTask<String> futureTask = new FutureTask(task);
        new Thread(futureTask).start();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        try {

            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("nihh ");

    }
}

