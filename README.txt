/** 无线考勤系统 **/

********************************************* 分割线 *********************************************

// 项目结构

-tadpole_web
    -db // 相关的sql文件
    -src
        -main
            -java
                -com.cy
                    -common.util    // 工具类
                    -modules.sys    // 主系统模块
                        -dao    // dao层
                        -entity // 实体层
                        -interceptor    // 拦截器
                        -listener   // 监听器
                        -service    // 业务层
                        -web    // 控制层
            -resources  // 配置文件
                -mapper // 映射文件
                -generatorConfig.xml // 代码生成相关配置
                -log4j.properties
                -spring-mvc.xml
                -spring-mybatis.xml
                -tadpole.properties // 系统主配置文件
                -webdefault.xml
            -webapp // 视图层
                -WEB-INF
                    -view // 视图文件
                -web.xml
       -test
    -gitignore // git配置文件（配置上传时需要忽略的文件）
    -pom.xml
    -README.txt // 项目说明

********************************************* 分割线 *********************************************

// 数据库默认配置

    #mysql database setting
    jdbc.driver=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://localhost:3306/tadpoledb?useUnicode=true&characterEncoding=utf-8
    jdbc.username=root
    jdbc.password=root


********************************************* 分割线 *********************************************

// maven配置参考

    http://maven.oschina.net/help.html

