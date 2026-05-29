# Usando a imagem oficial do Eclipse Temurin (Java 17)
FROM eclipse-temurin:17-jdk

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Gradle
COPY build/libs/wallet-0.0.1-SNAPSHOT.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
