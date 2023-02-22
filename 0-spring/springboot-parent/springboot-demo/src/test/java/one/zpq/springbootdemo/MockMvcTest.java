package one.zpq.springbootdemo;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import one.zpq.springbootdemo.controller.UserController;

public class MockMvcTest {

    @Test
    public void test1() {
        UserController controller = new UserController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        
    }
}
