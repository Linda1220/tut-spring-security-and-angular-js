package demo.util;

import org.apache.el.lang.FunctionMapperImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by Linda on 24/02/16.
 */
public class NullAwareBeanUtilTest {

    @Test
    public void testCopyProperties() throws Exception {

    }

    @Test
    public void testAsynchronous() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        System.out.println("Ready to start");

        Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(10000L);
                    System.out.println("sub task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Callable<Integer> integerCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(10000L);
                System.out.println("sub task");
                return 1;
            }
        };


        Future<Integer> submit = executorService.submit(integerCallable);

        Map<Future<Integer>, Function> eventsloop = new HashMap<>();

        Function<Integer, Integer> function = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer o) {
                return 5;
            }
        };
        eventsloop.put(submit, function);



        boolean run = true;

        do {



            Iterator<Future<Integer>> iterator = eventsloop.keySet().iterator();


            while (iterator.hasNext()) {
                Future<Integer> next = iterator.next();
                if (next.isDone()) {
                    Function function1 = eventsloop.get(next);
                    Integer apply = (Integer) function1.apply(next.get());
                    System.out.println(apply);
                    iterator.remove();
                }
            }

            if(eventsloop.isEmpty()) {
                run = false;
            }

        } while(run);
        System.out.println("Ready to stop");


    }
}