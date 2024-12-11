package br.com.lvds.BikeSys.config;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;

import java.sql.Types;

import org.hibernate.boot.model.TypeContributions;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.PostgreSQLDialect;

public class PostgreSQLCustomDialect extends PostgreSQLDialect {
    // public PostgreSQLCustomDialect() {
    //     super(); 
    //     this.registerColumnTypes(TypeContributions, null);
    //     // this.registerHibernateType(2003, StringArrayType.class.getName());
    //     // this.registerHibernateType(1111, JsonBinaryType.class.getName());
    //     // this.registerHibernateType(Types.OTHER, JsonNodeBinaryType.class.getName());
    // }
}