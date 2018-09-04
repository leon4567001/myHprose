package test;

import hprose.server.HproseTcpServer;
import hprose.util.concurrent.Timer;

import java.io.IOException;
import java.net.URISyntaxException;

public class TimePushServer {
    public static void main(String[] args) throws URISyntaxException, IOException {
        HproseTcpServer server = new HproseTcpServer("tcp://192.168.1.84:8080");
//        server.publish("time");
        server.publish("Hello");
        server.start();
//        Timer timer = new Timer(() -> server.push("time", Calendar.getInstance()));
        Timer timer = new Timer(() -> server.push("Hello", "hello ljj"));
        timer.setInterval(10000);//间隔10s
        System.out.println("START");
        System.in.read();
        server.stop();
        System.out.println("STOP");
    }
}
