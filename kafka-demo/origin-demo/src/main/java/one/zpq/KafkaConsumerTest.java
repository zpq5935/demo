package one.zpq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerTest implements Runnable {

    private final KafkaConsumer<byte[], byte[]> consumer;
    private ConsumerRecords<byte[], byte[]> msgList;
    private final String[] topics;
    private static final String GROUPID = "groupA1";

    public KafkaConsumerTest(String[] topicNames) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", GROUPID);
//        props.put("enable.auto.commit", "true");
        props.put("enable.auto.commit", "false");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "5000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer(props);
        this.topics = topicNames;
        this.consumer.subscribe(Arrays.asList(topics));
    }

    @Override
    public void run() {
        System.out.println("---------开始消费---------");
        try {
            for (; ; ) {
                msgList = consumer.poll(1000);
                if (null != msgList && msgList.count() > 0) {
                    System.out.println("size:" + msgList.count());
                    for (ConsumerRecord record : msgList) {
                        System.out.println(String.format("Topic=%s,partition=%s,key=%s,value=%s,offset=%s", record.topic(), record.partition(), record.key(), record.value(), record.offset()));
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public static void main(String args[]) {
        KafkaConsumerTest test1 = new KafkaConsumerTest(new String[]{"quickstart-events", "KAFKA_TEST"});
        Thread thread1 = new Thread(test1);
        thread1.start();
    }
}
