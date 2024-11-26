package com.example.buildservice.config.jpa;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * Hibernate의 물리적 명명 전략을 확장하여 사용자 지정 명명 규칙을 적용합니다.
 * <p>
 * 이 클래스는 Hibernate의 표준 물리적 명명 전략을 기반으로 하며,
 * 데이터베이스의 카탈로그, 스키마, 테이블, 시퀀스, 컬럼 이름을 실제 물리적 이름으로 변환하는 로직을 포함합니다.
 * </p>
 * <p>
 * 변환 로직은 다음과 같습니다:
 * <ul>
 * <li>소문자와 대문자가 만나면 언더스코어(_)를 삽입합니다.</li>
 * <li>모든 문자를 대문자로 변환합니다.</li>
 * </ul>
 * </p>
 * <p>
 * 예를 들어, 다음과 같은 변환을 수행합니다:
 * <ul>
 * <li>"myCatalog"은 "MY_CATALOG"으로 변환됩니다.</li>
 * <li>"mySchema"는 "MY_SCHEMA"로 변환됩니다.</li>
 * <li>"myTable"은 "MY_TABLE"로 변환됩니다.</li>
 * <li>"mySequence"는 "MY_SEQUENCE"로 변환됩니다.</li>
 * <li>"myColumn"은 "MY_COLUMN"로 변환됩니다.</li>
 * </ul>
 * </p>
 */
public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    // 데이터베이스의 카탈로그 이름을 실제 물리적 이름으로 변환합니다.
    // 예를 들어, 논리적 이름 "myCatalog"을 실제 물리적 이름 "MY_CATALOG"로 변환합니다.
    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return apply(name);
    }

    // 데이터베이스의 스키마 이름을 실제 물리적 이름으로 변환합니다.
    // 예를 들어, 논리적 이름 "mySchema"을 실제 물리적 이름 "MY_SCHEMA"로 변환합니다.
    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return apply(name);
    }

    // 데이터베이스의 테이블 이름을 실제 물리적 이름으로 변환합니다.
    // 예를 들어, 논리적 이름 "myTable"을 실제 물리적 이름 "MY_TABLE"로 변환합니다.
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return apply(name);
    }

    // 데이터베이스의 시퀀스 이름을 실제 물리적 이름으로 변환합니다.
    // 예를 들어, 논리적 이름 "mySequence"을 실제 물리적 이름 "MY_SEQUENCE"로 변환합니다.
    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return apply(name);
    }

    // 데이터베이스의 컬럼 이름을 실제 물리적 이름으로 변환합니다.
    // 예를 들어, 논리적 이름 "myColumn"을 실제 물리적 이름 "MY_COLUMN"로 변환합니다.
    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return apply(name);
    }

    // 이름을 변환하는 메소드
    private Identifier apply(Identifier name) {
        if (name == null) {
            return null;
        }
        String text = name.getText();
        String newName = text.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase();
        return Identifier.toIdentifier(newName);
    }
}
