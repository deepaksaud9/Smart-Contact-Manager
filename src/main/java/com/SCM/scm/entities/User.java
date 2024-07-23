package com.SCM.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "users")
@Builder
public class User {
    
    @Id
    private String userId;
    @Column(name = "username", nullable = false)
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "about", length = 1000)
    private String about;
    @Column(name = "profilePic", length = 1000)
    private String profilePic;
    private String phoneNumber;
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean verifiedPhone = false;
    //signup through SELF | GOOGLE | FACEBOOK | GITHUB | TWITTER
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
 
}
