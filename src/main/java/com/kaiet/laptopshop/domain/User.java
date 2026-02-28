package com.kaiet.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String fullname;
  private String email;
  private String password;
  private String address;
  private String phone;

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
        + address + ", phone=" + phone + "]";
  }

  
}
