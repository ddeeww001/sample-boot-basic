package th.mfu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // การประกาศว่า file นี้เป็น controller
@RequestMapping("/api") // ใช้ขึ้นตั้นเวลาเรียกใช้ method -> http://localhost:808/api/<methodname>
public class HelloController {

    @GetMapping("/hello/{name}") // /api/hello
    String hello(@PathVariable String name) {
        return "Hello World! " + name + "!";

    }

    @GetMapping("/hi")
    String hi() {
        return "Hi";

    }

}
