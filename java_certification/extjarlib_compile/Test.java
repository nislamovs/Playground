import org.apache.commons.lang3.*;

public class Test {

    public static void main(String[] args) throws Exception {

        try {
            String x = "abcd";
            System.out.println(StringUtils.capitalize(x));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}