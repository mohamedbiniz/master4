package com.master4.entities;


import com.master4.validators.Password;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name="users")
@Password
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name", nullable = false)
    @Size(min = 5, message = "5 caracteres au min")
    private String name;
    @Email(message = "email invalid")
    @Column(name="email", nullable = false, unique = true)
    private String email;
    @Size(min = 6, message = "6 catacters au min")
    @Column(name="password", nullable = false)
    private String password;
    @Transient
    private String confirmedPassword;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Article> articles;
    @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
    private List<Role> listRole;

    public User(long id) {
        this.id=id;
    }
    public   User (String email, String password){
        this.email=email;
        this.password=password;
    }
}
