package base.colecciones.map.imp;

import java.util.Hashtable;

public class ExpHashtable {

    /*
        Hashtable es una implementación sincronizada de Map.
        Es considerada "legacy" (anterior a Collections Framework).
        Similar a HashMap, pero más lenta por sincronización en cada operación.
     */


    /*                             KEY FEATURES                            */

    /*
        - Sincronizado (thread-safe).
        - No permite claves ni valores null.
        - Rendimiento inferior a HashMap en entornos single-thread.
     */


    public static void main(String[] args) {

        Hashtable<Integer, String> map = new Hashtable<>();

        // put(K,V)
        map.put(1, "Java");
        map.put(2, "Spring");
        System.out.println("Hashtable → " + map);

        // get(K)
        System.out.println("get(1): " + map.get(1));

        // containsKey / containsValue
        System.out.println("containsKey(2): " + map.containsKey(2));
        System.out.println("containsValue(\"Java\"): " + map.containsValue("Java"));

        // remove(K)
        map.remove(2);
        System.out.println("Tras remove(2): " + map);

        // keys() y elements() → iteradores antiguos tipo Enumeration
        System.out.println("keys(): " + map.keys().nextElement());
    }
}
