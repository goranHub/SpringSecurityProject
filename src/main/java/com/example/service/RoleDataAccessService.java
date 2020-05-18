package com.example.service;

import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDataAccessService {

    private final JdbcTemplate  jdbcTemplate;


    @Autowired
    public RoleDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void setRoleAdmin(Role role) {
        this.jdbcTemplate.update(
                "INSERT INTO role (id, user_id, role_admin, role_develop, role_cctld, role_gtld, role_billing, role_registry, role_purchase_read, role_purchase_write, role_sale_write, role_sql) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
                role.getId(),
                role.getUser_id(),
                role.getRole_admin(),
                role.getRole_develop(),
                role.getRole_cctld(),
                role.getRole_gtld(),
                role.getRole_billing(),
                role.getRole_registry(),
                role.getRole_purchase_read(),
                role.getRole_purchase_write(),
                role.getRole_sale_write(),
                role.getRole_sql());
    }


    public Role getRoleByUserId(int id){
        String sql = "SELECT * FROM role WHERE id=?";
        return  jdbcTemplate.queryForObject(sql, new Object[]{id},mapRoleFomDb());
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
            return new Role(id,userId,roleAdmin,roleDevelop,roleCctld,roleGtld,roleBilling,roleRegistry,rolePurchaseRead,rolePurchaseWrite,roleSaleWrite,roleSql);
        };
    }
}







