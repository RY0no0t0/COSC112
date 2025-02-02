public class test {
    public static void main (String[] args) {
        NiceLinkedList<Integer> list = new NiceLinkedList<Integer>();

        list.insert(0, 5);
        System.out.println(list);
        System.out.println("length is "+list.length());

        list.insert(1, 4);
        System.out.println(list);
        System.out.println("length is "+list.length());

        list.insert(1, 4);
        System.out.println(list);
        System.out.println("length is "+list.length());

        int removed = list.remove(0);
        System.out.println(list);
        System.out.println("length is "+list.length()+" and "+removed+" was removed.");

        int removed2 = list.remove(1);
        System.out.println(list);
        System.out.println("length is "+list.length()+" and "+removed2+" was removed.");

        int removed3 = list.remove(0);
        System.out.println(list);
        System.out.println("length is "+list.length()+" and "+removed3+" was removed.");

        int removed4 = list.remove(0);
        System.out.println(list);
        System.out.println("length is "+list.length()+" and "+removed4+" was removed.");
    }
}