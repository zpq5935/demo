package one.zpq.springbootdemo.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String body = new String(message.getBody());
        String channel = new String(pattern);

        System.out.println("渠道：" + channel);
        System.out.println("消息体：" + body);
    }

}
