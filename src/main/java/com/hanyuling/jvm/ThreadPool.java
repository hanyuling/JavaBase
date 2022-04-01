package com.hanyuling.jvm;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPool {


    private static final ThreadPoolExecutor executror = new ThreadPoolExecutor(1, 10, 1000, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    private static final Random random = new Random();

    private static final ListeningExecutorService service = MoreExecutors.listeningDecorator(executror);


    public static void main(String[] args) {

        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.supplyAsync(() -> "a", executror)
                        .whenComplete((r, e) -> {
                            System.out.println("aaa");
                        }).exceptionally(e -> {
                            System.out.println("bbbb");
                            return "";
                        });


        executror.shutdown();

    }
}
