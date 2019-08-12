package com.stackroute.trackservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


//Create like a table
@Entity
//create the default constructor
@NoArgsConstructor
//Creates the parameters constructor
@AllArgsConstructor
//Create the setter and getter and toString()
@Data
public class Track
{
    @Id
    private int id;
    private String name;
    private String comments;

}

