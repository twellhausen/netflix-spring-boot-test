package testclient;

import static java.util.stream.IntStream.range;

import org.springframework.web.client.RestTemplate;

public class TestClient {

    public static void main(String[] args) {
        range(0, 50).forEach(i -> {
            new Thread(TestClient::call).start();
        });
    }

    public static void call() {
        while (true) {
            try {
                new RestTemplate().getForObject("http://localhost:8080/message?delay=true", Void.class);
            }
            catch (Exception e) {
            }
        }
    }
}
