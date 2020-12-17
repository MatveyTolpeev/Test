package com.semestrovaya.demo;

import com.semestrovaya.demo.controllers.CountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("user")
//@TestPropertySource("../../../../resources/application-test.properties")
public class ControllersTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CountController countController;

    @Test
    public void mainPageTest() throws Exception{

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }




    @Test
    public void DatabaseGetCountTest() throws Exception{

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(SecurityMockMvcResultMatchers.authenticated())
                .andExpect(xpath("//div[@id='count-container']/div").nodeCount(3));
    }




}
