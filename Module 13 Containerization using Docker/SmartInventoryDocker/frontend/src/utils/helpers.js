export function formatCurrency(amount) {
    return new Intl.NumberFormat("en-IN", {
        style: "currency",
        currency: "INR"
    }).format(amount);
}

export function getStockStatus(quantity) {

    if (quantity === 0) {
        return "Out of Stock";
    }

    if (quantity <= 10) {
        return "Limited";
    }

    return "Available";
}

export function generateProductId() {
    return "PRD-" + Math.floor(Math.random() * 100000);
}