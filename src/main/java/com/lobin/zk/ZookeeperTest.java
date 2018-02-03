package com.lobin.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author Lobin.Tong
 * @date 2018/2/3
 */
public class ZookeeperTest {
    private static final String connStr="192.168.0.100:2181";
    private static final int sessionTimeout=20000;
    private static ZooKeeper zkClient=null;
    public static void main(String[] args) {
        try {
            zkClient =new ZooKeeper(connStr, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    try {
                        System.out.println("----test---->");
                       List<String> children= zkClient.getChildren("/",true);
                       System.out.println(children);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
