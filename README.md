# IsoMatic
## Prerequisites
Java 11,
Node js v14,
NPM v6

## Setup
Clone the repository
```basshellh
git clone https://git.inf.fh-dortmund.de/01/birie001/ewks-sose21-joergiso.git
cd ewks-sose21-joergiso
```

Start the eureka service using your command line tool
```
for windows:
gradlew.bat isomatic-eureka-server:bootRun

for unix:
./gradlew isomatic-eureka-server:bootRun
```

Operate Gradle Tasks
```
./gradlew clean
./gradlew build
```

(already prepared) Generate OpenApi specs
```
./gradlew generateAllOpenApiDocs
```

(already prepared) The frontend services have been generated using the open api generator
```shell
cd ewks-sose21-joergiso/isomatic-frontend
npm install
npm run rest-api
```

Install npm dependencies if missing
```
npm install
```

## Run the Application

Start the remaining services using the exact order with your command line tool
```
for windows:
gradlew.bat isomatic-config-server:bootRun
gradlew.bat isomatic-device:bootRun
gradlew.bat isomatic-booking:bootRun
gradlew.bat isomatic-user:bootRun

for unix:
./gradlew isomatic-config-server:bootRun
./gradlew isomatic-device:bootRun
./gradlew isomatic-booking:bootRun
./gradlew isomatic-user:bootRun
```

Start the frontend
```shell
cd ewks-sose21-joergiso/isomatic-frontend
npm start
```
