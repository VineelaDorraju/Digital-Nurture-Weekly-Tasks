const db = require("../config/db");

class Order {

    static async getAll() {
        const result = await db.query(
            "SELECT * FROM orders ORDER BY id"
        );

        return result.rows;
    }

    static async getById(id) {
        const result = await db.query(
            "SELECT * FROM orders WHERE id = $1",
            [id]
        );

        return result.rows[0];
    }

    static async create(order) {
        const { customer, amount } = order;

        const result = await db.query(
            "INSERT INTO orders(customer, amount) VALUES($1,$2) RETURNING *",
            [customer, amount]
        );

        return result.rows[0];
    }

    static async update(id, order) {
        const { customer, amount } = order;

        const result = await db.query(
            "UPDATE orders SET customer=$1, amount=$2 WHERE id=$3 RETURNING *",
            [customer, amount, id]
        );

        return result.rows[0];
    }

    static async remove(id) {
        await db.query(
            "DELETE FROM orders WHERE id=$1",
            [id]
        );
    }

}

module.exports = Order;