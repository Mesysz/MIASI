package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class SendSuccessfulInfoWithOfferDelegate implements JavaDelegate {
    private final static Logger LOGGER = Logger.getLogger("YES");
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String finestCandidate = (String)delegateExecution.getVariable("FinestCandidate");
        MailSender mailSender = new MailSender();
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Gratulujemy ").append(finestCandidate).append(", pomyślnie przeszedłeś ten proces!</h1>");
        mailSender.sendMail("Positive recrutation " + finestCandidate, sb.toString());
        LOGGER.info("Sending successful info with offer for " + finestCandidate);
    }
}
