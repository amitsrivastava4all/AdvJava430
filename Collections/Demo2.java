import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*class SortByName implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2){
		return o1.getName().compareTo(o2.getName());
	}
}
class SortById implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2){
		return ((Integer)o1.getId()).compareTo(o2.getId());
	}
}
class SortBySalary implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2){
		return ((Double)o1.getSalary()).compareTo(o2.getSalary());
	}
}*/
class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private double salary;
	Employee(int id , String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee e){
		//return ((Integer)this.id).compareTo(e.id);
	//return this.name.compareTo(e.name);
	//return e.name.compareTo(this.name);
	return this.name.compareToIgnoreCase(e.name);
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double
				.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	
	/*@Override
	public String toString(){
		return "Id "+id+" Name "+name+" Salary "+salary;
	}*/
	/*@Override
	public boolean equals(Object o){
		Employee e= (Employee)o;
		boolean isMatch = false;
		if(e.id>0){
			if(e.id==this.id){
				isMatch = true;
			}
		}
		if(e.name!=null && e.name.trim().length()>0){
			if(this.name.equals(e.name)){
				isMatch = true;
			}
		}
		return isMatch;
		if(this.id==e.id && this.name.equals(e.name) && this.salary==e.salary){
			return true;
		}
		else
		{
			return false;
		}
	}*/
	
}
public class Demo2 {

	public static void main(String[] args) {
		ArrayList<Employee> empList= new ArrayList<>(100);
		Employee empObject  = new Employee(1001, "Ram", 9090);
		empList.add(empObject);
		empObject  = new Employee(1002, "shyam", 7777);
		empList.add(empObject);
		empObject  = new Employee(1003, "amit", 7777);
		empList.add(empObject);
		
		
		System.out.println(empList.toString());
		Employee searchObject = new Employee(1001, "Ram", 9090);
		int index = empList.indexOf(searchObject);
		if(index>=0){
			System.out.println("Found...");
			//empList.remove(index);
			//System.out.println("After Remove "+empList);
		}
		else
		{
			System.out.println("Not Found...");
		}
		//Collections.sort(empList,new SortByName());
		/*Collections.sort(empList,new Comparator<Employee>() {
			public int compare(Employee o1 , Employee o2){
				return o1.getName().compareTo(o2.getName());
			}
		});*/
		//Collections.sort(empList);
		Collections.sort(empList,(o1,o2)->o1.getName().compareTo(o2.getName()));
		System.out.println("After Sort "+empList);
		

	}

}
