## 사전 과제

* JPA를 활용해 아래의 객체 관계에 기반한 CRUD API를 설계 및 개발해주세요. REST 형식을 기본으로 하되 필요시 자유롭게 변형해도 좋습니다.
* **모든 API를 구현할 필요는 없으며, 우선 조회와 등록 API를 중점으로 작성해주세요.**
* 또한, 모든 객체에 대한 조회나 등록 API를 만들 필요는 없습니다.  테스트 코드를 포함하여, 가능한 범위 내에서 작성해주시기 바랍니다.

## ****객체 관계****

* **Team** <-> **Member**:
  * `Team`과 `Member`는 일대다 관계입니다.
  * 하나의 `Team`은 여러 `Member`를 포함할 수 있고, 각 `Member`는 하나의 `Team`에만 속할 수 있습니다.

모든 필드 값은 null이 될 수 없습니다. **주어진 연관 관계를 엄격하게 따를 필요는 없으며, 필요에 따라 객체 관계를 적절히 조절하여 설계해도 괜찮습니다.**

## Entity

```java
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String joinedDate;

    private Team team;
}

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private String foundedDate;

    private List<Member> members = new ArrayList<>();
}
```

* 기본적인 객체 구조이며 JPA에 필요한 칼럼 및 매핑 정보를 자유롭게 추가 합니다.
* 모든 필드는 notnull 입니다.

## API

* Member API
  * ID 기반 개별 조회
  * 페이징 기반 Member 조회, 검색 필터 구현 옵션
  * Member 등록
  * Member 개별 수정
* Team API
  * ID 기반 개별 조회
  * 페이징 기반 Team 조회
    * 검색 필터 구현 옵션
    * 해당 Team의 Member List으로 응답
  * Team 등록
  * Team 개별 수정

**모든 API를 만들 필요는 없고, 만들 수 있는 범위 내에서 API를 만들어 주세요.**

## 의존성

```java
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.17'
    id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = '11'
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    runtimeOnly 'com.h2database:h2'
    runtimeOnly 'org.projectlombok:lombok'
    // runtimeOnly 'com.mysql:mysql-connector-j'
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

위의 의존성을 기준으로 구현하시고, MySQL 로컬 서버 설정이 어려운 경우에는 H2 데이터베이스를 사용하세요.
