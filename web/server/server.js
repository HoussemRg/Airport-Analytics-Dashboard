const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const { Pool } = require("pg");

const app = express();

// Enable CORS
app.use(cors());

// Middleware for parsing JSON bodies
app.use(bodyParser.json());

// Configure PostgreSQL connection
const pool = new Pool({
    user: "postgres",
    host: "postgres-db", // Use the container name in the Docker network
    database: "temp_db",
    password: "passw0rd",
    port: 5432,
});

// Log database connection status
pool.connect((err, client, release) => {
    if (err) {
        console.error("Error connecting to the database:", err.stack);
    } else {
        console.log("Connected to the database successfully");
        release();
    }
});

// Endpoint to retrieve average altitude per country
app.get("/api/avg-altitude", async (req, res) => {
    try {
        const result = await pool.query("SELECT * FROM avg_altitude_per_country");
        res.json(result.rows);
    } catch (err) {
        console.error("Error fetching data from avg_altitude_per_country:", err.stack);
        res.status(500).send("Server error");
    }
});

// Endpoint to retrieve average longitude per country
app.get("/api/avg-longitude", async (req, res) => {
    try {
        const result = await pool.query("SELECT * FROM avg_longitude_per_country");
        res.json(result.rows);
    } catch (err) {
        console.error("Error fetching data from avg_longitude_per_country:", err.stack);
        res.status(500).send("Server error");
    }
});

// Endpoint to retrieve top 5 airports with high altitude
app.get("/api/top-high-altitude", async (req, res) => {
    try {
        const result = await pool.query("SELECT * FROM top_5_high_altitude_airports");
        res.json(result.rows);
    } catch (err) {
        console.error("Error fetching data from top_5_high_altitude_airports:", err.stack);
        res.status(500).send("Server error");
    }
});

// Endpoint to retrieve top 5 airports with high longitude
app.get("/api/top-high-longitude", async (req, res) => {
    try {
        const result = await pool.query("SELECT * FROM top_5_high_longitude_airports");
        res.json(result.rows);
    } catch (err) {
        console.error("Error fetching data from top_5_high_longitude_airports:", err.stack);
        res.status(500).send("Server error");
    }
});

// Endpoint to retrieve airport count per country
app.get("/api/airport-count", async (req, res) => {
    try {
        const result = await pool.query("SELECT * FROM airport_count_per_country");
        res.json(result.rows);
    } catch (err) {
        console.error("Error fetching data from airport_count_per_country:", err.stack);
        res.status(500).send("Server error");
    }
});


// Start the server
const PORT = 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
