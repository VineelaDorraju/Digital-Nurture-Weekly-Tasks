import { createContext, useState } from "react";

export const InventoryContext = createContext();

function InventoryProvider({ children }) {

    const [products, setProducts] = useState([]);

    function addNewProduct(product) {
        setProducts(previous => [
            ...previous,
            product
        ]);
    }

    function removeProduct(id) {
        setProducts(previous =>
            previous.filter(product => product.id !== id)
        );
    }

    function updateExistingProduct(updatedProduct) {
        setProducts(previous =>
            previous.map(product =>
                product.id === updatedProduct.id
                    ? updatedProduct
                    : product
            )
        );
    }

    return (

        <InventoryContext.Provider
            value={{
                products,
                setProducts,
                addNewProduct,
                removeProduct,
                updateExistingProduct
            }}
        >

            {children}

        </InventoryContext.Provider>

    );

}

export default InventoryProvider;