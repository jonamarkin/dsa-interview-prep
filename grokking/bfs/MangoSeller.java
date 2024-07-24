package grokking.bfs;

import java.util.*;

public class MangoSeller {

    public static void main(String[] args) {

        HashMap<String, List<String>> sellersGraph = new HashMap<>();
        List<String> bobN = List.of("Ato", "Kweku", "Ama");
        List<String> atoN = List.of("jona", "Ama", "Clara");
        List<String> kwekuN = List.of("Joana", "Naana", "Prof");
        List<String> amaN = List.of("Kweku", "Nana", "Sam");

        sellersGraph.put("Bob", bobN);
        sellersGraph.put("Ato", atoN);
        sellersGraph.put("Kweku", kwekuN);
        sellersGraph.put("Ama", amaN);

        System.out.println(hasPathToSeller("Clara", sellersGraph));

    }

    public static boolean hasPathToSeller(String name, HashMap<String, List<String>> sellersGraph){

        Queue<String> sellersQueue = new LinkedList<>();
        //HashMap<String, List<String>> sellersGraph = new HashMap<>();
        Set<String> searched = new HashSet<>();
        sellersQueue.add(name);

        while(!sellersQueue.isEmpty()){
            String seller = sellersQueue.poll();
            if (!searched.contains(seller)) {

                if (isMangoSeller(seller)){
                    System.out.println("Seller " + seller + " is a mango seller");
                    return true;
                }else{
                    System.out.println("Seller to add " + seller);
                    searched.add(seller);
                    if (sellersGraph.containsKey(seller)){
                        sellersQueue.addAll(sellersGraph.get(seller));
                    }

                }

            }
        }

        return false;

    }

    public static boolean isMangoSeller(String name){
        return name.charAt(name.length()-1)=='m';
    }
}
