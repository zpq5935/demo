package order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class Producer {
	public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException,
			InterruptedException, MQBrokerException {
		DefaultMQProducer producer = new DefaultMQProducer("async");
		producer.setNamesrvAddr("localhost:9876");
		producer.setRetryTimesWhenSendAsyncFailed(0);
		producer.start();
		for (int i = 0; i < 10; i++) {
			Message message = new Message("async", "tag1",
					("this is a async message" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
			producer.send(message, new MessageQueueSelector() {

				@Override
				public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
					int index = (int) arg;
					return mqs.get(index % mqs.size());
				}
			}, 2);
		}
	}
}
