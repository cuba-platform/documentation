var oauth2Token = null;

function tryToLoginWithFacebook() {
    var urlHash = window.location.hash;

    if (urlHash && urlHash.indexOf('&code=') >= 0) {
        console.log("Try to login to CUBA REST-API!");

        var urlCode = urlHash.substring(urlHash.indexOf('&code=') + '&code='.length);
        console.log("Facebook code: " + urlCode);

        history.pushState("", document.title, window.location.pathname);

        $.post({
            url: '/app/rest/facebook/login',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            dataType: 'json',
            data: {code: urlCode},
            success: function (data) {
                oauth2Token = data.access_token;

                loadUsers();
            }
        })
    }
}

function loadUsers() {
    $.get({
        url: '/app/rest/v2/entities/sec$User?view=_local',
        headers: {
            'Authorization': 'Bearer ' + oauth2Token,
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function (data) {
            $('#fbLink').hide();
            $('#users').show();

            $.each(data, function (i, user) {
                $('#usersList').append("<li>" + user.name + " (" + user.email + ")</li>");
            });
        }
    });
}

tryToLoginWithFacebook();