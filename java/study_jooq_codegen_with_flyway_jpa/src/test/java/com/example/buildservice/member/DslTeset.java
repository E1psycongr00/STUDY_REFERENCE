package com.example.buildservice.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import jooq.jooq_dsl.tables.JMember;
import jooq.jooq_dsl.tables.records.JMemberRecord;

@SpringBootTest
@Testcontainers
public class DslTeset {

    @Container
    @ServiceConnection
    private static MySQLContainer<?> mySqlContainer = new MySQLContainer<>("mysql:8.0.33");

    private static DSLContext dslContext;

    @BeforeAll
    static void beforeAll() {
        Flyway.configure()
                .dataSource(mySqlContainer.getJdbcUrl(), mySqlContainer.getUsername(), mySqlContainer.getPassword())
                .schemas("test")
                .load()
                .migrate();
        dslContext = DSL.using(mySqlContainer.getJdbcUrl(), mySqlContainer.getUsername(), mySqlContainer.getPassword());
    }

    @Test
    void test() {
        List<JMemberRecord> records = dslContext.selectFrom(JMember.MEMBER)
                .fetch();

        assertThat(records).hasSize(0);
    }
}
