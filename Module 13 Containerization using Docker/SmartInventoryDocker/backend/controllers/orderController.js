const Order = require("../models/Order");

exports.getOrders = async (req, res) => {
    try {
        const orders = await Order.getAll();

        res.json({
            success: true,
            count: orders.length,
            data: orders
        });

    } catch (error) {
        res.status(500).json({
            success: false,
            message: error.message
        });
    }
};

exports.getOrder = async (req, res) => {
    try {
        const order = await Order.getById(req.params.id);

        if (!order) {
            return res.status(404).json({
                success: false,
                message: "Order not found"
            });
        }

        res.json({
            success: true,
            data: order
        });

    } catch (error) {
        res.status(500).json({
            success: false,
            message: error.message
        });
    }
};

exports.createOrder = async (req, res) => {
    try {
        const order = await Order.create(req.body);

        res.status(201).json({
            success: true,
            message: "Order created successfully",
            data: order
        });

    } catch (error) {
        res.status(500).json({
            success: false,
            message: error.message
        });
    }
};

exports.updateOrder = async (req, res) => {
    try {
        const order = await Order.update(req.params.id, req.body);

        res.json({
            success: true,
            message: "Order updated successfully",
            data: order
        });

    } catch (error) {
        res.status(500).json({
            success: false,
            message: error.message
        });
    }
};

exports.deleteOrder = async (req, res) => {
    try {
        await Order.remove(req.params.id);

        res.json({
            success: true,
            message: "Order deleted successfully"
        });

    } catch (error) {
        res.status(500).json({
            success: false,
            message: error.message
        });
    }
};