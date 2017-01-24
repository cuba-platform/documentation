@NotNull
@Size(min = 2, max = 14)
@Pattern(regexp = "\\d+")
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface ValidProductCode {
    String message() default "{msg://om.company.demo.entity/ValidProductCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}