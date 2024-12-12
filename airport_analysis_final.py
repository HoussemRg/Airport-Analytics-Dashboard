from pyspark.sql import SparkSession
from pyspark.sql.functions import avg, desc, count

# Créer une SparkSession avec le support Hive activé
spark = SparkSession.builder \
    .appName("Airport Data Analysis") \
    .enableHiveSupport() \
    .config("spark.sql.parquet.writeLegacyFormat", True) \
    .getOrCreate()

# Charger les données depuis Hive
airports = spark.read.parquet("hdfs://namenode:9000/user/hive/warehouse/airports_parquet")

# 1. Calculer l'altitude moyenne par pays
avgAltitudePerCountry = airports.groupBy("country") \
    .agg(avg("altitude").alias("avg_altitude")) \
    .orderBy(desc("avg_altitude"))

# Afficher l'altitude moyenne par pays
print("Altitude moyenne par pays :")
avgAltitudePerCountry.show()

# 2. Calculer la longitude moyenne par pays
avgLongitudePerCountry = airports.groupBy("country") \
    .agg(avg("longitude").alias("avg_longitude")) \
    .orderBy(desc("avg_longitude"))

# Afficher la longitude moyenne par pays
print("Longitude moyenne par pays :")
avgLongitudePerCountry.show()

# 3. Trouver les 5 aéroports avec la plus haute altitude
top5HighAltitudeAirports = airports.select("name", "country", "altitude") \
    .orderBy(desc("altitude")) \
    .limit(5)

# Afficher les 5 aéroports avec la plus haute altitude
print("Top 5 des aéroports avec la plus haute altitude :")
top5HighAltitudeAirports.show()

# 4. Trouver les 5 aéroports avec la plus haute longitude
top5HighLongitudeAirports = airports.select("name", "country", "longitude") \
    .orderBy(desc("longitude")) \
    .limit(5)

# Afficher les 5 aéroports avec la plus haute longitude
print("Top 5 des aéroports avec la plus haute longitude :")
top5HighLongitudeAirports.show()

# 5. Nombre d'aéroports par pays
airportCountPerCountry = airports.groupBy("country") \
    .agg(count("name").alias("airport_count")) \
    .orderBy(desc("airport_count"))

# Afficher le nombre d'aéroports par pays
print("Nombre d'aéroports par pays :")
airportCountPerCountry.show()

# Enregistrer les résultats dans des fichiers CSV
avgAltitudePerCountry.write.csv("/output_airport/avg_altitude_per_country.csv")
avgLongitudePerCountry.write.csv("/output_airport/avg_longitude_per_country.csv")
top5HighAltitudeAirports.write.csv("/output_airport/top_5_high_altitude_airports.csv")
top5HighLongitudeAirports.write.csv("/output_airport/top_5_high_longitude_airports.csv")
airportCountPerCountry.write.csv("/output_airport/airport_count_per_country.csv")

# Arrêter la SparkSession
spark.stop()