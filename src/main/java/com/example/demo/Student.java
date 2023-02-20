package com.example.demo;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "STUDENT_TBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int age;
	private String dept;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE_TABLE",
	joinColumns = {
			@JoinColumn(name="student_id",referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name="course_id",referencedColumnName = "id")
	}
			)
	
	private Set<Course> courses;

}
