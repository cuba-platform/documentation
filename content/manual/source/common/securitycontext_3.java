Future<String> future = executor.submit(new SecurityContextAwareCallable<>(() -> {
    // business logic here
    return some_string;
}));