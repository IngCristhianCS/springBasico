package db;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexion {
    public DriverManagerDataSource Conexion(){
        
        DriverManagerDataSource dbsource = new DriverManagerDataSource();
        dbsource.setDriverClassName("com.mysql.jdbc.Driver");
        dbsource.setUrl("jdbc:mysql://localhost/spring?useUnicode=yes&characterEncoding=UTF-8");
        dbsource.setUsername("root");
        dbsource.setPassword("");
        return dbsource;
    }
}
