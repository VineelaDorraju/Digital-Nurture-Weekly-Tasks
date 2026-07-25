import ProductTable from "../components/ProductTable";

function Products() {

    const products = [
        {
            id: 101,
            name: "Laptop",
            category: "Electronics",
            stock: 15,
            status: "Available"
        },
        {
            id: 102,
            name: "Printer",
            category: "Office",
            stock: 8,
            status: "Available"
        },
        {
            id: 103,
            name: "Desk Lamp",
            category: "Furniture",
            stock: 0,
            status: "Out of Stock"
        }
    ];

    return (
        <div>

            <h2>All Products</h2>

            <ProductTable products={products} />

        </div>
    );
}

export default Products;