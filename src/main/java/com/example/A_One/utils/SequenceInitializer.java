package com.example.A_One.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SequenceInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final List<String> TABLES = List.of(
        "voucher_type_master"
    );

    @PostConstruct
    public void init(){
        for(String table : TABLES){
            updatedAutoIncrementation(table);
        }
    }

    private void updatedAutoIncrementation(String tableName){
        try{
            String sql = "SELECT MAX(id) FROM" + tableName;
            Integer maxId = jdbcTemplate.queryForObject(sql, Integer.class);

            if (maxId != null){
                int nextId = maxId + 1;
                String alterQuery = "ALTER TABLE" + tableName + "AUTO_INCREMENT" + nextId;
                jdbcTemplate.execute(alterQuery);
                System.out.println(tableName+" "+nextId);
            }
        } catch (Exception e){
            System.out.println("Error updating auto-increment " + tableName + ": " + e.getMessage());
        }
    }
}
