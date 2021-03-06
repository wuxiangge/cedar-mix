package com.cedar.concurrency.art;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2021/1/22 16:22
 */
public class ConnectionDriver {


    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("commit")) {
                TimeUnit.SECONDS.sleep(1);
            }
            return null;
        }
    }


    public static final Connection createConnection() {

        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
    }


}
