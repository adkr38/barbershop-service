package com.adkr38.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@Entity
@Table(name="users")
public class User {
    /**
     * The unique identifier for the user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The name of the user
     */
    private String name;

    /**
     * The username used to log in
     */
    private String username;

    /**
     * The password used to log in
     */
    private String password;

    /**
     * The roles that the user has
     */
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(fetch = EAGER, mappedBy = "user")
    private List<Appointment> appointments;

    public User(String name, String username, String password ,Collection<Role> roles, List<Appointment> appointments){
      setName(name);
      setUsername(username);
      setPassword(password);
      setRoles(roles);
      setAppointments(appointments);
  }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public Collection<Role> getRoles() {
      return roles;
    }

    public void setRoles(Collection<Role> roles) {
      this.roles = roles;
    }

    public List<Appointment> getAppointments() {
      return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
      this.appointments = appointments;
    }

    public User(){};



}
