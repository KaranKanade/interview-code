package com.beta.replyservice;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestServiceControllerTest {

	@Autowired
	private ReplyController replyController;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
		assertThat(replyController).isNotNull();
	}

	@Test
	public void emptyMessage() {
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply",String.class)).contains("Message is empty");
	}
	
	@Test
	public void reverseStringRule() {
		String test = "1-kbzw9ru";
		
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply/"+test,String.class)).contains("ur9wzbk");
	}
	
	@Test
	public void md5HashRule() {
		String test = "2-kbzw9ru";
		
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply/"+test,String.class)).contains("0fafeaae780954464c1b29f765861fad");
	}
	
	@Test
	public void reverseStringMd5HashRule() {
		String test = "12-kbzw9ru";
		
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply/"+test,String.class)).contains("5a8973b3b1fafaeaadf10e195c6e1dd4");
	}
	
	@Test
	public void reverseStringReverseStringRule() {
		String test = "11-kbzw9ru";
		
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply/"+test,String.class)).contains("kbzw9ru");
	}
	
	@Test
	public void md5HashMd5HashRule() {
		String test = "22-kbzw9ru";
		
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply/"+test,String.class)).contains("e8501e64cf0a9fa45e3c25aa9e77ffd5");
	}
	
	@Test()
	public void invalidInput() {
		String test = "33-kbzw9ru";
		
		assertThat(this.restTemplate.
				getForObject("http://localhost:"+port+"/reply/"+test,String.class)).contains("Invalid Input");
	}

}
