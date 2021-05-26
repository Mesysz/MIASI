package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class PickBestCandidates implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(PickBestCandidates.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int participants = 3;

        Random random = new Random();
        int selectedParticipantId = random.nextInt(participants - 1) + 1;

        logger.info("Selected participant is participant " + selectedParticipantId);
        delegateExecution.setVariable("selectedParticipantId", selectedParticipantId);

    }
}
