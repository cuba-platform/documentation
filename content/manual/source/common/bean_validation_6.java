@Pattern(regexp = "\\S+@\\S+", message = "Invalid email: ${validatedValue}, pattern: {regexp}")
@Column(name = "EMAIL")
protected String email;