import React, { useState, useEffect } from "react";
import axios from "axios";
import { Box, CircularProgress, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";

const AverageLongitude = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get("http://localhost:5000/api/avg-longitude")
            .then((response) => {
                setData(response.data);
                setLoading(false);
            })
            .catch((error) => console.error("Error fetching data:", error));
    }, []);

    if (loading) {
        return (
            <Box display="flex" justifyContent="center" alignItems="center" minHeight="50vh">
                <CircularProgress />
            </Box>
        );
    }

    return (
        <Box m={2}>
            <h2>Average Longitude per Country</h2>
            <TableContainer component={Paper} style={{ maxHeight: 400 }}>
                <Table stickyHeader>
                    <TableHead>
                        <TableRow>
                            <TableCell>Country</TableCell>
                            <TableCell align="right">Average Longitude</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {data.map((row, index) => (
                            <TableRow key={index}>
                                <TableCell>{row.country}</TableCell>
                                <TableCell align="right">{row.avg_longitude}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
};

export default AverageLongitude;
