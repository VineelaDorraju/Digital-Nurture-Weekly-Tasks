function AddProduct() {

    return (

        <div>

            <h2>Add New Product</h2>

            <form>

                <input
                    type="text"
                    placeholder="Product Name"
                />

                <input
                    type="text"
                    placeholder="Category"
                />

                <input
                    type="number"
                    placeholder="Stock"
                />

                <button>
                    Save Product
                </button>

            </form>

        </div>

    );
}

export default AddProduct;