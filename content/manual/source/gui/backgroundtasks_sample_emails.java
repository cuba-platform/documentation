import com.haulmont.cuba.gui.backgroundwork.BackgroundWorkProgressWindow;

public class StudentBrowse extends StandardLookup<Student> {

    @Inject
    private Table<Student> studentsTable;

    @Inject
    private EmailService emailService;

    @Subscribe("studentsTable.sendEmail")
    public void onStudentsTableSendEmail(Action.ActionPerformedEvent event) {
        Set<Student> selected = studentsTable.getSelected();
        if (selected.isEmpty()) {
            return;
        }
        BackgroundTask<Integer, Void> task = new EmailTask(selected);
        BackgroundWorkProgressWindow.show(task, // <1>
                "Sending reminder emails", "Please wait while emails are being sent",
                selected.size(), true, true // <2>
        );
    }

    private class EmailTask extends BackgroundTask<Integer, Void> { // <3>
        private Set<Student> students; // <4>

        public EmailTask(Set<Student> students) {
            super(10, TimeUnit.MINUTES, StudentBrowse.this); // <5>
            this.students = students;
        }

        @Override
        public Void run(TaskLifeCycle<Integer> taskLifeCycle) throws Exception {
            int i = 0;
            for (Student student : students) {
                if (taskLifeCycle.isCancelled()) { // <6>
                    break;
                }
                emailService.sendEmail(student.getEmail(), "Reminder", "Don't forget, the exam is tomorrow",
                        EmailInfo.TEXT_CONTENT_TYPE);

                i++;
                taskLifeCycle.publish(i); // <7>
            }
            return null;
        }
    }
}