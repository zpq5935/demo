package base.async;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class Producer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("async");
        producer.setNamesrvAddr("localhost:9876");
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.start();
        for(int i=0;i<10;i++){
            Message message = new Message("async","tag1",("this is a async message"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("asynMessage Result: " + sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.err.println("asynMessage Result:"+e);
                }
            });
        }
    }
}
