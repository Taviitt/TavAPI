# LoggerAPI
![Screenshot](LoggerAPIImg.png)

Gradle
```gradle
repositories {
  maven { url 'https://jitpack.io' }
}

dependencies {
  compileOnly 'com.github.Taviitt:LoggerAPI:master-SNAPSHOT'
}
```

Maven
```XML
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.Taviitt</groupId>
  <artifactId>LoggerAPI</artifactId>
  <version>master-SNAPSHOT</version>
</dependency>
```

## Usage
To send a log message to console
```java
// <Main Class>.class is your main class that extends JavaPlugin
LoggerAPI.log(<Main Class>.class, LogType.LOG, "This is a log message");
```

## Log Types
```
LOG
DEBUG
WARNING
ERROR
```
