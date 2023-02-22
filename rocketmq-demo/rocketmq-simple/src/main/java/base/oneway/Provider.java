package base.oneway;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 同步消息：等待broker返回结果才继续执行
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer sync_producer = new DefaultMQProducer("sync_producer");
        sync_producer.setNamesrvAddr("localhost:9876");
        sync_producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("oneway", "tag1", ("this is a sync messge" + String.valueOf(i)).getBytes(RemotingHelper.DEFAULT_CHARSET));
            sync_producer.sendOneway(message);
        }
        System.out.println("oneway over");

    }
}
