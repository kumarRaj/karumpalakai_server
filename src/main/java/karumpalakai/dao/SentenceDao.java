package karumpalakai.dao;

import karumpalakai.domain.Sentence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface SentenceDao {
    @SqlUpdate("insert into sentences (text) values (:text)")
    public void add(@Bind("text") String text);


    @SqlQuery("select * from sentences")
    @Mapper(SentenceMapper.class)
    public List<Sentence> all();
}
