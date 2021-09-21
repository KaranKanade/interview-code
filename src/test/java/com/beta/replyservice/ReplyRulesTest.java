package com.beta.replyservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.beta.replyservice.rules.ReplyRules;

@SpringBootTest
public class ReplyRulesTest {
	
	@Test
	public void reverseStringTest() {
		assertEquals(ReplyRules.apply("1-Test"), "tseT");
	}
	
	@Test
	public void md5HashTest() {
		assertEquals(ReplyRules.apply("2-Test"), "0cbc6611f5540bd0809a388dc95a615b");
	}
}