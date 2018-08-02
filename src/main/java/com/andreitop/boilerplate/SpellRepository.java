package com.andreitop.boilerplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpellRepository {

    private DataSource dataSource;

    public Spell getById(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(
                    "select id, type, castingTime from spell where id=?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            Spell spell = null;
            if (rs.next()) {
                spell = new Spell();
                spell.setId(rs.getString("id"));
                spell.setType(rs.getString("type"));
                spell.setCastingTime(rs.getString("castingTime"));
            }
            return spell;
        } catch (SQLException e) {
            //handling exception
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    //handling exception
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    //handling exception
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //handling exception
                }
            }
        }
        return null;
    }

    public Spell getByIdWithTemplate(String id) {
        new JdbcTemplate().queryForObject(
                "select id, type, castingTime from spell where id=?",
                new RowMapper<Spell>() {
                    public Spell mapRow(ResultSet rs,
                                        int rowNum) throws SQLException {
                        Spell spell = new Spell();
                        spell.setId(rs.getString("id"));
                        spell.setType(rs.getString("type"));
                        spell.setCastingTime(rs.getString("castingTime"));
                        return spell;
                    }
                },
                id);
        return null;
    }
}





