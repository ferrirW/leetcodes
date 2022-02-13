import java.util.ArrayList;
import java.util.List;

public class MQTT {
    public static void main(String[] args) {
        MQTT mqtt = new MQTT();
        List<Integer> encoded = mqtt.encode(321);
        encoded.forEach(i -> System.out.printf("0x%x ", i));
        System.out.println();

        System.out.println(mqtt.decode(encoded));

    }

    public List<Integer> encode(int x) {
        List<Integer> encodedBytes = new ArrayList<>();

        do {
            int encodeByte = x % 128;
            x = x / 128;
            if (x > 0) {
                encodeByte |= 128;
            }
            encodedBytes.add(encodeByte);
        } while (x > 0);

        return encodedBytes;
    }

    public int decode(List<Integer> encoded) {
        int multiplier = 1;
        int value = 0;
        int encodedByte;
        int index = 0;

        do {
            encodedByte = encoded.get(index++);
            value += (encodedByte & 127) * multiplier;
            if (multiplier > 128*128*128) {
                throw new RuntimeException("Malformed Remaining Length");
            }
            multiplier *= 128;
        } while ((encodedByte & 128) != 0);

        return value;
    }
}
