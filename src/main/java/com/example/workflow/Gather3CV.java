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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gather3CV implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(Gather3CV.class);
    private final int cv1_arrive_delay = 1;
    private final int cv2_arrive_delay = 2;
    private final int cv3_arrive_delay = 3;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TimeUnit.SECONDS.sleep(cv1_arrive_delay);
        delegateExecution.setVariable("candidate_1", "Candidate 1");
        logger.info("CV arrived: Candidate 1");

        TimeUnit.SECONDS.sleep(cv2_arrive_delay);
        delegateExecution.setVariable("candidate_2", "Candidate 2");
        logger.info("CV arrived: Candidate 2");

        TimeUnit.SECONDS.sleep(cv3_arrive_delay);
        delegateExecution.setVariable("candidate_3", "Candidate 3");
        logger.info("CV arrived: Candidate 3");
    }
}
