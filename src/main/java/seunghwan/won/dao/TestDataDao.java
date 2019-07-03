package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Role;

import javax.sql.DataSource;
import java.util.List;

import static seunghwan.won.dao.TestDataSqls.SELECT_ALL;

@Repository
public class TestDataDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> roleRowMapper;

    public TestDataDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.roleRowMapper = BeanPropertyRowMapper.newInstance(Role.class);
    }

    public List<Role> selectAll() {
        return jdbc.query(SELECT_ALL, roleRowMapper);
    }

}
