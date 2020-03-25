package com.example.incrementator;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class IncrementatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenValidRequestThenShouldReturnIncrement() throws Exception {
		this.mockMvc.perform(
				post("/increment")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"request\":\"12 34\"}")
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("{\"response\":\"13 35\"}")));
	}

	@Test
	public void whenInvalidRequestThenShouldReturn502() throws Exception {
		this.mockMvc.perform(
				post("/increment")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"request\":\"12 34U\"}")
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().is5xxServerError());
	}
}
