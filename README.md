<h1>IoT Data Processing with Speed Layer</h1>
<p>This project demonstrates the integration of a speed layer using Spark Streaming, Kafka, and Cassandra to process IoT sensor data in real-time.</p>

<h2>Key Features</h2>
<ul>
    <li>Real-time data ingestion using <strong>Kafka</strong>.</li>
    <li>Stream processing with <strong>Spark Streaming</strong>.</li>
    <li>Data storage and retrieval using <strong>Cassandra</strong>.</li>
    <li>Batch processing for HDFS storage.</li>
</ul>

<h2>Architecture Overview</h2>
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

<h2>Steps to Run the Project</h2>
<ol>
    <li>
        <h3>Set Up Kafka</h3>
        <p>Ensure Kafka is installed and running. Create the necessary topics for data ingestion:</p>
        <pre><code>bin/kafka-topics.sh --create --topic iot-data --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3</code></pre>
    </li>
    <li>
        <h3>Run the Kafka Producer</h3>
        <p>Compile and run the Kafka producer to simulate sensor data:</p>
        <pre><code>javac -cp kafka-clients.jar SensorDataProducer.java
java -cp .:kafka-clients.jar SensorDataProducer</code></pre>
    </li>
    <li>
        <h3>Set Up Cassandra</h3>
        <p>Install Cassandra and create the necessary tables for storing sensor data.</p>
    </li>
    <li>
        <h3>Run the Spark Processor</h3>
        <p>Compile and run the Spark processing application:</p>
        <pre><code>spark-submit --class tn.enit.tp4.processor.StreamProcessor --master local[2] stream-processor.jar</code></pre>
    </li>
</ol>

<h2>Code Snippets</h2>

<h3>Kafka Producer</h3>
<pre><code>package tn.enit.tp4.kafka;

// Code for generating and sending sensor data
// Simulates temperature and humidity readings</code></pre>

<h3>Spark Processor</h3>
<pre><code>package tn.enit.tp4.processor;

// Code for processing sensor data using Spark Streaming
// Saves processed data to Cassandra and HDFS</code></pre>

<h2>Technologies Used</h2>
<ul>
    <li><strong>Kafka:</strong> For message queuing and real-time data streaming.</li>
    <li><strong>Spark Streaming:</strong> For processing data streams.</li>
    <li><strong>Cassandra:</strong> For data storage and retrieval.</li>
    <li><strong>HDFS:</strong> For batch storage of processed data.</li>
</ul>

<h2>Contact</h2>
<p>For questions or contributions, feel free to reach out or create an issue on the repository.</p>
