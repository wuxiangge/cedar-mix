package com.cedar.concurrency.art;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author zhangnan
 * @date 2021/1/22 16:18
 */
public class ConnectionPool {


    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }


    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }


    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long futureTime = System.currentTimeMillis() + mills;

                long remaining = mills;

                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = futureTime - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
