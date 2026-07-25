import InventoryCard from "./InventoryCard";

function DashboardStats({ products }) {

    const total = products.length;

    const available = products.filter(
        product => product.stock > 0
    ).length;

    const outOfStock = products.filter(
        product => product.stock === 0
    ).length;

    return (
        <section className="summary">

            <InventoryCard
                title="Total Products"
                value={total}
            />

            <InventoryCard
                title="Available"
                value={available}
            />

            <InventoryCard
                title="Out of Stock"
                value={outOfStock}
            />

        </section>
    );
}

export default DashboardStats;