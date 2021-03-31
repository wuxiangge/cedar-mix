package com.cedar.concurrency.art;

import java.util.concurrent.*;

/**
 * @author zhangnan
 * @date 2021/3/30 10:39
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) throws Exception {

        // 首先我们创建了一个线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        // futureTask 我们叫做线程任务，构造器的入参是 Callable
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                // 返回一句话
                return "我是子线程" + Thread.currentThread().getName();
            }
        });
        // 把任务提交到线程池中，线程池会分配线程帮我们执行任务
        executor.submit(futureTask);
        // 得到任务执行的结果
        String result = (String) futureTask.get();

        System.out.println("result is " + result);
    }
}
