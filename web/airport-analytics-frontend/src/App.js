import React from "react";
import { Container, CssBaseline } from "@mui/material";
import AverageAltitude from "./components/AverageAltitude";
import AverageLongitude from "./components/AverageLongitude";
import TopHighAltitude from "./components/TopHighAltitude";
import TopHighLongitude from "./components/TopHighLongitude";
import AirportCount from "./components/AirportCount";

function App() {
    return (
        <div>
            <CssBaseline />
            <Container>
                <header>
                    <h1 style={{ textAlign: "center", marginTop: "20px" }}>Airport Analytics Dashboard</h1>
                </header>
                <main>
                    <AverageAltitude />
                    <AverageLongitude />
                    <TopHighAltitude />
                    <TopHighLongitude />
                    <AirportCount />
                </main>
            </Container>
        </div>
    );
}

export default App;
