package org.example.camunda.process.solution.service;

import io.camunda.zeebe.client.ZeebeClient;
import org.example.camunda.process.solution.ProcessConstants;
import org.example.camunda.process.solution.ProcessVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZeebeService {
  @Autowired private ZeebeClient zeebe;

  public String startProcess(ProcessVariables variables) {
    final var processInstanceResult =
        zeebe
            .newCreateInstanceCommand()
            .bpmnProcessId(ProcessConstants.BPMN_PROCESS_ID)
            .latestVersion()
            .variables(variables)
            .withResult()
            .fetchVariables(ProcessConstants.VARIABLE_NAME_RESULT)
            .send()
            .join();

    final var processVariables = processInstanceResult.getVariablesAsType(ProcessVariables.class);
    return processVariables.getResult();
  }

  public String startProcess(String... args) {
    String businessKey = args[0];
    String expression = args[1];
    final var variables =
        new ProcessVariables().setBusinessKey(businessKey).setExpression(expression);

    // TODO: How do we update the DMN Decision with the expression??

    return startProcess(variables);
  }
}
