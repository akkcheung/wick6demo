package com.mycompany.taskDemo.service;
 
import java.io.Serializable;
import com.mycompany.taskDemo.model.Task;
import java.lang.Process;
import java.lang.Runtime;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class TaskListService {
	
	private static final String TASKLIST = "tasklist /FO CSV";
	private static final String TASKKILL = "taskkill /F /IM ";

	private List <Task> tkl  ;
	
	public List <Task> getTasks() {	
		
		String line;
		tkl = new ArrayList <Task>();
				
		try {			
			Process p = Runtime.getRuntime().exec (TASKLIST);
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(p.getInputStream()));
		 
		 	reader.readLine(); //skip 1st line
		 
		 	while ((line = reader.readLine()) != null) {		
				int c = 0 ;
				Task tk = new Task();
							
				String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for(String t : tokens) {
					
						if (c == 0)
            	tk.setName(t.replace("\"", ""));
            	
            if (c == 1)
							tk.setPid(Long.parseLong(t.replace("\"", "")));            	
            
            if (c == 2)
            	tk.setType(t.replace("\"", ""));
            
            if (c == 4)
            	tk.setRamUsage(t.replace("\"", ""));
            
            // System.out.println("> "+t);
            
            c++;
        }
        
        tkl.add(tk);
				
			}	
			
			// for (Task tk : tkl) {
			//	System.out.println(tk.getName());
			// }
			
			// System.out.println("call getTask");
	
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		return tkl;
	}
	
}

