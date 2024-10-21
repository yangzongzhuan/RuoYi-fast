FROM openjdk:17.0.2-oraclelinux8

MAINTAINER semanteme

RUN mkdir -p /home/ruoyi/logs

WORKDIR /home/ruoyi

ENV SERVER_PORT=3300 LANG=C.UTF-8 LC_ALL=C.UTF-8 JAVA_OPTS="-Xms512m -Xmx1024m"

EXPOSE ${SERVER_PORT}

ADD ./target/ruoyi.jar ./app.jar

# 设置时区
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo Asia/Shanghai > /etc/timezone

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
            "-jar", "app.jar"]
