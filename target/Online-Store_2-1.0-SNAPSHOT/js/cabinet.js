let products = null;

$.get("Products", function(data) {
    if (data !== '') {
        products = data;
    }
}).done(function() {

    let cardsContent = "";

    jQuery.each(products, function(i, value) {

        cardsContent+="<div class='col' style='margin: 15px; background-color: #0b5ed7'>" +
            "<div class='card'>" +
            "<div class='card-body'>" +
            "<h5  class='card-title'>" + value.name + "</h5>"+
            "<h6 <p class='card-text'>" + value.price + "</h6>"+
            "<p class='card-text'>" + value.description + "</p>"+
            "<a href='product?id=" + value.id + "' class='card-link' >link</a>"+
            "</div>" +
            "</div>" +
            "</div>" +
            "</div>"
    });

    $('#productCardsFromCabinet').html(cardsContent);

});
