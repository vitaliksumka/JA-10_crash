function loginRegisterSwitch() {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
}

function showAlertAfterRegistration() {
    $('div.alert-success').show();
}


$("input[type='submit']").click(function () {
    return false;
});

function showAlertAfterSuccessCreatedProduct() {
    $('div.alert.alert-success').show().delay(1600).hide(800);
}


$("input.form-submit")
    .click(
        function () {


            let productName = $("input.productName").val();
            let productDescription = $("input.productDescription").val();
            let productPrice = $("input.productPrice").val();


            if (productName == '' || productDescription == '' || productPrice == '') {
                alert("Please fill all fields...!!!!!!");
            } else if (isNaN(productPrice)) {
                alert("Please in field PRODUCT PRICE write only number!");
            } else {
                let userRegistration = {
                    productName: productName,
                    productDescription: productDescription,
                    productPrice: productPrice,

                };

                $.post("productController", userRegistration, function (data) {
                    if (data == 'Success') {
                        showAlertAfterSuccessCreatedProduct();

                        $("form.createProduct")[0].reset();
                    }
                });
            }
        });

$("a.logOut").click(function () {
    $.get("logOutServlet", function (data) {
        if (data !== '') {
            let customUrl = '';
            let urlContent = window.location.href.split('/');
            for (let i = 0; i < urlContent.length - 1; i++) {
                customUrl += urlContent[i] + '/'
            }
            customUrl += data;
            window.location = customUrl;
        }
    });
});

