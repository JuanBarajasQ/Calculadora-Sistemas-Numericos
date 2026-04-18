/**
 * 
 * @author Juan Barajas 1152455 y Bryan Gelvez 1152500
 * Calculadora para sumar, restar, multiplicar y dividir en diferentes sistemas numericos
 */
public class Calculadora {
    
    public long operaciones(long num1, long num2, String operando){
        if(operando.equals("+")) return num1 + num2;
        if(operando.equals("-")) return num1 - num2;
        if(operando.equals("*")) return num1 * num2;
        if(operando.equals("/")) {
            if(num2 == 0) throw new ArithmeticException("No se puede dividir por cero");
            return num1 / num2;
        }
        return 0;
    }

    public long convertirBinOctDecimal(long numero, int base){
        long resultado = 0;
        for(int exponente = 0; numero != 0; exponente++, numero/=10){
            resultado += ((numero % 10) * (Math.pow(base,exponente)));
        }
        return resultado;
    }

    public long convertirDecimalBinOct(long numero, long base){
        if(numero == 0) return 0;
        boolean negativo = numero < 0;
        numero = Math.abs(numero);
        long resultado = 0;
        int exponente;
        for(exponente = 0; numero >= base; exponente++, numero/=base){
            resultado += (numero % base) * (Math.pow(10, exponente)); 
        }
        resultado += numero * Math.pow(10, exponente);
        return negativo ? -resultado : resultado;
    }
    
    public long convertirHexDecimal(String numero){
        String hexa = numero;
        long resultado = 0;

        for(int i= numero.length()-1, exponente = 0, valor = 0; i>=0; i--, exponente++){
            char digito = hexa.charAt(i);

            if(digito >= '0' && digito <= '9'){
                valor = digito - '0';
            } else if(digito >= 'A' && digito <='F'){
                valor = digito - 'A' + 10;
            } else if(digito >= 'a' && digito <= 'f'){
                valor = digito - 'a' + 10;
            } else {
                throw new IllegalArgumentException("Dígito inválido");
            }
            resultado += valor * Math.pow(16, exponente);
        }
        return resultado;
    }

    public String convertirDecHex(long numero){
        if(numero == 0) return "0";
        boolean negativo = numero < 0;
        numero = Math.abs(numero);
        String resultado = "";
        char letra;
        String valor = "";
        while(numero >= 16){
            int digito = (int) numero % 16;
            valor = Integer.toString(digito);
            if(digito >= 10){
                letra = (char) (55 + digito);
                valor = Character.toString(letra);
            }
            resultado += valor; 
            numero /= 16;
        }
        if(numero >= 10){
            letra = (char) (55 + numero);
            valor = Character.toString(letra);
        } else{
            valor = Long.toString(numero);
        }
        resultado += valor;
        resultado = invertirString(resultado);
        return negativo ? "-" + resultado : resultado;
    }

    public String invertirString(String s){
        String resultado = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            resultado += s.charAt(i);
        }
        return resultado;
    }

}
