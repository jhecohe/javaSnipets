class Hijo extends Padre {

    Hijo() {
        super("Padre");
    }

    void print(String word) {
        super.print();
    }

    public static void main(String[] args) {
        Hijo h = new Hijo();
        h.print("word");
    }
}
