package Print;

class Kuanysh {

    public <vvod> void printmassiv(vvod[] massiv) {
        for (int i = 0; i < massiv.length; i++) {
            System.out.println(massiv[i]);
        }
    }
}


class Pudge {

    public static void main(String[] args) {

        Kuanysh output = new Kuanysh();


        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };


        output.printmassiv( intArray );
        output.printmassiv( stringArray );

    }
}
