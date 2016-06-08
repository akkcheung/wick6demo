package com.mycompany.taskDemo.model;
 
import java.io.Serializable;
import lombok.*;

@Data
public class Task implements Serializable {
	String name;
	Long pid;
	String type;
	String ramUsage;
	
}