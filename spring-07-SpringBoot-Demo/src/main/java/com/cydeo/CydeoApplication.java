package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplication {

	public static void main(String[] args) {//save the class in the base package bcuz it includes the @componentscan

		Comment comment  = new Comment();
		comment.setAuthor("Johnson");
		comment.setText("Spring Framework");

		ApplicationContext container = SpringApplication.run(CydeoApplication.class, args);

		CommentService commentService = container.getBean(CommentService.class);
		commentService.publishComment(comment);

		commentService.printConfigData();
		commentService.printDbConfigData();
	}



}
