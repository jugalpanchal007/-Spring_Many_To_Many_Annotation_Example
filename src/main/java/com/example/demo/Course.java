package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "COURSE_TBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String abbrevation;
	private int modules;
	private double fee;
	
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
	@JsonBackReference
	private Set <Student> students;
}
