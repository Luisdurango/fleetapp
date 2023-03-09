package com.springconsole.fleetapp.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int id;
//    private String firstname;
//    private String lastname;
	private String username;
	private String password;
}
