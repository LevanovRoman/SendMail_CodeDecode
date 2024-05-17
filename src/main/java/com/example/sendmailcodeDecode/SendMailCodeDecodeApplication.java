package com.example.sendmailcodeDecode;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class SendMailCodeDecodeApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("$(spring.mail.username)")
	private String fromEmailId;

	LocalDateTime startDateTime;

	public void sendEmail(String recipient, String body, String subject){

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom(fromEmailId);
		simpleMailMessage.setTo(recipient);
		simpleMailMessage.setText(body);
		simpleMailMessage.setSubject(subject);

		javaMailSender.send(simpleMailMessage);

	}

	public static void main(String[] args) throws AWTException, IOException {

		SpringApplication.run(SendMailCodeDecodeApplication.class, args);

		System.out.println("START");

//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		Rectangle screenRectangle = new Rectangle(screenSize);
//		Robot robot = new Robot();
//		BufferedImage image = robot.createScreenCapture(screenRectangle);
//		ImageIO.write(image, "png", new File("screenShot.png"));

	}
	@PostConstruct
	public void onStart() throws Exception {
		System.out.println("BEGIN");
		startDateTime = LocalDateTime.now();
		LocalDate dateNow = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		sendEmail("levanovroman2016@yandex.ru", "Компьютер включен:\n дата:" + dateNow +
				"\nвремя:  " + timeNow, "Test Subject");

//		givenMainScreen_whenTakeScreenshot_thenSaveToFile();
	}

	@PreDestroy
	public void onExit() throws Exception {
		System.out.println("###STOPing###");

		LocalDateTime finishDateTime = LocalDateTime.now();

		long diffHours = ChronoUnit.HOURS.between(startDateTime, finishDateTime);
		long diffMinutes = ChronoUnit.MINUTES.between(startDateTime, finishDateTime);

		String body = "Компьютер выключен\nВремя работы:  " + diffHours +" часов  " + (diffMinutes - diffHours * 60) + " минут";

		sendEmail("levanovroman2016@yandex.ru", body, "Test Subject");
//		givenMainScreen_whenTakeScreenshot_thenSaveToFile();
	}

//	public void givenMainScreen_whenTakeScreenshot_thenSaveToFile() throws Exception {
//		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//		BufferedImage capture = new Robot().createScreenCapture(screenRect);
//
//		File imageFile = new File("single-screen.bmp");
//		ImageIO.write(capture, "bmp", imageFile );
//	}

}
