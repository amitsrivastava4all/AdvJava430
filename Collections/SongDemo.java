import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class SongDemo {

	public static void main(String[] args) {
		int e[]={10,20,30};
		List l5 = Arrays.asList(e);
		ArrayList list = new ArrayList(1000);
		list.add(20);
		list.add(30);
		list.add(10);
		//System.out.println(list.get(0));
		HashMap phone = new HashMap();
		phone.put("amit", 22222);
		phone.put("ram", 22222);
		phone.put("ram", 5555);
		System.out.println(phone.get("ram"));
		
		LinkedList l2 = new LinkedList();
		l2.add(100);
		l2.add(200);
		l2.add(300);
		System.out.println(l2.get(1));
		
		List l1 = Collections.synchronizedList(list);
		System.out.println(l1.get(1));
		//ArrayList<TreeSet<String>> a = new ArrayList<TreeSet<String>>();
		// Generic Types
		/*TreeSet<String> ts = new TreeSet<>();
		ts.add(new Integer(10));
		ts.add(100);
		ts.add(11);
		ts.add("It's My Life");
		ts.add("Bang Bang");
		ts.add("Bang Bang");
		ts.add("It's My Life");
		System.out.println(ts);
		System.out.println(ts.size());*/
		

	}

}
