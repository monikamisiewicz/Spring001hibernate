package pl.coderslab.model;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	String firstName;
	String lastName;
	String gender;
	String country;
	String notes;
	boolean mailingList;
	List<String> programmingSkills;
	List<String> hobbies;
}
