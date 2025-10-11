package solid.singleresponsibility;

/*
   S → Single Responsibility Principle (SRP)

   ► "Una clase debe tener una sola razón para cambiar".
   - Cada clase debe encargarse de una única responsabilidad.
   - Evita clases "Dios" que hacen demasiadas cosas (Tipicas clases de 2k lineas)
*/

class Report {
    public String generate() {
        return "Contenido del reporte";
    }
}

class ReportPrinter {
    public void print(String report) {
        System.out.println("Imprimiendo: " + report);
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        Report report = new Report();
        ReportPrinter printer = new ReportPrinter();

        String contenido = report.generate();
        printer.print(contenido);
    }
}
