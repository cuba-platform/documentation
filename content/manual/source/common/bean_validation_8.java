public class TaskFeasibilityValidator implements ConstraintValidator<CheckTaskFeasibility, Task> {

    @Override
    public void initialize(CheckTaskFeasibility constraintAnnotation) {
    }

    @Override
    public boolean isValid(Task value, ConstraintValidatorContext context) {
        Date now = AppBeans.get(TimeSource.class).currentTimestamp();
        return !(value.getDueDate().before(DateUtils.addDays(now, 3)) && value.getProgress() < 90);
    }
}