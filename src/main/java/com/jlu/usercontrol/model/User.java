package com.jlu.usercontrol.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="The User's Id number")
    private Long id;

    @Size(max=20)
    @ApiModelProperty(notes="The User's first name")
    private String firstName;

    @Size(min=2)
    @ApiModelProperty(notes="The User's last name")
    private String lastName;

    @Size(min=4, max=20)
    @ApiModelProperty(notes="The User's state of residence")
    private String state;
}
