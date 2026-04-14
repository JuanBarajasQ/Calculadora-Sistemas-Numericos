/**
 * 
 * @author Juan Barajas 1152455 y Bryan Gelves 1152500
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(convertirBinOctDecimal(110010, 2));    
    }
    
    public static long operaciones(long num1, long num2, String operando){
        if(operando.equals("+")) return num1 + num2;
        if(operando.equals("-")) return num1 - num2;
        if(operando.equals("*")) return num1 * num2;
        if(operando.equals("/")) return num1 / num2;
        return 0;
    }

    public static long convertirBinOctDecimal(long numero, int base){
        long resultado = 0;
        for(int exponente = 0, actual = 0; numero != 0; exponente++, numero/=10){
            resultado += ((numero % 10) * (Math.pow(base,exponente)));
        }
        return resultado;
    }
    
    public static long convertirHexadecimal(String numero){
        String hexa = numero;
        long resultado = 0;

        for(int i= numero.length()-1, exponente = 0, valor = 0; i>=0; i--, exponente++){
            char digito = hexa.charAt(i);

            if(digito >= '0' && digito <= '9'){
                valor = digito - '0';
            } else if(digito >= 'A' && digito <='F'){
                valor = digito - 'A' + 10;
            } else if(digito >= 'a' && digito <= 'f'){
                valor= digito - 'a' + 10;
            } else {
                throw new IllegalArgumentException("Dígito inválido");
            }
            resultado += valor * Math.pow(16, exponente);
        }
        return resultado;
    }




}
