<h1>📡 IoT Data Processing with Speed Layer</h1>
<p>This project demonstrates the integration of a speed layer using Spark Streaming, Kafka, and Cassandra to process IoT sensor data in real-time.</p>

<h2>✨ Key Features</h2>
<ul>
    <li>⚡ Real-time data ingestion using <strong>Kafka</strong>.</li>
    <li>🔄 Stream processing with <strong>Spark Streaming</strong>.</li>
    <li>💾 Data storage and retrieval using <strong>Cassandra</strong>.</li>
    <li>🗄️ Batch processing for HDFS storage.</li>
</ul>

<h2>🏗️ Architecture Overview</h2>
<p>The architecture is divided into three main components:</p>
<ol>
    <li>
        <strong>Kafka Producer:</strong> Simulates IoT sensor data and sends it to Kafka topics.
    </li>
    <li>
        <strong>Spark Processor:</strong> Consumes data from Kafka, processes it in real-time, and saves results to Cassandra and HDFS.
    </li>
    <li>
        <strong>Cassandra:</strong> Stores processed data for quick retrieval and analysis.
    </li>
</ol>

<h2>🚀 Steps to Run the Project</h2>
<ol>
    <li>
        <h3>🛠️ Set Up Kafka</h3>
        <p>Ensure Kafka is installed and running. Create the necessary topics for data ingestion:</p>
        <pre><code>bin/kafka-topics.sh --create --topic iot-data --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3</code></pre>
    </li>
    <li>
        <h3>📤 Run the Kafka Producer</h3>
        <p>Compile and run the Kafka producer to simulate sensor data:</p>
        <pre><code>javac -cp kafka-clients.jar SensorDataProducer.java
java -cp .:kafka-clients.jar SensorDataProducer</code></pre>
    </li>
    <li>
        <h3>💽 Set Up Cassandra</h3>
        <p>Install Cassandra and create the necessary tables for storing sensor data.</p>
    </li>
    <li>
        <h3>💡 Run the Spark Processor</h3>
        <p>Compile and run the Spark processing application:</p>
        <pre><code>spark-submit --class tn.enit.tp4.processor.StreamProcessor --master local[2] stream-processor.jar</code></pre>
    </li>
    <li>
        <h3>🐳 Docker Compose Workflow</h3>
        <p>Use Docker Compose to manage services. The following steps demonstrate a full workflow:</p>
        <ol>
            <li>
                <h4>📦 Hive Setup</h4>
                <pre><code>chmod 7 start-hive.sh
./start-hive.sh</code></pre>
            </li>
            <li>
                <h4>📂 PostgreSQL Database</h4>
                <p>Access the database container and set up the schema:</p>
                <pre><code>docker exec -it postgres-db psql -U postgres</code></pre>
                <pre><code>DROP TABLE IF EXISTS airports;
CREATE TABLE airports (
    airport_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100),
    country VARCHAR(100),
    iata VARCHAR(10),
    icao VARCHAR(10),
    latitude FLOAT,
    longitude FLOAT,
    altitude INT,
    timezone FLOAT,
    dst CHAR(1),
    database_timezone VARCHAR(50),
    type VARCHAR(50),
    source VARCHAR(50)
);
COPY airports FROM '/var/lib/postgresql/data/lmwn/airports.csv' DELIMITER ',' CSV HEADER;</code></pre>
            </li>
            <li>
                <h4>🔄 Sqoop Import</h4>
                <p>Import data from PostgreSQL to Hadoop using Sqoop:</p>
                <pre><code>/usr/lib/sqoop/bin/sqoop import \
--connect jdbc:postgresql://database:5432/temp_db \
--table airports \
--username postgres \
--password passw0rd \
--target-dir /user/sqoop/airports_hive \
--num-mappers 1 \
--map-column-hive airport_id=INT,name=STRING,city=STRING,country=STRING,iata=STRING,icao=STRING,latitude=FLOAT,longitude=FLOAT,altitude=INT,timezone=FLOAT,dst=STRING,database_timezone=STRING,type=STRING,source=STRING \
--verbose</code></pre>
            </li>
            <li>
                <h4>📊 Hive Table Creation</h4>
                <p>Create Hive tables and transform data:</p>
                <pre><code>CREATE EXTERNAL TABLE airports_hive (
    airport_id INT, 
    name STRING, 
    city STRING, 
    country STRING, 
    iata STRING, 
    icao STRING, 
    latitude FLOAT, 
    longitude FLOAT, 
    altitude INT, 
    timezone FLOAT, 
    dst STRING, 
    database_timezone STRING, 
    type STRING, 
    source STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
STORED AS TEXTFILE
LOCATION '/user/sqoop/airports_hive';

CREATE TABLE airports_parquet STORED AS PARQUET AS SELECT * FROM airports_hive;</code></pre>
            </li>
            <li>
                <h4>🐍 Python Spark Analysis</h4>
                <p>Run Spark analysis scripts:</p>
                <pre><code>sudo docker exec -it spark-master bash

/spark/bin/spark-submit --master local --driver-memory 4g --executor-memory 2g --executor-cores 2 --py-files airport_analysis_final.py airport_analysis_final.py</code></pre>
            </li>
        </ol>
    </li>
</ol>

<h2>🌐 Web Interface</h2>
<p>The project includes a user-friendly web interface for real-time visualization and interaction with IoT data.</p>
<h3>📋 Features</h3>
<ul>
    <li>🌡️ Display real-time sensor data, such as temperature and humidity.</li>
    <li>📈 Charts for analyzing historical trends and live updates.</li>
    <li>🛠️ Control panel to configure Kafka topics, processing parameters, and storage options.</li>
</ul>
<h3>🖥️ Commands to Start the Web Interface</h3>
<ol>
    <li>
        <h4>Install Dependencies</h4>
        <pre><code>cd web-interface
npm install</code></pre>
    </li>
    <li>
        <h4>Start the Web Server</h4>
        <pre><code>npm start</code></pre>
    </li>
    <li>
        <h4>Access the Interface</h4>
        <p>Open your browser and navigate to:</p>
        <pre><code>http://localhost:3000</code></pre>
    </li>
</ol>
<h3>📚 Tech Stack for Web Interface</h3>
<ul>
    <li>🌟 <strong>React:</strong> For building the user interface.</li>
    <li>📊 <strong>Chart.js:</strong> For visualizing data in charts.</li>
    <li>💅 <strong>Bootstrap:</strong> For responsive design and layout.</li>
</ul>

<h2>🛠️ Code Snippets</h2>
<h3>📜 Kafka Producer</h3>
<pre><code>package tn.enit.tp4.kafka;

// Code for generating and sending sensor data
// Simulates temperature and humidity readings</code></pre>

<h3>🧩 Spark Processor</h3>
<pre><code>package tn.enit.tp4.processor;

// Code for processing sensor data using Spark Streaming
// Saves processed data to Cassandra and HDFS</code></pre>

<h2>📚 Technologies Used</h2>
<ul>
    <li>📥 <strong>Kafka:</strong> For message queuing and real-time data streaming.</li>
    <li>🔗 <strong>Spark Streaming:</strong> For processing data streams.</li>
    <li>📂 <strong>Cassandra:</strong> For data storage and retrieval.</li>
    <li>🗃️ <strong>HDFS:</strong> For batch storage of processed data.</li>
    <li>🐳 <strong>Docker Compose:</strong> For managing multi-container workflows.</li>
    <li>🌐 <strong>React:</strong> For web interface development.</li>
</ul>

<h2>📧 Contact</h2>
<p>For questions or contributions, feel free to reach out or create an issue on the repository.</p>
