package com.xuesran.chapter07.interceptor;

import java.util.List;
import java.util.concurrent.Callable;

public class LoggingMemoryDatabase extends MemoryDatabase {

    private class LoadMethodSuperCall implements Callable{
        private final String info;

        private LoadMethodSuperCall(String info) {
            this.info = info;
        }

        public Object call() throws Exception {
            return null;
        }
    }

    @Override
    public List<String> load(String info) {
        return LoggerInterceptor.log(new LoadMethodSuperCall(info));
    }
}
