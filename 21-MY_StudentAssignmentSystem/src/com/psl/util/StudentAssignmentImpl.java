
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


package com.psl.util;

import java.util.List;
import java.util.Map;
import java.util.* ;
import java.io.* ;
import java.util.Date; 
import java.time.* ;
import java.text.* ;

import com.psl.bean.Student;
import com.psl.bean.Subject;

public class StudentAssignmentImpl implements StudentAssignment {

	@Override
	public Map<Subject, List<Student>> populateData(String fileSubject,
			String fileStudent) {
		// TODO Auto-generated method stub
		
		Map<Subject, List<Student>> map  = new HashMap<Subject, List<Student>>() ;
		List<Student> list = new ArrayList<Student>() ;
		Scanner s =null ;
		try
		{
			s= new Scanner(new File(fileSubject));
			while(s.hasNext())
			{
				String[] a =s.nextLine().split(",") ;
				String name =a[0].trim() ;
				SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");
				Date d=sdf.parse(a[1]);
				map.put(new Subject(name,d,0), new ArrayList<Student>());
				
			}
		}
		catch(Exception e){}
		finally
		{
			s.close();
		}
		try
		{
			s= new Scanner(new File(fileStudent));
			while(s.hasNext())
			{
				String[] a =s.nextLine().split(",") ;
				int rollno =Integer.parseInt(a[0].trim());
				String name=a[1].trim();
				String subject=a[2].trim();
				SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");
				java.util.Date d=sdf.parse(a[3].trim());
				list.add(new Student(rollno,name,subject,d,0,0,false)) ;
				
			}
		}
		catch(Exception e){}
		finally
		{
			s.close();
		}
		for(Map.Entry<Subject, List<Student>> m : map.entrySet()) 
		{
			for(Student student:list)
			{
				if(m.getKey().getSubjectName().equals(student.getSubject()))
					map.get(m.getKey()).add(student) ;
			}
		}
		return map ;
		
	
	}

	@Override
	public void calculateMarks(Map<Subject, List<Student>> map) {
		// TODO Auto-generated method stub
		
		for(Map.Entry<Subject, List<Student>> m:map.entrySet())
		{
			for(Student s:m.getValue())
			{
				long d1 =m.getKey().getAssignmentIssueDate().getTime() ;
				long d2 =s.getSubmissionDate().getTime() ;
				int days =(int)((d2-d1)/(24*60*60*1000)) ;
				s.setNumberOfDays(days);
				if(days<=5)
					s.setMarksObtained(45);
				else if(days>5 && days <=10)
					s.setMarksObtained(35);
				else
				{
					s.setMarksObtained(0);
					s.setDefaulter(true);

				}
				
			}
		}
		
	}

	@Override
	public Map<Subject, List<Student>> generateDefaulterListSubjectWise(
			Map<Subject, List<Student>> map) {
		// TODO Auto-generated method stub
		Map<Subject, List<Student>> m = new HashMap<Subject, List<Student>>() ;
		m.putAll(map);
		for(Map.Entry<Subject, List<Student>> mi: m.entrySet())
		{
			Iterator<Student> i = mi.getValue().iterator();
			while(i.hasNext())
			{
				Student student =i.next() ;
				if(!(student.isDefaulter()))
						i.remove();
			}
		}
		
		
		return map ;
	}

	@Override
	public void offerGraseMarks(Map<Subject, List<Student>> map) {
		// TODO Auto-generated method stub
		for(Map.Entry<Subject, List<Student>> m:map.entrySet())
		{
			Collections.sort(m.getValue(), new Comparator<Student>()
					{
						public int compare(Student s1,Student s2)
						{
							return s1.getSubmissionDate().compareTo(s2.getSubmissionDate()) ;
						}
				
					}) ;
			m.getValue().get(0).setMarksObtained(m.getValue().get(0).getMarksObtained()+3);
		}
		
	}

	
}
