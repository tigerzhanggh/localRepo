# 定义基础镜像
FROM openjdk:17
# 定义维护者信息
MAINTAINER 杜义淙  (zhanggh@csii.com.cn)
LABEL app="athena-base" version="1.0.0" by="zhanggh"
# 指定临时目录
VOLUME /tmp
# 设置工作目录
# WORKDIR /app
# 添加宿主机的jar包 到容器中的指定目录
COPY athena-base-bootstrap/athena-base-bootstrap-springboot/target/athena-base-bootstrap.jar app.jar
# 设置容器启动时执行的操作
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]