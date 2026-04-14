import java.util.Scanner;

public class Vista {
    public static Calculadora c = new Calculadora();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el sistema númerico (2 -> Binario, 8 --> Octal, 10 --> Decimal, 16 --> Hexadecimal): ");
        int base = sc.nextInt();
        
        System.out.print("Ingrese el primer valor: ");
        String numero1 = sc.next();
        
        System.out.print("Ingrese el segundo valor: ");
        String numero2 = sc.next();

        System.out.print("Ingrese el operando (+, -, *, /): ");
        String operando = sc.next();

        if(validar(numero1, numero2, operando, base)){
            if(base == 16){

            } else{

            }

        }
        
    }

    public static boolean validar(String numero1, String numero2, String operando, int base){
        if(!validarOperando(operando)) return false;

        try{
            if(base == 2){
                return validarBinario(Long.parseLong(numero1)) && validarBinario(Long.parseLong(numero2));
            } else if(base == 8){
                return validarOctal(Long.parseLong(numero1)) && validarBinario(Long.parseLong(numero2));
            } else if(base == 16){
                return validarHexadecimal(numero1) && validarHexadecimal(numero2);
            } else if(base == 10){
                return validarDecimal(Long.parseLong(numero1)) && validarDecimal(Long.parseLong(numero2));
            }
         } catch(Exception e){
            System.out.println("Solo se permiten digitos numéricos para las bases 2, 8 y 10, y adicionalmente las letras A - F para la base 16");
         }

        return false;
    }

    public static boolean validarBinario(long numero){
        while(numero != 0){
            int digito = (int) numero % 10;
            if(digito != 1 || digito != 0) return false;
            numero /= 10;
        }
        return true;
    }

    public static boolean validarOctal(long numero){
        while(numero != 0){
            int digito = (int) numero % 10;
            if(digito >= 0 && digito < 8) return false;
            numero /= 10;
        }
        return true;
    }

     public static boolean validarDecimal(long numero){
        while(numero != 0){
            int digito = (int) numero % 10;
            if(digito < 0 || digito > 9) return false;
            numero /= 10;
        }
        return true;
    }

    
    public static boolean validarHexadecimal(String numero){
        for(int i= numero.length()-1; i>=0; i--){
            char digito = numero.charAt(i);
            if((digito < 'a' && digito > 'f') && (digito < 'A' || digito > 'F') && (digito < '0' || digito > '9')) return false;
        }
        return true;
    }

    public static boolean validarOperando(String operando){
        return operando.equals("+") || operando.equals("-") || operando.equals("*") || operando.equals("/");
    }

    public static long procesarBin0ctDec(long numero1, long numero2, String operando, int base){
        long resultado = 0;
        if(base == 2 || base == 8){
            long num1Dec = c.convertirBinOctDecimal(numero1,base);
            long num2Dec = c.convertirBinOctDecimal(numero2, base);
            long resultadoDec = c.operaciones(num1Dec, num2Dec, operando);
            //resultado = c.convertirOriginal(.....) 
        }
        resultado = c.operaciones(numero1, numero2, operando);
        return resultado;
    }

    public static String procesarHex(){
        return "";
    }
    

}
