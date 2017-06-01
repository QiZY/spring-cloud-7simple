#基于哪个镜像
FROM centos:7

#将本地文件夹挂载到当前容器（tomcat使用）
VOLUME /usr/local/spring-cloud-7simple/cloud-simple-docker/target

#拷贝文件到容器
ADD jdk1.8.0_11 /software/jdk1.8.0_11
ADD cloud-simple-docker-0.0.1-SNAPSHOT.jar /app.jar

#设置jdk环境变量
ENV JAVA_HOME /software/jdk1.8.0_11
ENV PATH $JAVA_HOME/bin:$PATH

#打开服务端口
EXPOSE 8181

#配置容器启动后执行的命令
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
