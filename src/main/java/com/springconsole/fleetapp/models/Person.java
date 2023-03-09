package com.springconsole.fleetapp.models;
import jakarta.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String first_name;
	private String last_name;
	private String other_name;
	private String title;
	private String initials;
	private String social_security_number;
	private String gender;
	private String marital_status;
	
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private Integer countryid;
	
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false, updatable=false)
	private State state;
	private Integer stateid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String photo;
}
