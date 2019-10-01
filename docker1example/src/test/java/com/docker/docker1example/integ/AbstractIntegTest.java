package com.docker.docker1example.integ;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.docker.docker1example.Docker1exampleApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Docker1exampleApplication.class})
@WebAppConfiguration
@TestPropertySource(locations= "classpath:application.properties")
public abstract class AbstractIntegTest {
	/*@Autowired
	protected ObjectMapper mapper;*/
	
	protected MockMvc mockMvc;
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}
}
