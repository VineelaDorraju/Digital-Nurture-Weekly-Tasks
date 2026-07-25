function ProductTable({ products }) {
    return (
        <table>

            <thead>
                <tr>
                    <th>ID</th>
                    <th>Product</th>
                    <th>Category</th>
                    <th>Stock</th>
                    <th>Status</th>
                </tr>
            </thead>

            <tbody>

                {products.map(product => (

                    <tr key={product.id}>

                        <td>{product.id}</td>

                        <td>{product.name}</td>

                        <td>{product.category}</td>

                        <td>{product.stock}</td>

                        <td>{product.status}</td>

                    </tr>

                ))}

            </tbody>

        </table>
    );
}

export default ProductTable;