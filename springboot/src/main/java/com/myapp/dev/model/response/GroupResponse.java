package com.myapp.dev.model.response;

import com.myapp.dev.model.mapping.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResponse {

    private Long userGroupId;

    private String name;

    private String address;

    private String city;

    private String province;

    private String country;

    private String postalCode;

    private Long userId;

    private Event eventId;
}
