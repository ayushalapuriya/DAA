package Graph;
import java.util.*;
public class main {
    HashMap<Integer,HashMap<Integer,Integer>> graph;
    public  main(int Nodes){
        graph= new HashMap<>();
        for (int  i = 1;i<=Nodes;i++){
            graph.put(i,new HashMap<Integer,Integer>());
        }

    }
}
