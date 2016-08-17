package barservice;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarService {

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/message")
    public String message(@RequestParam(name="delay", defaultValue="false", required=false) boolean delay) {
        if (delay) {
            try {
                Thread.sleep(RandomUtils.nextInt(1250));
            }
            catch (InterruptedException e) {
            }
        }
        return "Result from port "+String.valueOf(port)+"\n";
    }
}
