package com.zr.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zr.demo.model.Book;
import com.zr.demo.model.User;
import com.zr.demo.producer.IMessageProducerService;
import com.zr.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "main接口")
@RestController
@RequestMapping("/mainController")
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	private IMessageProducerService messageProducer;

	@RequestMapping(value = "/abc")
	public User home() {
		User user = userService.selectUserById(1);
		return user;
	}

	@ApiOperation(value = "消息队列" ,  notes="队列使用")
    @RequestMapping(value="/q",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
	public void q() {
		for (int x = 0; x < 5; x++) {
			this.messageProducer.sendMessage("study - " + x);
		}
		return;
	}

	@Resource
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/e")
	public void testSendMail() {
		SimpleMailMessage message = new SimpleMailMessage(); // 要发送的消息内容
		message.setFrom("wj1425203342@163.com");
		message.setTo("1425203342@qq.com");
		message.setSubject("测试邮件）");
		message.setText("好好学习，天天向上");
		this.javaMailSender.send(message);
	}
	
	@Resource
    private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping(value = "/redis")
	public void redis2() {
		Book book = new Book();
		book.setName("java 从入门到放弃");
		book.setPrice(11.0);
		this.redisTemplate.opsForValue().set(new String("study"), book);
		Book book2 = (Book) this.redisTemplate.opsForValue().get("study");
		System.out.println(book2.getName()+" "+book2.getPrice());
	}
	
	@RequestMapping(value = "/r")
	public List<User> redis() {
		return userService.selectAllUsers();
	}
}