var oauthToken = null;
function login() {
    var userLogin = $('#loginField').val();
    var userPassword = $('#passwordField').val();
    $.post({
        url: 'http://localhost:8080/app/rest/v2/oauth/token',
        headers: {
            'Authorization': 'Basic Y2xpZW50OnNlY3JldA==',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        dataType: 'json',
        data: {grant_type: 'password', username: userLogin, password: userPassword},
        success: function (data) {
            oauthToken = data.access_token;
            $('#loggedInStatus').show();
            $('#loginForm').hide();
            loadCustomers();
        }
    })
}

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