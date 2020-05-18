package com.example.model;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class Role implements Serializable {
    private int id;
    private int user_id;
    private int role_admin;
    private int role_develop;
    private int role_cctld;
    private int role_gtld;
    private int role_billing;
    private int role_registry;
    private int role_purchase_read;
    private int role_purchase_write;
    private int role_sale_write;
    private int role_sql;

    public Role(int id, int user_id, int role_admin, int role_develop, int role_cctld, int role_gtld, int role_billing, int role_registry, int role_purchase_read, int role_purchase_write, int role_sale_write, int role_sql) {
        this.id = id;
        this.user_id = user_id;
        this.role_admin = role_admin;
        this.role_develop = role_develop;
        this.role_cctld = role_cctld;
        this.role_gtld = role_gtld;
        this.role_billing = role_billing;
        this.role_registry = role_registry;
        this.role_purchase_read = role_purchase_read;
        this.role_purchase_write = role_purchase_write;
        this.role_sale_write = role_sale_write;
        this.role_sql = role_sql;
    }

    public Role() {
    }

  /*  public void setId(int id) {
        this.id = id;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }


    public int getRole_admin() {
        return role_admin;
    }


    public int getRole_develop() {
        return role_develop;
    }


    public int getRole_cctld() {
        return role_cctld;
    }


    public int getRole_gtld() {
        return role_gtld;
    }


    public int getRole_billing() {
        return role_billing;
    }


    public int getRole_registry() {
        return role_registry;
    }


    public int getRole_purchase_read() {
        return role_purchase_read;
    }


    public int getRole_purchase_write() {
        return role_purchase_write;
    }


    public int getRole_sale_write() {
        return role_sale_write;
    }


    public int getRole_sql() {
        return role_sql;
    }


}

