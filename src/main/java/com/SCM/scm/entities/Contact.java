package com.SCM.scm.entities;

import java.util.ArrayList;

import org.hibernate.annotations.Collate;
import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

// private List<SocialLinks> socialLinks = new ArrayList<>();

@ManyToOne
private User user;


}
