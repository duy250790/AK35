package tvn;


public class Collection {
    public static void main(String[] args) {
        /*
        Array
        List
        https://www.baeldung.com/java-arrays-guide
        https://www.baeldung.com/java-arraylist-vs-linkedlist-vs-hashmap
        https://www.baeldung.com/java-random-string
        random from int-int
        random.nextInt(max - min + 1) + min
        https://www.tutorialspoint.com/how-to-get-current-day-month-and-year-in-java-8
         */


        //todo:
        /**
         * find longest element in given array
         */

//        for (String car : cars){
//            System.out.println(car.length());
//        }
        String [] cars = {"honda", "toyota", "bmw","madaz"};
        String max=cars[0];
        for (int i = 1; i < cars.length; i++){
            if (cars[i].length() > max.length()){
                max = cars[i];
            }
        }
        System.out.print(max);
    }
}
