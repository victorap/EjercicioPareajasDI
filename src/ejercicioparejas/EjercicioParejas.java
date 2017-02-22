package ejercicioparejas;

import static java.lang.Math.round;

public class EjercicioParejas {

    public static float calculaSalarioBruto(String tipo, float ventasMes, float horasExtra) throws BRException {
        float salarioBruto;
        float salarioBase = 0;
        float prima = 0;

        if (tipo == null || tipo == "" || ventasMes < 0 || horasExtra < 0) {
            throw new BRException();
        } else {
            if (tipo.equalsIgnoreCase("empleado")) {
                salarioBase = 1000;
            } else if (tipo.equalsIgnoreCase("encargado")) {
                salarioBase = 1500;
            }

            if (ventasMes >= 1000 && ventasMes < 1500) {
                prima = 100;
            } else if (ventasMes >= 1500) {
                prima = 200;
            }

            salarioBruto = salarioBase + prima + (round(horasExtra) * 20);
            return salarioBruto;
        }
    }

    public static float calculaSalarioNeto(float salarioBruto) throws BRException {
        float salarioNeto = 0;
        float retencion = 0;

        if (salarioBruto < 0) 
            throw new BRException();
            
        else if (salarioBruto <= 1000) 
            retencion = 0;
            
        else if (salarioBruto > 1000 && salarioBruto <= 1500) 
            retencion = (16 * salarioBruto) / 100;
            
        else if (salarioBruto > 1500) 
            retencion = (18 * salarioBruto) / 100;
        
        salarioNeto = salarioBruto - retencion;
        return salarioNeto;
    }

    public static class BRException extends Exception {

        public BRException() {
            super("Error.");
        }

        public BRException(String message) {
            super(message);
        }

    }

}
