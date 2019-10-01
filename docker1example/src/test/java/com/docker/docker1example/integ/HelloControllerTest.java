package com.docker.docker1example.integ;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

public class HelloControllerTest extends AbstractIntegTest {
	@Test
	public void testSayHello() throws Throwable {
		ResultActions resultActions = mockMvc.perform(
				get("/hello").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.headers(getHttpHeaders(Collections.emptyMap()))
				.secure(false)).andDo(print());
		
		resultActions.andExpect(status().isOk());
	}
	
	private HttpHeaders getHttpHeaders(Map<String, String> headerMap) {
		HttpHeaders httpHeaders = new HttpHeaders();
		headerMap.forEach((key, value)-> httpHeaders.add(key, value));
		return httpHeaders;
	}
}
