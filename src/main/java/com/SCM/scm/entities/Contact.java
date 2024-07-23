package com.SCM.scm.entities;

import java.util.ArrayList;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact")
public class Contact {

@Id
private String id;
private String email;
private String phoneNumber;
private String address;
private String picture;
@Column(length = 1000)
private String description;
private boolean favorite = false;
private String websiteLinks;
private String linkedInLink;

@ManyToOne
private User user;

@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<SocialLink> socialLinks = new ArrayList<>();


}
