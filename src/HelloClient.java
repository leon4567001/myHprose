import hprose.client.HproseHttpClient;

import java.io.IOException;

public class HelloClient {
    public static void main(String[] args) throws IOException {
        HproseHttpClient client = new HproseHttpClient();
        client.useService("http://localhost:8080/Hello");
        String result = null;

        try {
            result = (String) client.invoke("sayHello", new Object[] { "Hprose" });
            System.out.println(result);
            result = (String) client.invoke("sayHello", new Object[] { "中国" });
            System.out.println(result);
            System.out.println(client.invoke("add",new Object[]{115,316}));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
