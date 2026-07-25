import DashboardStats from "../components/DashboardStats";
import ProductTable from "../components/ProductTable";

function Dashboard() {

    const products = [
        {
            id: 1,
            name: "Wireless Mouse",
            category: "Electronics",
            stock: 45,
            status: "Available"
        },
        {
            id: 2,
            name: "Office Chair",
            category: "Furniture",
            stock: 12,
            status: "Available"
        },
        {
            id: 3,
            name: "Mechanical Keyboard",
            category: "Electronics",
            stock: 0,
            status: "Out of Stock"
        }
    ];

    return (
        <>
            <DashboardStats products={products} />
            <ProductTable products={products} />
        </>
    );
}

export default Dashboard;