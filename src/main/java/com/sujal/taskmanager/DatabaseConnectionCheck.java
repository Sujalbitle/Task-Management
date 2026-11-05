package com.sujal.taskmanager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class DatabaseConnectionCheck implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnectionCheck(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void run(String... args) {
        String databaseName = jdbcTemplate.queryForObject(
            "SELECT DATABASE()", String.class);
        System.out.println("Connected to database: " + databaseName);


    }

}
