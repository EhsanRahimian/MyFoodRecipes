package com.nicootech.myfoodrecipes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    private static AppExecutors instance;
    public static AppExecutors getInstance(){
        if (instance == null){
            instance = new AppExecutors();
        }
        return instance;
    }
    /*
     ScheduledExecutorService is the object that we want to use for background workers.
     we use it because we can do extra functionality to Executor
     ScheduledExecutorService is an ExecutorService which can schedule tasks to run after a delay,
     or to execute repeatedly with a fixed interval of time in between each execution.
     ScheduledExecutorService can schedule comments to run after getting delay.
     the same as Executor, its a cool way to have have automatic load balancing and submit
     writable test and background threads.Not: we can use them in main thread.
     */
    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(3);
    // we set pool of threads to 3 because we want to do all the work required in the application

    public ScheduledExecutorService networkIO(){
        return mNetworkIO;
    }
}
