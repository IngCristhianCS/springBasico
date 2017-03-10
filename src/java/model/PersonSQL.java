/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.Conexion;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Cristhian
 */
public class PersonSQL {

    private final JdbcTemplate jdbctem;
    private String sql;

    public PersonSQL() {
        Conexion con = new Conexion();
        this.jdbctem = new JdbcTemplate(con.Conexion());
    }

    public List personas() {
        this.sql = "SELECT * FROM usuarios";
        List usuarios = this.jdbctem.queryForList(sql);
        return usuarios;
    }

    public Person persona(int id) {
        String sql = "SELECT * FROM usuarios where id=? limit 1";

        Person per = this.jdbctem.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Person person = new Person();
            person.setNombre(rs.getString("nombre"));
            person.setEmail(rs.getString("email"));
            person.setPais(rs.getInt("pais"));
            person.setEdad(rs.getInt("edad"));
            return person;
        }, id);
        return per;
    }

    public void insert(@ModelAttribute("person") Person per) {
        sql = "INSERT INTO usuarios(nombre,edad,email,pais) values(?,?,?,?)";
        this.jdbctem.update(sql,
                per.getNombre(),
                per.getEdad(),
                per.getEmail(),
                per.getPais()
        );
    }

    public void update(@ModelAttribute("person") Person per, int id) {
        sql = "UPDATE usuarios SET nombre=?,edad=?,email=?,pais=? where id=?";
        this.jdbctem.update(sql,
                per.getNombre(),
                per.getEdad(),
                per.getEmail(),
                per.getPais(), id
        );
    }

    public void delete(int id) {
        this.jdbctem.update(
                "DELETE FROM usuarios WHERE id = ?", id);
    }

    public boolean emailInsert(String email) {
        sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
        int count = this.jdbctem.queryForInt(sql, email);
        return count <= 0;
    }

    public boolean emailUpdate(int id, String email) {
        sql = "SELECT email FROM usuarios where id = ? limit 1";
        Person emailId = this.jdbctem.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Person person = new Person();
            person.setEmail(rs.getString("email"));
            return person;
        }, id);
        sql = "SELECT email FROM usuarios where email = ? limit 1";
        Person emailNuevo = this.jdbctem.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Person person = new Person();
            person.setEmail(rs.getString("email"));
            return person;
        }, email);
        if (emailId.getEmail().equals(emailNuevo.getEmail())) {
            return true;
        } else {
            return false;
        }
    }
}
