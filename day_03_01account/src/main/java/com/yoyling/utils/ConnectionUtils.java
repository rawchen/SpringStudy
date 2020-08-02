package com.yoyling.utils;


import java.sql.Connection;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {

    }

}
