package test;

import hprose.client.HproseHttpClient;

import java.io.IOException;

public class ValidateClient {
    public static void main(String[] args) throws IOException {
        HproseHttpClient client = new HproseHttpClient();
        client.useService("http://localhost:8080/HproseValidate");
        String result = null;

        try {
            result = (String) client.invoke("validate", new Object[]{"ljj", "123"});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println(result);
    }
}
