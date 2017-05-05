package hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;

import java.util.ArrayList;

public class HRWHashDemo {
    private static final HashFunction func = Hashing.murmur3_128();
    private static final Funnel<String> funnel = new Funnel<String>() {
        @Override
        public void funnel(String from, PrimitiveSink into) {
            into.putBytes(from.getBytes());
        }
    };

    private static RendezvousHash<String, String> rendezvousHash = new RendezvousHash<>(func, funnel, funnel, new ArrayList<String>());

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            rendezvousHash.add("s" + i);
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(i + ":" + rendezvousHash.get("a" +i));
        }
    }
}
