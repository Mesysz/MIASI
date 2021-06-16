package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class PreparePreliminaryAgreementDelegate implements JavaDelegate {
    private final static Logger LOGGER = LoggerFactory.getLogger(PreparePreliminaryAgreementDelegate.class);
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String finestCandidate = (String)delegateExecution.getVariable("FinestCandidate");
        LOGGER.info("Preparing preliminary agreement for " + finestCandidate);
    }
}
