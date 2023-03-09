package com.springconsole.fleetapp.models;
import jakarta.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {
		
	@ManyToOne
	@JoinColumn(name="employee_typeid", insertable=false, updatable=false)
	private EmployeeType employeeType;
	private Integer employee_typeid;
	private String photo;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="job_titleid", insertable=false, updatable=false)
	private JobTitle jobTitle;
	private Integer job_titleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;
}
