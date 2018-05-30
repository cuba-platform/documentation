@Override
public Map<String, Object> getFormResult() {
    HashMap<String, Object> processVariables = new HashMap<>();
    processVariables.put("automaticApprovalPeriod", makeTimerExpression(automaticApprovalPeriodField.getValue()));
    return processVariables;
}