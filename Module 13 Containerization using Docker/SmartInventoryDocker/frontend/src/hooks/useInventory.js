import { useEffect, useState } from "react";
import { getProducts } from "../services/api";

function useInventory() {

    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);

    async function loadProducts() {

        try {
            const data = await getProducts();
            setProducts(data);
        }
        catch (error) {
            console.error(error);
        }
        finally {
            setLoading(false);
        }

    }

    useEffect(() => {
        loadProducts();
    }, []);

    return {
        products,
        loading,
        refresh: loadProducts
    };

}

export default useInventory;