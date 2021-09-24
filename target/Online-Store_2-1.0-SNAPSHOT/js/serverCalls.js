$('button.btn-primary').on('shown.bs.modal', function () {
    $('#buyProductModal').trigger('focus');
})


$("button.createProduct")
    .click(
        function () {

            let name = $("form.createProduct input.productName").val();
            let description = $("form.createProduct input.productDescription").val();
            let price = $("form.createProduct input.productPrice").val();

            let product = {
                name: name,
                description: description,
                price: price
            };
//add validation
            $.post("Product", product,
                function (data) {
                    if (data == 'Success') {
//										$("form")[0].reset();
//										$("form")[1].reset();
//										showAlertAfterRegistration();
                        alert('Success');
                    }
                });

        });

$("button.buy-product").click(function () {
    let productId = jQuery(this).attr("product-id");


    $.post("bucket", {'productId': productId},
        function (data) {
            if (data == 'Success') {
                $("[data-dismiss=modal]").trigger({type: "click"});
                alert('Success');
            }
        });
});


