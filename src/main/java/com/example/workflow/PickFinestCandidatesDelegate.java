package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PickFinestCandidatesDelegate implements JavaDelegate {
    private final static Logger LOGGER = LoggerFactory.getLogger(PickFinestCandidatesDelegate.class);
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("FinestCandidate", "Tom");
        delegateExecution.setVariable("BadCandidate", "Bob");
        LOGGER.info("Picking Candidates");
    }
}
