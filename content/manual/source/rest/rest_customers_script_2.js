function loadCustomers() {
    $.get({
        url: 'http://localhost:8080/app/rest/v2/entities/sales$Customer?view=_local',
        headers: {
            'Authorization': 'Bearer ' + oauthToken,
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function (data) {
            $('#customers').show();
            $.each(data, function (i, customer) {
                $('#customersList').append("<li>" + customer.name + " (" + customer.email + ")</li>");
            });
        }
    });
}