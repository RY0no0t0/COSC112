public class foo {
    public static void main(String[] args) throws Exception{
        foo(1);
        try {
            foo2(-1);
        } catch (Exception e) {
            System.out.println("oui");
        }
    }

    private static void foo2(final int number) throws Exception {
        Exception ex;
        if (number < 0) {
            ex = new Exception("No negative number please!");
            throw ex;
            // throw ex; //nothing happens until you throw it
        }

    }

    private static void foo(final int number) throws Exception {
        if (number < 0) {
            throw new Exception("No negative number please!");
        }

    }
}