import { useState } from "react";

function App() {
    const [products] = useState([
        {
            id: 1,
            name: "Wireless Mouse",
            quantity: 45,
            status: "Available"
        },
        {
            id: 2,
            name: "Gaming Keyboard",
            quantity: 12,
            status: "Limited"
        },
        {
            id: 3,
            name: "27-inch Monitor",
            quantity: 0,
            status: "Out of Stock"
        }
    ]);

    const totalProducts = products.length;
    const available = products.filter(p => p.quantity > 0).length;
    const unavailable = products.filter(p => p.quantity === 0).length;

    return (
        <div className="container">

            <header>
                <h1>Smart Inventory Dashboard</h1>
                <p>Dockerized Inventory Management System</p>
            </header>

            <section className="summary">

                <div className="card">
                    <h2>{totalProducts}</h2>
                    <span>Total Products</span>
                </div>

                <div className="card">
                    <h2>{available}</h2>
                    <span>Available</span>
                </div>

                <div className="card">
                    <h2>{unavailable}</h2>
                    <span>Out of Stock</span>
                </div>

            </section>

            <table>

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Status</th>
                    </tr>
                </thead>

                <tbody>

                    {products.map(product => (
                        <tr key={product.id}>
                            <td>{product.id}</td>
                            <td>{product.name}</td>
                            <td>{product.quantity}</td>
                            <td>{product.status}</td>
                        </tr>
                    ))}

                </tbody>

            </table>

        </div>
    );
}

export default App;