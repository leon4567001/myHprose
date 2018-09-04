
package test;

import hprose.client.HproseClient;
import java.util.concurrent.CountDownLatch;

public class TimePushClient {
    public static void main(String[] args) throws Exception {
        final HproseClient client = HproseClient.create("tcp://192.168.1.84:8080");
        final CountDownLatch counter = new CountDownLatch(5);
        client.subscribe("Hello", (String time) -> {
            if (counter.getCount() > 0) {
                counter.countDown();
                System.out.println(time);
            } else {
                client.unsubscribe("Hello");
            }
        }, String.class);
        Thread.sleep(120000);//2m退出
    }
}
