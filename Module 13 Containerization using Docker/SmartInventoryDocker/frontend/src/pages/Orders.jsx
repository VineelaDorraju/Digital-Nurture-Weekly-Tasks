function Orders() {

    const orders = [
        {
            id: "ORD101",
            customer: "Rahul",
            amount: 5400
        },
        {
            id: "ORD102",
            customer: "Anjali",
            amount: 2800
        },
        {
            id: "ORD103",
            customer: "Kiran",
            amount: 7200
        }
    ];

    return (

        <div>

            <h2>Recent Orders</h2>

            <table>

                <thead>

                    <tr>

                        <th>Order ID</th>

                        <th>Customer</th>

                        <th>Amount</th>

                    </tr>

                </thead>

                <tbody>

                    {
                        orders.map(order => (

                            <tr key={order.id}>

                                <td>{order.id}</td>

                                <td>{order.customer}</td>

                                <td>₹ {order.amount}</td>

                            </tr>

                        ))
                    }

                </tbody>

            </table>

        </div>

    );
}

export default Orders;