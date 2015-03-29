package bdd;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {
	@SqlUpdate("create table users (id integer primary key autoincrement, name text, pass text)")
	void createUserTable();

	@SqlUpdate("insert into users (name, pass) values (:name, :pass)")
	@GetGeneratedKeys
	int insert(@Bind("name") String name, @Bind("pass") String pass);

	@SqlQuery("select * from users where name = :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
	User findByName(@Bind("name") String name);

	@SqlUpdate("drop table if exists users")
	void dropUserTable(); 
	
	void close();
}
