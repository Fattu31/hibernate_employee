package hibernate_employee.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee_info")
@Getter
@Setter
@ToString
public class Employee {
	@Id
    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private long phone;
    private double salary;
    private String designation;
	
}