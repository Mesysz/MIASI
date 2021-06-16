package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SendMessageRecruitingTaskSuccess implements JavaDelegate {
    Logger logger = LoggerFactory.getLogger(SendMessageRecruitingTaskSuccess.class);


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {


        logger.info("SendMessageRecruitingTaskSuccess");
        delegateExecution.setVariable("servicevar", "servicevalue");

        // Recipient's email ID needs to be mentioned.
        String to = "miasitest2021@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "miasitest2021@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("miasitest2021@gmail.com", "Miasi2021");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        int participants = 10;  // mocked, todo read from input

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(participants);

        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);

        List<LocalDate> listOfDates = Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Rekrutacja zakonczona powodzeniem");

            String content = "<h1>Proces rekruatacji zakończył się pomyślnie. Umowy zostały podpisane z przyszłymi pracowanikami.</h1>\n";
            StringBuilder sB = new StringBuilder(content);


            content = sB.toString();

            // Send the actual HTML message.
            message.setContent(
                    content,
                    "text/html; charset=UTF-8");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
