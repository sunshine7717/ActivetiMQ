package com.lanou.message.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.message.service.EnqueueService;

@Controller
public class EnqueueController {

	@Autowired
	EnqueueService service;

	@RequestMapping("/enqueue")
	@ResponseBody
	public String enqueue() {
		service.sendMessage("好帅");
		return "enqueue";
	}
}
