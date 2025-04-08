class PrimerCaracterNoRepetido {

    public static void main(String[] args) {
        String texto = "abacabad";
        Character ch = validarPrimerCaracter(texto);
        System.out.println(ch == 'c');
    }

    private static Character validarPrimerCaracter(String texto) {
        char[] tArray = texto.toCharArray();
        for (int i = 0; i < texto.length(); i++) {
            String current = texto.replaceFirst("" + tArray[i], "_");
            if (current.contains("" + tArray[i])) continue;
            return tArray[i];
        }
        return null;
    }
    // Escribí una función que tome una cadena de texto como entrada y devuelva el primer carácter que no se repite.
    // Si todos los caracteres se repiten, la función debe devolver None.
    // Entrada: "abacabad"
    // Salida: "c"
    // Ejemplo 2:
    // Entrada: "aabbcc"
    // Salida: None
    // Restricciones:
    // • No uses estructuras de datos adicionales que consuman espacio innecesario.
    // • Optimizá para eficiencia tanto en tiempo como en espacio.
}
