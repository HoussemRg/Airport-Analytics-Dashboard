<h1>📡 IoT Data Processing and Analytics Platform</h1>
<p>This project showcases the integration of big data tools for real-time and batch data processing, storage, and analytics. It leverages Docker for containerized services, including Kafka, PostgreSQL, Sqoop, Hive, and Spark Streaming. The final results are processed, stored, and visualized using a backend API and a React-based frontend interface.</p>

<h2>✨ Key Features</h2>
<ul>
    <li>⚡ Real-time data processing and storage using Kafka and Spark Streaming.</li>
    <li>🔄 Batch data analysis with PostgreSQL, Sqoop, Hive, and Spark.</li>
    <li>📊 Analytical insights stored and served using a PostgreSQL backend.</li>
    <li>🌐 User-friendly web interface for data visualization.</li>
</ul>

<h2>🏗️ Architecture Overview</h2>
<p>The project architecture includes the following components:</p>
<ol>
    <li>
        <strong>Real-time Processing:</strong> Spark Streaming consumes data from Kafka and processes it for storage in Cassandra and HDFS.
    </li>
    <li>
        <strong>Batch Processing:</strong> PostgreSQL, Sqoop, and Hive enable the storage and querying of large-scale data.
    </li>
    <li>
        <strong>Data Analytics:</strong> Python scripts analyze the processed data, generating key insights for further use.
    </li>
    <li>
        <strong>Web Interface:</strong> A React-based frontend for visualizing analytics and interacting with the platform.
    </li>
</ol>

<h2>🚀 Steps to Run the Project</h2>
<ol>
    <li>
        <h3>🛠️ Configure Hive and Sqoop</h3>
        <p>Connect to the Hive server container and configure Sqoop:</p>
        <pre><code>chmod 7 start-hive.sh
./start-hive.sh</code></pre>
    </li>
    <li>
        <h3>💽 Configure PostgreSQL</h3>
        <p>Set up the PostgreSQL database schema and import data:</p>
        <pre><code>docker exec -it postgres-db psql -U postgres
DROP TABLE IF EXISTS airports;
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
        <h3>🔄 Import Data with Sqoop</h3>
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
        <h3>🗄️ Create Hive Tables</h3>
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
        <h3>🐍 Run Spark Analytics</h3>
        <p>Execute the Python analytics scripts in the Spark container:</p>
        <pre><code>sudo docker exec -it spark-master bash
/spark/bin/spark-submit --master local --driver-memory 4g --executor-memory 2g --executor-cores 2 --py-files airport_analysis_final.py airport_analysis_final.py</code></pre>
        <p>View intermediate results:</p>
        <pre><code>cd airport_count_per_country.csv && cat part-*
cd avg_longitude_per_country.csv && cat part-*
cd top_5_high_longitude_airports.csv && cat part-*
cd avg_altitude_per_country.csv && cat part-*
cd top_5_high_altitude_airports.csv && cat part-*</code></pre>
        <p>Export results to your local system:</p>
        <pre><code>docker cp spark-master:/output_airport/airport_count_per_country.csv C:\Users\ASUS\Desktop\new\enit_lab_big_data\result
docker cp spark-master:/output_airport/avg_altitude_per_country.csv C:\Users\ASUS\Desktop\new\enit_lab_big_data\result
docker cp spark-master:/output_airport/avg_longitude_per_country.csv C:\Users\ASUS\Desktop\new\enit_lab_big_data\result
docker cp spark-master:/output_airport/top_5_high_altitude_airports.csv C:\Users\ASUS\Desktop\new\enit_lab_big_data\result
docker cp spark-master:/output_airport/top_5_high_longitude_airports.csv C:\Users\ASUS\Desktop\new\enit_lab_big_data\result</code></pre>
    </li>
    <li>
        <h3>📊 Post-Processing in PostgreSQL</h3>
        <p>Prepare and import aggregated data for advanced queries:</p>
        <pre><code>docker exec -it postgres-db psql -U postgres
CREATE TABLE avg_altitude_per_country (country VARCHAR(100), avg_altitude FLOAT);
CREATE TABLE avg_longitude_per_country (country VARCHAR(100), avg_longitude FLOAT);
CREATE TABLE top_5_high_altitude_airports (name VARCHAR(100), country VARCHAR(100), altitude INT);
CREATE TABLE top_5_high_longitude_airports (name VARCHAR(100), country VARCHAR(100), longitude FLOAT);
CREATE TABLE airport_count_per_country (country VARCHAR(100), airport_count INT);

docker cp C:\Users\ASUS\Desktop\new\enit_lab_big_data\resultats\avg_altitude_per_country.csv postgres-db:/tmp/
docker cp C:\Users\ASUS\Desktop\new\enit_lab_big_data\resultats\avg_longitude_per_country.csv postgres-db:/tmp/
docker cp C:\Users\ASUS\Desktop\new\enit_lab_big_data\resultats\top_5_heigh_altitude_airports.csv postgres-db:/tmp/
docker cp C:\Users\ASUS\Desktop\new\enit_lab_big_data\resultats\top_5_heigh_longitude_airports.csv postgres-db:/tmp/
docker cp C:\Users\ASUS\Desktop\new\enit_lab_big_data\resultats\airport_count_per_country.csv postgres-db:/tmp/

\COPY avg_altitude_per_country FROM '/tmp/avg_altitude_per_country.csv' DELIMITER ',' CSV HEADER;
\COPY avg_longitude_per_country FROM '/tmp/avg_longitude_per_country.csv' DELIMITER ',' CSV HEADER;
\COPY top_5_high_altitude_airports FROM '/tmp/top_5_heigh_altitude_airports.csv' DELIMITER ',' CSV HEADER;
\COPY top_5_high_longitude_airports FROM '/tmp/top_5_heigh_longitude_airports.csv' DELIMITER ',' CSV HEADER;</code></pre>
    </li>
    <li>
        <h3>🌐 Build the Backend</h3>
        <p>Create and deploy the backend API for serving analytics:</p>
        <pre><code>mkdir airport-analytics-backend
cd airport-analytics-backend
npm init -y
npm install express body-parser cors pg
docker build -t airport-backend .
docker run -d --name back -p 5000:5000 --network enit_lab_big_data_net web-server</code></pre>
    </li>
    <li>
        <h3>🖥️ Frontend Interface</h3>
        <p>Set up the React-based frontend for data visualization:</p>
        <pre><code>npx create-react-app airport-analytics-frontend
cd airport-analytics-frontend
npm install @mui/material @emotion/react @emotion/styled @mui/icons-material axios
npm start</code></pre>
    </li>
</ol>
