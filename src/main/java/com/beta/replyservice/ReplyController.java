package com.beta.replyservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beta.replyservice.rules.ReplyRules;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ResponseEntity<ReplyMessage> replying(@PathVariable String message) {
		
		String result = ReplyRules.apply(message);
		
		return new ResponseEntity<ReplyMessage>(new ReplyMessage(result), HttpStatus.OK);
	}
}