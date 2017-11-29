@Pattern(regexp = "\\S+@\\S+", message = "{msg://Customer.email.validationMsg}")
@Column(name = "EMAIL")
protected String email;