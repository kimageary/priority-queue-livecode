
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir>{
        @Override
        public int compareTo(GraphicMemoir other){
            return Integer.compare(this.interest, other.interest);
        }
    }

    public static void main(String[] args) {
        
        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new GraphicMemoir("Im a wild seed", 62));
        pq.add(new GraphicMemoir("The Third Person", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The Bride was a Boy", 100));
        
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // System.out.println(pq.peek());
        // System.out.println(pq.poll());
        // System.out.println(pq.peek());

        List<Integer> nums = List.of(3,6,8,1,6,7);
        System.out.println(topK(nums, 4));
    }

    public static List<Integer> topK(List<Integer> nums, int k){
        List<Integer> copy = new ArrayList<>(nums);

        Collections.sort(copy);
        return copy.subList(nums.size()-k, nums.size());
    }

    public static List<Integer> topKEfficient(List<Integer> nums, int k){
        PriorityQueue<Integer> best = new PriorityQueue<>();

        for(int num : nums){
            if(best.size()<k){
                best.add(k);
            } else if(num > best.peek()){
                best.poll();
                best.add(num);
            }
            
        }
        List<Integer> result = new ArrayList<>();
        while(!best.isEmpty()){
            result.add(best.poll());
        }

        return result;
    }
}