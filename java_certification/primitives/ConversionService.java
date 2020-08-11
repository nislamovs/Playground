public class ConversionService {

    /***
     * weight conversion rates
     *
     * */
    //
    // conversion rate for 1 kilogram to pounds
    public static double kilogramToPounds = 2.2046;


    // conversion rate for 1 kilogram to grams
    public static int kilogramToGrams = 1000;


    // conversion rate for 1 kilogram to weight ounces
    public static double kilogramToOunces = 35.274;


    /***
     * volume conversion rates
     * */
    // conversion rate for 1 liter to fluid ounces
    public static float literToFluidOunce = 33.814f;


    // conversion rate for 1 liter to gallons
    public static float literToGallon = 0.2642f;


    // conversion rate for 1 liter to pints
    public static float literToPints = 2.1134f;


    // conversion rate for 1 liter to milliliters
    public static short litertoMilliliters = 1_000;




    public static double pounds (double kilograms){
        return kilograms * kilogramToPounds;

    }

    public static int grams (int kilograms){
        return kilograms * kilogramToGrams;

    }

    public static double ounces (double kilograms){
        return kilograms * kilogramToOunces;

    }

    public static float fluidOunces(float liters){
        return liters * literToFluidOunce;

    }

    public static float gallons(float liters){
        return liters * literToGallon;

    }

    public static float pints (float liters){
        return liters * literToPints;

    }

    public static int milliliters(int liters) {
        return liters * litertoMilliliters;

    }

    public static void main(String[] args) {

        System.out.println(ConversionService.fluidOunces(1.1f));
        System.out.println(ConversionService.gallons(2.2f));
        System.out.println(ConversionService.grams(30));
        System.out.println(ConversionService.milliliters(40));
        System.out.println(ConversionService.ounces(50));
        System.out.println(ConversionService.pints(6.6f));
        System.out.println(ConversionService.pounds(7.7));

        System.out.println("--------------------------------------");

//        ConversionService.fluidOunces(1.1);                                           //will not compile
        System.out.println(ConversionService.fluidOunces(1.1f));                  //OK
        System.out.println(ConversionService.fluidOunces((float)1.1));                  //OK


//        ConversionService.grams(30L);                                                 //will not compile
        System.out.println(ConversionService.grams(30));                       //OK
        System.out.println(ConversionService.grams((int)30L));                          //OK


//        ConversionService.milliliters(4.0);                                           //will not compile
        System.out.println(ConversionService.milliliters(4));                          //OK
        System.out.println(ConversionService.milliliters((int)4.0));                   //OK


//        short grams = ConversionService.grams(30);                                    //will not work
          short grams = (short)ConversionService.grams(30);                    //OK

//        byte byteGrams = ConversionService.grams(30);                                 //will not work
        byte byteGrams = (byte)ConversionService.grams(30);                    //OK

        System.out.println("------------------------------------");


        double ounces = ConversionService.fluidOunces(1.1f);                    //works, because of upcast
        System.out.println(ounces);

        long milliliters = ConversionService.milliliters(40);
        System.out.println(milliliters);

        double decimalmilliliters = ConversionService.milliliters(40);
        System.out.println(decimalmilliliters);

        short s = 30;
        System.out.println(ConversionService.grams(s));

        byte b = 4;
        System.out.println(ConversionService.milliliters(b));

        char z = 'z';
        System.out.println("Z is : " + (int)'z');

        int zchar = 122;
        System.out.println("Z is : " + (char)zchar);                                //downcast here

        System.out.println(ConversionService.milliliters(z));
        System.out.println(ConversionService.gallons(200));
        System.out.println(ConversionService.ounces(50.5f));
        System.out.println(ConversionService.pints(6L));
        System.out.println(ConversionService.pounds(7L));


        System.out.println("------------------------------------");

        float bigGallons = ConversionService.gallons(123456789123456789L);                  //problems with casting fractional numbers
        System.out.println(bigGallons);

        double bigGallons22 = 123456789123456789L * 0.2642;
        System.out.println(bigGallons22);

        double bigGallons222 = 123456789123456789L * 0.2642f;
        System.out.println(bigGallons222);

        double bigGallons2222 = (float)(123456789123456789L * 0.2642f);
        System.out.println(bigGallons2222);

        double bigGallons22222 = (float)(123456789123456789L * 0.2642);
        System.out.println(bigGallons22222);

//        ------------------------------------
//        3.26172852E16
//        3.261728368641728E16
//        3.2617285168398336E16
//        3.2617285168398336E16
//        3.2617283020914688E16



        System.out.println("------------------------------------");

        int bigGrams = ConversionService.grams(1234567890);             //buffer overflow
        System.out.println(bigGrams);

        long bigGrams2 = 1234567890L * 1000L;                                    //correct
        System.out.println(bigGrams2);

    }

}