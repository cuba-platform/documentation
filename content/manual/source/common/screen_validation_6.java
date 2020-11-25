@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EventDateValidator.class)
public @interface EventDate {

    String message() default "The Start date must be earlier than the End date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}