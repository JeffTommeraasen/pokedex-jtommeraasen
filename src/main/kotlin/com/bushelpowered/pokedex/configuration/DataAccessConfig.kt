package com.bushelpowered.pokedex.configuration

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.init.DatabasePopulator
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import javax.sql.DataSource

@Configuration
@MapperScan(value=["com.bushelpowered.pokedex.mybatis.mapper"])
@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class, MybatisAutoConfiguration::class))
open class DataAccessConfig {

    @Bean
    open fun sqlSessionFactory(): SqlSessionFactory {
        val sqlSessionFactoryBean : SqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(h2Datasource())
        return sqlSessionFactoryBean.getObject()
    }

    // The application.properties values do not work.
    @Bean
    open fun h2Datasource() : DataSource {
        val dataSource: DataSource = createDataSource()
        executeSchema(dataSource)
        executeCsvRead(dataSource)
        executeInsertUser(dataSource)
        return dataSource
    }

    private fun createDataSource() : DataSource {
        val dataSource: DriverManagerDataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.url = "jdbc:h2:file:/users/jefftommeraasen/workspace/pokedex;AUTO_SERVER=true;LOCK_TIMEOUT=90000;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1"
        dataSource.username="sa"
        dataSource.password="sa"
        return dataSource
    }

    private fun executeSchema(dataSource: DataSource) {
        val initSchema: ClassPathResource = ClassPathResource("sql/schema.sql")
        var populator: DatabasePopulator = ResourceDatabasePopulator(initSchema)
        DatabasePopulatorUtils.execute(populator, dataSource)
    }

    private fun executeCsvRead(dataSource: DataSource) {
        val initPokedex: ClassPathResource = ClassPathResource("sql/pokedex-import.sql")
        var populator: DatabasePopulator = ResourceDatabasePopulator(initPokedex)
        DatabasePopulatorUtils.execute(populator, dataSource)
    }

    private fun executeInsertUser(dataSource: DataSource) {
        val insertUser: ClassPathResource = ClassPathResource("sql/user-insert.sql")
        var populator: DatabasePopulator = ResourceDatabasePopulator(insertUser)
        DatabasePopulatorUtils.execute(populator, dataSource)
    }
}