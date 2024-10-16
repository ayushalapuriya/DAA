
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		HashMap<Character ,Integer> map = new HashMap<>();
// 		map.put('A',65);
// 		map.put('B',66);
// 	    map.put('C',67);
// 	    map.put('D',68);
// 	    map.put('E',69);
// 	    map.put(null,70);
// 	    System.out.println(map);
// 	   // for (char a : map.keySet()){
// 	   //     System.out.println(a+"="+map.get(a));
// 	   // }
// 	    map.containsKey('A');
// 	    System.out.println(map.containsKey('A'));
        char[]arr={'A','B','C','A','B','C','D','E','A','F'};
	    for(char c:arr){
	        if(map.containsKey(c)){
	            map.put(c,map.get(c)+1);
	        }
	        else map.put(c,1);
	    }
	    System.out.println(map);
	    int max=0;
	    for(char c:map.keySet()) {
	        if(map.get(c)>max) {
	            max=map.get(c);
	            char a=c;
	        }
	    }
	    System.out.println(max);
 	}
}

