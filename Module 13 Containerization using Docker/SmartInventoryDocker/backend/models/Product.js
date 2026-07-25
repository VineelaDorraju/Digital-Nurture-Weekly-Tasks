const db = require("../config/db");

class Product {

    static async getAll() {
        const result = await db.query(
            "SELECT * FROM products ORDER BY id"
        );

        return result.rows;
    }

    static async getById(id) {
        const result = await db.query(
            "SELECT * FROM products WHERE id = $1",
            [id]
        );

        return result.rows[0];
    }

    static async create(product) {
        const { name, category, stock } = product;

        const result = await db.query(
            "INSERT INTO products(name, category, stock) VALUES($1,$2,$3) RETURNING *",
            [name, category, stock]
        );

        return result.rows[0];
    }

    static async update(id, product) {
        const { name, category, stock } = product;

        const result = await db.query(
            "UPDATE products SET name=$1, category=$2, stock=$3 WHERE id=$4 RETURNING *",
            [name, category, stock, id]
        );

        return result.rows[0];
    }

    static async remove(id) {
        await db.query(
            "DELETE FROM products WHERE id=$1",
            [id]
        );
    }

}

module.exports = Product;