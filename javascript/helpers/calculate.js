export function totalPrice(price, quantity) {
    const shippingPrice = 2.00;
    let floatPrice = parseFloat(price.replaceAll("$","")) * parseInt(quantity);
    let totalPrice = floatPrice + shippingPrice;
    return String('$'+totalPrice.toFixed(2));
}