@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = TaskFeasibilityValidator.class)
public @interface CheckTaskFeasibility {

    String message() default "{msg://com.company.demo.entity/CheckTaskFeasibility.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}