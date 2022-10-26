package com.example.gift.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //changed
   // @Column(name = "role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length=20)
    private ERole name;

    @ManyToMany( fetch = FetchType.LAZY)
    private Set<User> userSet = new HashSet<>();
    public Role(){}

    public Role (ERole name){
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName(){
        return name;
    }
    public void setName(ERole name){
        this.name = name;
    }
}
