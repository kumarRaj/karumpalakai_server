**Setup**

1. Create database and user
   `CREATE USER karumpalakai WITH PASSWORD 'password';`
   `CREATE DATABASE karumpalakai OWNER karumpalakai;`
    
**To Run**

2. Run by executing 
`./gradlew clean bootRun`

**Endpoints**

3. Create sentence
`curl -H "Content-Type: application/json" -X POST -d '{"text":"Hello world!!!"}' http://localhost:8080/sentence`