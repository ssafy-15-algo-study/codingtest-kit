import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를_지나는_트럭_곽지영 {

    static class Truck {
        int weight; int endTime;

        public Truck(int weight, int endTime) {
            this.weight = weight;
            this.endTime = endTime;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new ArrayDeque<>();

        int t = 0;
        int on_bridge = 0;

        for (int truck_weight : truck_weights) {
            t++;

            while (true) {
                // 다리의 맨앞 트럭이 지나가면 제거
                if (!bridge.isEmpty() && bridge.peek().endTime == t) {
                    on_bridge -= bridge.poll().weight;
                }

                // 다리를 건널 수 있으면 진입
                if (on_bridge + truck_weight <= weight) break;

                // 못 들어가면 건널 수 있는 시간으로 스킵
                t = bridge.peek().endTime;
            }

            bridge.offer(new Truck(truck_weight, bridge_length + t));
            on_bridge += truck_weight;
        }

        return bridge_length + t;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int answer = solution(bridge_length, weight, truck_weights);

        System.out.println(answer);
    }
}
