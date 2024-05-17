package com.example.sendmailcodeDecode;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SendMailCodeDecodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(SendMailCodeDecodeApplication.class, args);

//		System.out.println("START");

	}

//	@PreDestroy
//	public void onExit() {
//		System.out.println("###STOPing###");
//		try {
//			Thread.sleep(5 * 1000);
//		} catch (InterruptedException e) {
//			System.out.println("ERR");;
//		}
//		System.out.println("###STOP FROM THE LIFECYCLE###");
//	}

}
