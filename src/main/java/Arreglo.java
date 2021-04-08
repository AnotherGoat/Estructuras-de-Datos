
/* Para generar javadoc:
Ir a Tools > Generate JavaDoc...
Elegir una carpeta (vacía) para guardarlo
En la opción "Other command line arguments" poner lo siguiente:
-encoding utf8 -docencoding utf8 -charset utf8
Para abrir el javadoc, abrir el archivo "index.html" con un navegador
 */

public class Arreglo {

    private final long[] a;
    private int length;

    /**
     * Construye un arreglo vacío.
     * @param max Tamaño máximo del arreglo.
     */
    public Arreglo(int max) {
        a = new long[max];
        length = 0;
    }

    /**
     * Obtiene el número de elementos no nulos del arreglos.
     * @return Número de elementos actuales.
     */
    public int size() {
        return length;
    }

    /**
     * Obtiene el número máximo de elementos de un arreglo.
     * @return Número máximo de elementos.
     */
    public int maxSize() {
        return a.length;
    }

    /**
     * Determina una posición según un índice, lo cual permite usar índices negativos.
     * @param index índice, el cual puede ser positivo o negativo.
     * @return Posición entre 0 y length - 1.
     */
    public int position(int index) {
        if (index < 0) {
            index = length - index;
        }

        return index;
    }

    /**
     * Retorna un elemento del arreglo.
     * @param index Índice del elemento. Si es negativo, empieza desde el último elemento.
     * @return Elemento buscado.
     */
    public long get(int index) {
        index = position(index);
        return a[index];
    }

    /**
     * Obtiene el primer elemento del arreglo.
     * @return Primer elemento.
     */
    public long first() {
        return get(0);
    }

    /**
     * Obtiene el último elemento del arreglo.
     * @return Último elemento.
     */
    public long last() {
        return get(-1);
    }

    /**
     * Revisa si el arreglo tiene un elemento y retorna el índice de su primera aparición.
     * @param searchKey Elemento a buscar.
     * @return Índice del elemento, si lo encuentra. -1 si no lo encuentra.
     */
    public int indexOf(long searchKey) {
        for (int i = 0; i < length; i++) {
            if (a[i] == searchKey) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Revisa si el arreglo tiene un elemento y retorna el índice de su última aparición.
     * @param searchKey Elemento a buscar.
     * @return Índice del elemento, si lo encuentra. -1 si no lo encuentra.
     */
    public int lastIndexOf(long searchKey) {
        for (int i = length - 1; i >= 0; i--) {
            if (a[i] == searchKey) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Revisa si un arreglo tiene un elemento.
     * @param searchKey Elemento a buscar.
     * @return true si el arreglo tiene el elemento, false en caso contrario.
     */
    public boolean has(long searchKey) {
        return indexOf(searchKey) != -1;
    }

    /**
     * Inserta un elemento al final del arreglo.
     * @param value Elemento a insertar.
     */
    public void insert(long value) {
        a[length] = value;
        length++;
    }

    /**
     * Inserta un elemento en la posición escogida.
     * @param index Posición donde se insertará el elemento.
     * @param value Elemento a insertar.
     */
    public void insertAt(int index, long value) {
        index = position(index);

        for (int i = length; i > index; i--) {
            a[i] = a[i - 1];
        }

        a[index] = value;
        length++;
    }

    /**
     * Borra un elemento según su posición.
     * @param index Índice del elemento a borrar.
     */
    private void deleteAt(int index) {
        index = position(index);

        for (int i = index; i < length; i++) {
            a[i] = a[i+1];
        }

        length--;
    }

    /**
     * Elimina el último elemento del arreglo.
     */
    private void pop() {
        deleteAt(length - 1);
    }

    /**
     * Elimina el primer elemento del arreglo.
     */
    private void shift() {
        deleteAt(0);
    }

    /**
     * Borra la primera aparición de un elemento.
     * @param value Elemento a borrar.
     *
     */
    public void delete(long value) {
        int index = indexOf(value);

        if (index != -1) {
            deleteAt(index);
        }
    }

    /**
     * Borra todas las apariciones de un elemento.
     * @param value Elemento a borrar
     */
    private void deleteAll(long value) {
        int index = indexOf(value);

        while (index != -1) {
            deleteAt(index);
            index = indexOf(value);
        }
    }

    /**
     * Convierte un arreglo en un String.
     * @return String con los elementos del arreglo.
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("[");

        for (int i = 0; i < length; i++) {
            resultado.append(Long.toString(a[i]));

            if (i == length - 1) {
                resultado.append("]");
            } else {
                resultado.append(", ");
            }
        }

        return resultado.toString();
    }

    private void display() {
        System.out.println(toString());
    }
}
