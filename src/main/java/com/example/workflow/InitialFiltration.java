package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class InitialFiltration implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(InitialFiltration.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Initial filtration");
    }
}