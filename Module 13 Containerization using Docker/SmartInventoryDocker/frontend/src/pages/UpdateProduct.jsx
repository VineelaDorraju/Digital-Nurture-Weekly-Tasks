function UpdateProduct() {

    return (

        <div>

            <h2>Update Product</h2>

            <form>

                <input
                    defaultValue="Wireless Mouse"
                />

                <input
                    defaultValue="Electronics"
                />

                <input
                    type="number"
                    defaultValue={25}
                />

                <button>
                    Update Product
                </button>

            </form>

        </div>

    );
}

export default UpdateProduct;