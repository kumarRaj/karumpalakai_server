package karumpalakai.dao;

import karumpalakai.domain.Sentence;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SentenceMapper implements ResultSetMapper<Sentence> {
    @Override
    public Sentence map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Sentence(r.getString("text"));
    }
}
