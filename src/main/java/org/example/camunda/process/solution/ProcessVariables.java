package org.example.camunda.process.solution;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(Include.NON_NULL)
public class ProcessVariables {

  private String businessKey;
  private String result;
  private String expression;

  public String getBusinessKey() {
    return businessKey;
  }

  public ProcessVariables setBusinessKey(String businessKey) {
    this.businessKey = businessKey;
    return this;
  }

  public String getResult() {
    return result;
  }

  public ProcessVariables setResult(String result) {
    this.result = result;
    return this;
  }

  public String getExpression() {
    return expression;
  }

  public ProcessVariables setExpression(String expression) {
    this.expression = expression;
    return this;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(
        this,
        new MultilineRecursiveToStringStyle() {
          public ToStringStyle withShortPrefixes() {
            this.setUseShortClassName(true);
            this.setUseIdentityHashCode(false);
            return this;
          }
        }.withShortPrefixes());
  }
}
