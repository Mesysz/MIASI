package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class SendFailInfoDelegate implements JavaDelegate {
    private final static Logger LOGGER = Logger.getLogger("YES");
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String badCandidate = (String)delegateExecution.getVariable("BadCandidate");
        MailSender mailSender = new MailSender();
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Niestety ").append(badCandidate).append(", negatywnie przeszedłeś ten proces!</h1>");
        mailSender.sendMail("Negative recrutation " + badCandidate, sb.toString());
        LOGGER.info("Sending fail info for " + badCandidate);
    }
}
