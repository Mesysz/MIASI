package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignContract implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(SignContract.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Podpisuję kontrakt.");
    }
}
