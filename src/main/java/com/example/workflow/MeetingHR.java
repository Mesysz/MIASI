package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeetingHR implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(MeetingHR.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String candidate1PickedDate = delegateExecution.getVariable("wybor_daty_1").toString();
        String candidate2PickedDate = delegateExecution.getVariable("wybor_daty_2").toString();
        String candidate3PickedDate = delegateExecution.getVariable("wybor_daty_3").toString();

        logger.info("Selected dates are:");
        logger.info("candidate 1 - " + candidate1PickedDate);
        logger.info("candidate 2 - " + candidate2PickedDate);
        logger.info("candidate 3 - " + candidate3PickedDate);

        logger.info("Executing meetings HR...");

    }
}
