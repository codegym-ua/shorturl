mvn clean package -f ../pom.xml &&
java  -jar ../target/shorturl-1.0-SNAPSHOT.jar server ./shorturl.json
