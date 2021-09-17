function loginRegisterSwitch() {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
}

function showAlertAfterRegistration() {
    $('div.alert-success').show();
}

$('.message a').click(function () {
    loginRegisterSwitch();
});

$("input[type='submit']").click(function () {
    return false;
});

function switchLoginPage() {
    window.location.href = 'http://localhost:8080/login.jsp';
}

function showAlertAfterRegistration() {
    $('div.alert.alert-success').show();
}

function showAlertAfterFaileLogin() {
    $('div.alert.alert-warning').show();
}

$("input.form-submit")
    .click(
        function () {
            let checkbox = document.getElementById('checkbox');

            let firstName = $("input.firstName").val();
            let lastName = $("input.lastName").val();
            let email = $("input.email").val();
            let password = $("input.password").val();
            let cpassword = $("input.confirm-password").val();

            if (firstName == '' || lastName == '' || email == ''
                || password == '' || cpassword == '') {
                alert("Please fill all fields...!!!!!!");
            } else if (password.length < 8) {
                alert("Password should atleast 8 character in length...!!!!!!");
            } else if (!(password).match(cpassword)) {
                alert("Your passwords don't match. Try again?");
            } else if (!checkbox.checked) {
                alert("Please agree all statements!");
            } else {
                let userRegistration = {
                    firstName: firstName,
                    lastName: lastName,
                    email: email,
                    password: password
                };

                $.post("registration", userRegistration, function (data) {
                    if (data == 'Success') {
                        showAlertAfterRegistration();
                        setTimeout(switchLoginPage, 700);
                        $("form")[0].reset();
                    }
                });
            }
        });

$("input.email-submit")
    .click(
        function () {
            let email = $("input.email").val();
            let password = $(" input.password").val();

            if (email == '' || password == '') {
                alert("Please fill login form!");
            } else {
                let userLogin = {
                    email: email,
                    password: password
                }

                $.post("login", userLogin, function (data) {

                    if (data !== '') {
                        let customUrl = '';
                        let urlContent = window.location.href.split('/');
                        for (let i = 0; i < urlContent.length - 1; i++) {
                            customUrl += urlContent[i] + '/';
                        }

                        customUrl+=data.destinationUrl;
                        window.location = customUrl;
                    } else {
                        showAlertAfterFaileLogin();
                    }
                    $("form")[0].reset();

                });

            }
        });