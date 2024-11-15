import java.util.HashMap;

public class test {
    public class Node{
        int val;
        Node re;
        int rank;
    }
    HashMap<Integer,Node>map = new HashMap<>();

     //dsu
    // CREATE

    public void create (int v){
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.re = nn;
        map.put(v,nn);
    }

    public int findparent (int v){
        Node nn = map.get(v);
        return findparent(nn).val;
    }
    public Node findparent (Node nn){
        if(nn.parent == nn){
            return nn;
        }
        Node n = findparent(n.parent);
        nn.parent = n;
        return n;
    }

    //union

}
