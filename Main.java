public class Main {
    public static void main(String[] args) {
        SecuenciaEnteros secuencia = new SecuenciaEnteros();

        secuencia.añadir(10);
        secuencia.añadir(20);
        secuencia.añadir(30);
        secuencia.añadir(40);
        secuencia.añadir(50);
        secuencia.añadir(60);

        System.out.println("Secuencia original:");
        secuencia.imprimirSecuencia();

        System.out.println("Valor del índice 2: " + secuencia.obtenerPorIndice(2));

        secuencia.modificarPorIndice(1, 25);
        System.out.println("Secuencia después de modificar el índice 1:");
        secuencia.imprimirSecuencia();

        System.out.println("Recorriendo la secuencia con un iterador:");
        for (int valor : secuencia) {
            System.out.print(valor + " ");
        }
    }
}