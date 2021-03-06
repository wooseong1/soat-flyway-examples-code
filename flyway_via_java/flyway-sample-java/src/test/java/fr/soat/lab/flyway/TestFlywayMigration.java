package fr.soat.lab.flyway;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.googlecode.flyway.core.Flyway;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "test-context.xml")
public class TestFlywayMigration {

	@Autowired
	private DataSource dataSource;

	@Test
	public void authorTableShouldExist() throws SQLException {

		Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource);
		flyway.migrate();
		flyway.status();
	}
}
