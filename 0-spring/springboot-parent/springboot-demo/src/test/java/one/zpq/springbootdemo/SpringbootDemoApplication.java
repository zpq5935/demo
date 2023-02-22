package one.zpq.springbootdemo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {SpringbootDemoApplication.class})
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class,args);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    // @Test
    public void testRedisTemplate() throws UnsupportedEncodingException {
        System.out.println(1);
        // redisTemplate.opsForValue().set(new String("key1".getBytes(), "gbk"),
        // new String("key1-value".getBytes(), "gbk"));
        System.out.println(redisTemplate.opsForValue().get("key1"));
        System.out.println(2);
    }

    public void testRedisCallback() {

    }

    public void testSessionCallback() {

    }

    /**
     * 测试Redis对数据的操作
     */
    // @Test
    public void testRedisOps() {
        redisTemplate.opsForSet().add("set1", "val1", "val2");
    }

    /**
     * 测试Redis对事务的支持
     */
    // @Test
    public void testRedisTransaction() {
        // redisTemplate.opsForValue().set("key1", "value1");
        // redisTemplate.execute(new SessionCallback<Object>() {
        // @Override
        // public Object execute(RedisOperations operations) throws
        // DataAccessException {
        // // TODO Auto-generated method stub
        // return null;
        // }
        // });
       /* redisTemplate.execute((RedisOperations redisOperations) -> {
            redisOperations.watch("key1");// 监听键为key1的
            redisOperations.multi();// 开启事务
            return null;
        });*/
    }

    @Test
    public void testRedisLua() {
        DefaultRedisScript<String> script = new DefaultRedisScript<>();
        script.setScriptText("return 'hello zpq'");
        script.setResultType(String.class);
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        Object result = redisTemplate.execute(script, stringSerializer, stringSerializer, null);
        System.out.println("testRedisLua:" + result);
    }

    @Test
    public void testRedisLua2() {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        StringBuilder luaScriptStr = new StringBuilder();
        luaScriptStr.append("redis.call('set',KEYS[1],ARGV[1])\n")
                .append("redis.call('set',KEYS[2],ARGV[2])\n")
                .append("local str1 = redis.call('get',KEYS[1])\n")
                .append("local str2 = redis.call('get',KEYS[2])\n")
                .append("if str1==str2 then\n")
                .append("return 1\n")
                .append("end\n")
                .append("return 0\n");
        script.setScriptText(luaScriptStr.toString());
        script.setResultType(Long.class);
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        ArrayList<String> keyList = new ArrayList<>();
        keyList.add("key1");
        keyList.add("key2");
        Object result = redisTemplate.execute(script, stringSerializer, stringSerializer, keyList, "val", "val2");
        System.out.println("testRedisLua2:" + result);
    }

}