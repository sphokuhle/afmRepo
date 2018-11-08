package za.ac.afm.startup;


import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;
import za.ac.afm.util.LoggingUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class LiquiBaseStartup {

	public static final String className = LiquiBaseStartup.class.getSimpleName();
	private static final String STAGE = "development";
	private static final String CHANGELOG_FILE = "liquibase/changelog.xml";

	@Resource(lookup = "jdbc/afm")
	DataSource ds;
	
	private static final Logger logger = LoggerFactory.getLogger(LiquiBaseStartup.class);
	
	@PostConstruct
	protected void init() {
		LoggingUtil.logInfo(logger, className,"  init()");

		ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(getClass().getClassLoader());
		try (Connection connection = ds.getConnection()) {
			JdbcConnection jdbcConnection = new JdbcConnection(connection);
			Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);

			Liquibase liquiBase = new Liquibase(CHANGELOG_FILE, resourceAccessor, db);
			LoggingUtil.logInfo(logger, className, " init() " + liquiBase);
			liquiBase.update(STAGE);
		} catch (SQLException | LiquibaseException e) {
			LoggingUtil.logError(logger,e.getMessage());
		}
		LoggingUtil.logInfo(logger, className, " init()", " Successfull");
	}
}

