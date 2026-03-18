package com.kaiet.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String fullname;
  private String email;
  private String password;
  private String address;
  private String phone;
  private String avatar;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Order> order;


  public String getAvatar() {
    return avatar;
  }
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
  // ID
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }


  // FULLNAME
  public String getFullname() {
    return fullname;
  }
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  // MAIL
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  // PASSWORD
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  // ADDRESS
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  // PHONE
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  @Override
  public String toString() {
    return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + ", address="
        + address + ", phone=" + phone + ", avatar=" + avatar + "]";
  }

  
}
