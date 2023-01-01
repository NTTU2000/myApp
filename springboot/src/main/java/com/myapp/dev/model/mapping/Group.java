package com.myapp.dev.model.mapping;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER_GROUP")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "USER_GROUP_ID")
    private Long userGroupId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "USER_ID")
    Long userId;

    @Column(name = "EVENT_ID")
    Long eventId;

}
