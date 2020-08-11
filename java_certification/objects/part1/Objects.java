public class Objects {
    public static void main(String[] args) {

        //Reference type    Reference variable                  "new" keyword       Object type
             String               str1                =            new                 String();


        String str;                                         //Reference 'str' made, but no objects exists yet
        str = new String("this is string!");                //String creaed and assigned to reference



        String str2 = new String("test1");                  //New object was asssigned to reference 'str2'
        System.out.println(str2.hashCode());
        str2  = new String("test2");                        //New object was asssigned existing reference 'str2'
        System.out.println(str2.hashCode());
        str2  = new String("test3");                        //again
        System.out.println(str2.hashCode());
        str2  = new String("test4");                        //again
        System.out.println(str2.hashCode());


        str2 = "asdasd";
        System.out.println(str2.hashCode());
        str2 = "asdasd323232";
        System.out.println(str2.hashCode());

        str2 = str2+"asdasd323232";
        System.out.println(str2.hashCode());


        String first = "first";
        System.out.println(first.hashCode());
        first = first + "!";
        System.out.println(first.hashCode());



    }
}