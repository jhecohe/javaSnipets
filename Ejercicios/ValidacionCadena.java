import java.util.regex.Pattern;

class ValidacionCadena {

    public static void main(String[] args) {
        // String cadena = "Password123";
        // String cadena = "pass123";
        // String cadena = "PASSWORD123";
        // String cadena = "Ab1";
        String cadena = "Ocho0008";
        boolean res = validarCadena(cadena);
        System.out.println(res);
    }

    private static boolean validarCadena(String cadena) {
        if (cadena.length() < 8) return false;
        if (Pattern.matches("[A-Z]+[a-z]+[0-9]+", cadena)) return true;
        return false;
    }
}
/*
    Implementa una función para validar si una cadena de texto cumple con las siguientes reglas:
    1. Debe contener al menos una letra mayúscula.
    2. Debe contener al menos una letra minúscula.
    3. Debe contener al menos un número.
    4. Debe tener una longitud mínima de 8 caracteres.

    La función debe devolver True si la cadena es válida y False en caso contrario.
    Ejemplo 1:
    Entrada: "Password123"
    Salida: True

    Ejemplo 2:
    Entrada: "pass123"
    Salida: False
    Ejemplo 3:
    Entrada: "PASSWORD123"
    Salida: False

    Restricciones:
    • La función debe ejecutarse en tiempo lineal O(n)O(n)O(n).
*/
