# Etapa de build usando o wrapper do projeto
FROM eclipse-temurin:17-jdk AS base
WORKDIR /app

# Copia todo o projeto (inclui gradlew e gradle/wrapper)
COPY . .

# Garante permissão de execução no wrapper
RUN chmod +x ./gradlew

# Usa o wrapper para baixar a versão correta do Gradle e gerar o fat jar
RUN ./gradlew bootJar --no-daemon

# Etapa de runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=base /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
