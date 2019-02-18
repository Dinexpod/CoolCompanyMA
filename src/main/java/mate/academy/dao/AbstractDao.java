package mate.academy.dao;

import java.sql.Connection;

public abstract class AbstractDao {

    protected final Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }
}
