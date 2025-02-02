public class test {
    public static void main (String[] args) {
        if (args.length != 4) {
            System.exit(1);
        }

        Object num = args[1];
        int insert = Integer.parseInt(args[2]);
        int len = Integer.parseInt(args[3]);
        if (args[0].equals("NiceArray")) {
            DoNiceArray(num, insert, len);
        } else if (args[0].equals("NiceLinked")) {
            DoNiceLinked(num, insert, len);
        }
    }

    public static void DoNiceArray (Object num, int insert, int len) {
        NiceArrayList list = new NiceArrayList();
        int i = 0;
        while (i<len) {
            list.insert(i, i);
            i++;
        }
        System.out.println(list);
        System.out.println("length is "+list.length());

        list.insert(insert, num);
        System.out.println(list);
        System.out.println("length is "+list.length());

        Object removed = list.remove(insert);
        System.out.println(list);
        System.out.println("length is "+list.length()+" and "+removed+" was removed.");
    }


    public static void DoNiceLinked (Object num, int insert, int len) {
        NiceLinkedList list = new NiceLinkedList();
        int i = 0;
        while (i<len) {
            list.insert(i, i);
            i++;
        }
        System.out.println(list);
        System.out.println("length is "+list.length());

        list.insert(insert, num);
        System.out.println(list);
        System.out.println("length is "+list.length());

        Object removed = list.remove(insert);
        System.out.println(list);
        System.out.println("length is "+list.length()+" and "+removed+" was removed.");
    }


}