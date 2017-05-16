/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.bean;

/**
 *
 * @author alecdivito
 */
 public class MetaUser implements java.io.Serializable{
    private int id;
    private String name;
    private String pic;
    private String company;

    public MetaUser(int id, String name, String pic, String company) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
        
        
}