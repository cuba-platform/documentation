@Pattern(regexp = "\\S+@\\S+", message = "{msg://com.company.demo.entity/Customer.email.validationMsg}")
@Column(name = "EMAIL")
protected String email;