package fooservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FooService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMessage")
    @RequestMapping(value = "/message")
    public String message(@RequestParam(name="delay", defaultValue="false", required=false) boolean delay) {
        return restTemplate.getForObject("http://bar-service/message?delay="+delay, String.class);
    }

    public String fallbackMessage(boolean delay) {
        return "Fallback only\n";
    }
}
