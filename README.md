# dubbo-demo
基于Springboot+Dubbo的RPC架构案例

## 简介
Dubbo是一个分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，是阿里巴巴SOA服务化治理方案的核心框架。它提供了非常简单的服务管理而且支持的非常多的协议，提供的注册中心有如下几种类型可供选择：Multicast、Zookeeper、Redis等，在本例中我使用zookeeper作为注册中心。

## 步骤

* 第一步，配置pom

首先我们需要一个公共依赖项目，将需要用rpc实现的服务类通过公共依赖同时暴露给服务的消费者和提供者。本例中即为dubbo-api模块

接着在消费者和提供者项目的pom文件中引入此依赖，

        <dependency>
            <artifactId>dubbo-api</artifactId>
            <groupId>com.rokg.rpc</groupId>
            <version>1.0.0</version>
        </dependency>
        
再接着在消费者和提供者项目的pom文件中引入springboot内置的对于dubbo的支持依赖，

        <dependency>
            <groupId>io.dubbo.springboot</groupId>
            <artifactId>spring-boot-starter-dubbo</artifactId>
            <version>1.0.0</version>
            <exclusions>
                <exclusion>
                    <groupId>org.javassist</groupId>
                    <artifactId>javassist</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

* 第二步，配置application.yaml

在消费者和提供者项目的配置文件中加入如下：

          dubbo:
                application.name: local-dubbo-consumer #消费者或提供者的名字
                registry.address: zookeeper://127.0.0.1:2181 #服务注册中心zookeeper的地址
                protocol.name: dubbo
                protocol.port: 20890 //消费者或提供者本机的端口
                protocol.host: 127.0.0.1 //消费者或提供者暴露给zookeeper的地址
                scan: com.rokg.rpc.dubbo.consumer.rpc //dubbo服务启动后扫描的包名
                monitor.protocol: registry
                timeout: 120000 //设置请求响应时间
                provider.retries: 0 //请求重发的次数
        
* 第三步，提供者实现服务

此处需要使用dubbo内置的注解@Service[注意不是spring内置的@Service注解]，如下：

          @Service(version = "1.0.0")
          @Component
          public class UserSerivce implements UserService{

          }

* 第四步，消费者调用服务

此处需要使用dubbo内置的注解@Reference[注意该注解的version值必须与提供者中的设置的一致]，如下：

          @Component
          public class UserServiceImpl {

              @Reference(version = "1.0.0")
              UserService userService;

          }

## 注意事项
* 使用dubbo传递的数据必须为经过序列化之后的数据，在本例中UserDTO需实现Serializable类，否则会出现异常：

          java.lang.RuntimeException: Serialized class xxx must implement java.io.Serializable
  
* dubbo的内置注解无法识别spring的内置注解，而spring的内置注解也无法识别dubbo的注解，所以尽量避免直接在controller中直接注入dubbo服务对象，
而是自定义一个service对象在其中引用dubbo服务对象，在spring启动时使用spring内置的@Component注解来注入这个定义的service对象，
否则会在服务调用处出现空指针异常。

* 安装dubbo监控，将dubbo-admin项目clone到本地，mvn package打包后，将生成的war包至于tomcat的webapps/ROOT中，编辑WEB_INF文件夹下的dubbo.properties文件，
配置zk地址，在浏览器中访问localhost:8080便可看到监控页面

