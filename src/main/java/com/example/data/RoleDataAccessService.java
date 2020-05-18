package com.example.data;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDataAccessService {


    private  JdbcTemplate jdbcTemplate;


    @Autowired
    public RoleDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void setRoleAdmin(Role role, User user) {
        this.jdbcTemplate.update(
                "INSERT INTO role (id, user_id, role_admin, role_develop, role_cctld, role_gtld, role_billing, role_registry, role_purchase_read, role_purchase_write, role_sale_write, role_sql) " +
                        "VALUES(?,?,1,1,1,1,1,1,1,1,1,1)",
                role.getId(),
                user.getId());
    }

    public void setRoleDeveloper(Role role, User user) {
        this.jdbcTemplate.update(
                "INSERT INTO role (id, user_id, role_admin, role_develop, role_cctld, role_gtld, role_billing, role_registry, role_purchase_read, role_purchase_write, role_sale_write, role_sql) " +
                        "VALUES(?,?,0,1,1,1,0,0,0,0,0,1)",
                role.getId(),
                user.getId());
    }


    public Role getRoleByUserId(int id) {
        String sql = "SELECT * FROM role WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapRoleFomDb());
    }


    private RowMapper<Role> mapRoleFomDb() {
        return (resultSet, i) -> {
            int id = Integer.valueOf(resultSet.getString("id"));
            int userId = Integer.valueOf(resultSet.getString("user_id"));
            int roleAdmin = Integer.valueOf(resultSet.getString("role_admin"));
            int roleDevelop = Integer.valueOf(resultSet.getString("role_develop"));
            int roleCctld = Integer.valueOf(resultSet.getString("role_cctld"));
            int roleGtld = Integer.valueOf(resultSet.getString("role_gtld"));
            int roleBilling = Integer.valueOf(resultSet.getString("role_billing"));
            int roleRegistry = Integer.valueOf(resultSet.getString("role_registry"));
            int rolePurchaseRead = Integer.valueOf(resultSet.getString("role_purchase_read"));
            int rolePurchaseWrite = Integer.valueOf(resultSet.getString("role_purchase_write"));
            int roleSaleWrite = Integer.valueOf(resultSet.getString("role_sale_write"));
            int roleSql = Integer.valueOf(resultSet.getString("role_sql"));
            return new Role(id, userId, roleAdmin, roleDevelop, roleCctld, roleGtld, roleBilling, roleRegistry, rolePurchaseRead, rolePurchaseWrite, roleSaleWrite, roleSql);
        };
    }
}







