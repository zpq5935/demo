package one.zpq;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class Main {
//    static String connectString = "192.168.202.138:2181";
    static String connectString = "127.0.0.1:2182";

    public static void main(String[] args) throws Exception {

        ZooKeeper zooKeeper = new ZooKeeper(connectString, 2000, event -> {
            System.out.println("recive event");
            System.out.println(event);
        });
        List<String> children = zooKeeper.getChildren("/", true);
        System.out.println(children);

    }
}
