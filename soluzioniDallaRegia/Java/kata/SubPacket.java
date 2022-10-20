package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

abstract class SubPacket extends Packet {

    List<Packet> packets = new ArrayList<>();

    Map<Integer, BiFunction<Long, Packet, Long>> operations = new HashMap<>();

    public SubPacket(int version, int type) {
        super(version, type);
        operations.put(0, (v, q) -> v + q.calculate());
        operations.put(1, (v, q) -> v * q.calculate());
        operations.put(2, (v, q) -> Math.min(v, q.calculate()));
        operations.put(3, (v, q) -> Math.max(v, q.calculate()));
    }

    @Override
    public int sumVersion() {
        int sum = version;
        for (Packet packet : packets) {
            sum += packet.sumVersion();
        }
        return sum;

    }

    public long calculate() {
        System.out.println("TYPE = " + type);
        if (type < 4) {
            if (packets.size() == 1) {
                return packets.get(0).calculate();
            } else {
                long val = type == 0 ? 0 : (type == 1 ? 1 : packets.get(0).calculate());
                for (Packet p : packets) {
                    val = operations.get(type).apply(val, p);
                    System.out.printf("VAL OPERATION %d = %d%n", type, val);
                }
                return val;
            }
        } else {
            Packet p1 = packets.get(0);
            Packet p2 = packets.get(1);
            switch (type) {
                case 5:
                    return p1.calculate() > p2.calculate() ? 1 : 0;
                case 6:
                    return p1.calculate() < p2.calculate() ? 1 : 0;
                case 7:
                    return p1.calculate() == p2.calculate() ? 1 : 0;
            }
        }


        System.out.println("E CHE CI FACCIO QUI?");
        return Long.MAX_VALUE;
    }

}
