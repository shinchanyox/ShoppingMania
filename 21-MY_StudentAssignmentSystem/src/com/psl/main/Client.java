
/*
 * Author :Snehal Patil,Nagpur
 * Email  :snehalpatil2011@gmail.com
 * 
 * Disclaimer :The projects questions does not have any resemblance
 *  			with the actual exam.Though they are on the same pattern 
 *  			that I have experienced in practice assignmets.It contains the ".rtf file" 
 *  			which describes the problem statement .
 *  
 *  In case of violation of Any privacy or rights please inform
 *  
 *  
 *                "Practice makes a man perfect.................... and women too"
 */



package com.psl.main;
import com.psl.util.*;
import java.util.* ;
import com.psl.bean.*;

public class Client {

	public static void main(String[] args) {
		StudentAssignmentImpl impl=new StudentAssignmentImpl();
		Map<Subject, List<Student>> map=impl.populateData("subject.txt","student.txt");
		impl.calculateMarks(map);
		impl.offerGraseMarks(map);
		Set<Map.Entry<Subject,List<Student>>> set=map.entrySet();
		for (Map.Entry<Subject, List<Student>> entry : set) {
			System.out.println("..................."+entry.getKey().getSubjectName());
			for(Student student:entry.getValue()){
				System.out.println(student);
			}
		}
	}
}