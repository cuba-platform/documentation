public class EventDateValidator implements ConstraintValidator<EventDate, Event> {
    @Override
    public boolean isValid(Event event, ConstraintValidatorContext context) {
        if (event == null) {
            return false;
        }

        if (event.getStartDate() == null || event.getEndDate() == null) {
            return false;
        }

        return event.getStartDate().before(event.getEndDate());
    }
}