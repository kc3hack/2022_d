## 起動方法
1. envファイルをbackendディレクトに作成してください。 \
$DB_URL以外はお好きな値を入れてください。
```dotenv
POSTGRES_USER=user
POSTGRES_PASSWORD=password
POSTGRES_DB=nagamochi
DB_URL=jdbc:postgresql://db:5432/${POSTGRES_DB}
```

2. イメージをビルドする。
```shell
./gradlew dockerBuildNative
```

4. コンテナを起動する。
```shell
docker compose up -d
```
場合によってはデータベースの起動が間に合わず、アプリケーションが落ちることがあります。\
その場合はアプリケーションコンテナを再起動してください。

3. APIドキュメント
ログイン方法や各APIについては下記のURLで参照することが可能です。
```text
http://localhost:8080/swagger-ui/
```

---

## Micronaut 3.3.4 Documentation

- [User Guide](https://docs.micronaut.io/3.3.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.3.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.3.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

## Feature data-jdbc documentation

- [Micronaut Data JDBC documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#jdbc)

## Feature testcontainers documentation

- [https://www.testcontainers.org/](https://www.testcontainers.org/)

## Feature security-session documentation

- [Micronaut Security Session documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html#session)

## Feature security documentation

- [Micronaut Security documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

## Feature security-jwt documentation

- [Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)

## Feature swagger-ui documentation

- [Micronaut Swagger UI documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)

## Feature reactor documentation

- [Micronaut Reactor documentation](https://micronaut-projects.github.io/micronaut-reactor/snapshot/guide/index.html)


