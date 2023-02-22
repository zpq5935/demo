package base.sync;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 同步消息：等待broker返回结果才继续执行
 */
public class Provider {
	public static void main(String[] args) throws Exception {
		DefaultMQProducer sync_producer = new DefaultMQProducer("sync_producer4");
		sync_producer.setNamesrvAddr("192.168.231.128:9876;192.168.231.129:9876");
		sync_producer.setVipChannelEnabled(false);
		sync_producer.start();
		for (int i = 0; i < 1; i++) {
			Message message = new Message("sync", "tag1",
					("this is a sync messge" + String.valueOf(i)).getBytes(RemotingHelper.DEFAULT_CHARSET));
			SendResult result = sync_producer.send(message);
			System.out.println("synMessage Result: " + result);
		}
		sync_producer.shutdown();
	}
}
