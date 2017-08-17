package org.hejwo.poc.controller;

import org.hejwo.poc.SpringDataMongoVavrApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest(classes = {
        SpringDataMongoVavrApplication.class
    })
@RunWith(SpringJUnit4ClassRunner.class)
public class MainControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void should_returnSamplePersons() throws Exception {
        String response = mockMvc.perform(
            get("/sample-persons").accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse().getContentAsString();

        assertThatJson(response).isEqualTo("[{\"name\":\"Donald\",\"nickname\":\"Trump\",\"age\":61},{\"name\":\"George\",\"nickname\":\"Bush\",\"age\":65}]");
    }

}