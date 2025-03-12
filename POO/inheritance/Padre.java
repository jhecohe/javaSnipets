abstract class Padre {

    private String nombre;

    Padre(String nombre) {
        this.nombre = nombre;
        printPrivade();
    }

    void print() {
        System.out.println(nombre);
    }

    private void printPrivade() {
        System.out.println(
            "Este metodo es privado y solo se puede usar desde la misma clase"
        );
    }
}
