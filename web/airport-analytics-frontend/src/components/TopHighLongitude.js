import React, { useState, useEffect } from "react";
import axios from "axios";
import { Box, CircularProgress, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";

const TopHighLongitude = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get("http://localhost:5000/api/top-high-longitude")
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
            <h2>Top 5 High Longitude Airports</h2>
            <TableContainer component={Paper} style={{ maxHeight: 400 }}>
                <Table stickyHeader>
                    <TableHead>
                        <TableRow>
                            <TableCell>Name</TableCell>
                            <TableCell>Country</TableCell>
                            <TableCell align="right">Longitude</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {data.map((row, index) => (
                            <TableRow key={index}>
                                <TableCell>{row.name}</TableCell>
                                <TableCell>{row.country}</TableCell>
                                <TableCell align="right">{row.longitude}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
};

export default TopHighLongitude;
