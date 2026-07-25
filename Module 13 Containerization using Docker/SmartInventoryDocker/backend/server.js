const express = require("express");
const cors = require("cors");
const dotenv = require("dotenv");

const productRoutes = require("./routes/productRoutes");
const orderRoutes = require("./routes/orderRoutes");

dotenv.config();

const app = express();

app.use(cors());
app.use(express.json());

app.get("/", (req, res) => {
    res.json({
        application: "Smart Inventory Management",
        version: "1.0.0",
        status: "Server Running"
    });
});

app.use("/api/products", productRoutes);
app.use("/api/orders", orderRoutes);

app.use((req, res) => {
    res.status(404).json({
        success: false,
        message: "Resource not found"
    });
});

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => {
    console.log(`Server started on port ${PORT}`);
});