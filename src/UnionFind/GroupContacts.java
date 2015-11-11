package UnionFind;
import java.util.*;
/*
 * 有这么一个class Contact，里面有一个string的name，和一个vector 装着email address，是这个Contact有的address，用一个list装着是因为一个人有可 能有多个email，现在给你vector，比如
{
    { "John", {"john@gmail.com"} },
    { "Mary", {"mary@gmail.com"} },
    { "John", {"john@yahoo.com"} },
    { "John", {"john@gmail.com", "john@yahoo.com", "john@hotmail.com"} },
    { "Bob",  {"bob@gmail.com"} }
}
现在我们知道如果email address相同的话，那么就说明是同一个人，现在要做的是根据这些email address，把同一个contact给group起来，生成一个vector<vector<Contact>>
 */
class Contact{
	public String name;
	public ArrayList<String> emails;
	public  Contact(String name,ArrayList<String> emails){
		this.name=name;
		this.emails=emails;
	}
}
public class GroupContacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact a=new Contact("John",new ArrayList<String>());
		a.emails.add("john@gmail.com");
		Contact b=new Contact("Mary",new ArrayList<String>());
		b.emails.add("mary@gmail.com");
		Contact c=new Contact("John",new ArrayList<String>());
		c.emails.add("john@yahoo.com");
		Contact d=new Contact("John",new ArrayList<String>());
		d.emails.add("john@gmail.com");
		d.emails.add("john@yahoo.com");
		d.emails.add("john@hotmail.com");
		Contact e=new Contact("Bob",new ArrayList<String>());
		e.emails.add("bob@gmail.com");
		ArrayList<Contact> input=new ArrayList<Contact>();
		input.add(a);
		input.add(b);
		input.add(c);
		input.add(d);
		input.add(e);
		group_contacts(input);
	}
	public static int findFather(int x,Map<Integer,Integer> father){
		while(x != father.get(x)){
			x=father.get(x);
		}
		return x;
	}
	public static void union(Map<Integer,Integer> father,int x, int y){
		int fa=findFather(x,father);
		int ch=findFather(y,father);
		if(fa != ch){
			father.put(fa, ch);
		}
	}
	public static ArrayList<ArrayList<Contact>> group_contacts(ArrayList<Contact> input){
		ArrayList<ArrayList<Contact>> result=new ArrayList<ArrayList<Contact>>();
		Map<Integer,Integer> father=new HashMap<Integer,Integer>();
		int n=input.size();
		for(int i=0;i<n;++i){
			father.put(i,i);
		}
		System.out.println(father);
		Map<String,ArrayList<Integer>> findsame=new HashMap<String,ArrayList<Integer>>();
		for(int i=0;i<n;++i){
			for(String email:input.get(i).emails){
				if(!findsame.containsKey(email)){
					findsame.put(email,new ArrayList<Integer>());
					findsame.get(email).add(i);
				}
				else{
					findsame.get(email).add(i);
				}
			}
		}
		System.out.println(findsame);
		for(String email:findsame.keySet()){
			System.out.println(findsame.get(email));
			for(int i=0;i<findsame.get(email).size()-1;++i){
				int x=findsame.get(email).get(i);
				int y=findsame.get(email).get(i+1);
				union(father,x,y);
			}
		}
		System.out.println(father);
		Map<Integer,ArrayList<Integer>> groupid=new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<n;++i){
			int fa=findFather(i,father);
			if(!groupid.containsKey(fa)){
				groupid.put(fa, new ArrayList<Integer>());
			}
			groupid.get(fa).add(i);
		}
		System.out.println(groupid);
		for(int i:groupid.keySet()){
			ArrayList<Contact> sub=new ArrayList<Contact>();
			for(int j:groupid.get(i)){
				sub.add(input.get(j));
			}
			result.add(sub);
		}
		for(ArrayList<Contact> con:result){
			for(int i=0;i<con.size();++i){
				System.out.println(con.get(i).name+" "+con.get(i).emails);
			}
			System.out.println("=============================");
		}
		return result;
	}

}
