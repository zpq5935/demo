package one.zpq.springbootdemo.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

//@Configuration
public class RedisConfig<RedisMessageListener> {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private RedisMessageListener messageListener;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @PostConstruct
    public void initRedisTemplate() {
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
    }

    @Bean
    public ThreadPoolTaskScheduler initThreadPoolTaskScheduler() {
        if (threadPoolTaskScheduler != null) {
            return threadPoolTaskScheduler;
        }
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(20);
        return threadPoolTaskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(threadPoolTaskScheduler);
        Topic topic = new ChannelTopic("topic1");
        container.addMessageListener((MessageListener) messageListener, topic);
        return container;
    }
    /**
     * 初始测试
     */
    // @Value(value = "127.0.0.1")
    // private String host;
    //
    // @Value(value = "6379")
    // private int port;
    //
    // @Bean("redisConnectionFactory")
    // public RedisConnectionFactory initRedisConnection() {
    // JedisPoolConfig poolConfig = new JedisPoolConfig();
    // poolConfig.setMaxIdle(10);
    // JedisConnectionFactory connectionFactory = new
    // JedisConnectionFactory(poolConfig);
    // RedisStandaloneConfiguration standaloneConfiguration =
    // connectionFactory.getStandaloneConfiguration();
    // standaloneConfiguration.setHostName(host);
    // standaloneConfiguration.setPort(port);
    // // standaloneConfiguration.setPassword(password);
    // return connectionFactory;
    // }
    //
    //
    // @Bean("redisTemplate")
    // public RedisTemplate<Object, Object> initRedisTemplate() {
    // RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    // RedisSerializer<String> stringSerializer =
    // redisTemplate.getStringSerializer();
    // redisTemplate.setKeySerializer(stringSerializer);
    // redisTemplate.setValueSerializer(stringSerializer);
    // redisTemplate.setConnectionFactory(initRedisConnection());
    // return redisTemplate;
    // }
    /**
     * 初始测试
     */

}
