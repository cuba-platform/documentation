public String run(TaskLifeCycle<Integer> taskLifeCycle) {
    for (int i = 0; i < 9_000_000; i++) {
        if (taskLifeCycle.isCancelled()) {
            log.info(" >>> Task was cancelled");
            break;
        } else {
            log.info(" >>> Task is working: iteration #" + i);
        }
    }
    return "Done";
}