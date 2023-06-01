public class Program {
    public static void main(String[] args) {
        Node node = new Node();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 31; i++) {
            hashMap.put( i + 1, i);
        }
        System.out.println(hashMap.get(30));
        hashMap.replays(30, 2318);

        System.out.println(hashMap.get(30));
//        hashMap.remove(30);
//        System.out.println(hashMap.get(30));

        System.out.println(hashMap.containsKey(29));

        System.out.println(hashMap.containsValue(2318));

        System.out.println(hashMap.size());



    }
}
