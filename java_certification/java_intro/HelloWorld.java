public class HelloWorld {
    public static void main(String[] args) {
        for(int n = 0; n < args.length; n++) {
            System.out.println("Arg. no " + n + ": " + args[n]);
        }

        System.out.println("Done!!!");
    }
}