import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class EE{
	void print(E obj){
		obj.add(90, 89);
	}
}
public class ArrayListDemo {

	public static void main(String[] args) {
		// CRUD
		List<String> list = new ArrayList<>(10);
		list.add("ram");
		list.add(0,"mike");
		/*System.out.println(list);
		list.remove(0);
		list.remove("ram");
		list.contains("mike");
		list.indexOf("mike");
		list.lastIndexOf("mike");
		list.set(0, "tom");
		*/// 1st Way
		/*for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
			list.add("TIm");
			//list.remove(i);
		}*/
		// 2nd Way
	/*	Iterator<String> i = list.iterator();
		while(i.hasNext()){
			String currentElement = i.next();
			i.remove();
			System.out.println(currentElement);
		}
		//3rd Way
		ListIterator<String> j  = list.listIterator();
		while(j.hasNext()){
			System.out.println(j.next());
		}
		while(j.hasPrevious()){
			System.out.println(j.previous());
		}*/
		//4th Way
		for(String z : list){
			System.out.println(z);
			list.add("TIM");
			//list.remove();
		}
		EE obj = new EE();
		//obj.print(new E1());
		obj.print((a,b)->System.out.println(a+b));
		
		//5th Way
		list.forEach((x)->System.out.println("MR "+x));
		list.forEach(P::show);
		PP obj2 = new PP();
		list.forEach(obj2::show);
		//list.forEach((s)->System.out.println(s));
		//E e = (a,b)->System.out.println(a+b);
		
	}

}
class PP{
	void show(String s){
		System.out.println("Mr "+s);
	}
}
class P{
	static void show(String s){
		System.out.println("Mr "+s);
	}
}
class E1 implements E{
	public void  add(int x, int y){
		System.out.println(x+y);
	}
}
interface E
{
	void add(int x,int y);
}
