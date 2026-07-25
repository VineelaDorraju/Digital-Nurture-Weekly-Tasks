const API_URL = "http://localhost:5000/api/products";

export async function getProducts() {
    const response = await fetch(API_URL);
    return response.json();
}

export async function addProduct(product) {
    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(product)
    });

    return response.json();
}

export async function updateProduct(id, product) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(product)
    });

    return response.json();
}

export async function deleteProduct(id) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });

    return response.json();
}