/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e1p1_josereyes;

/**
 *
 * @author josem
 */
import java.util.Scanner;
public class E1P1_JoseReyes {
static Scanner r = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean codigo=true;
        while(codigo==true){
            System.out.println("~~~Bienvenido al menu principal~~~");
            System.out.println("1.Numero valido\n2.Reordenamiento de cadenas\n3.Trigonometria\n4.Sali");
            int menu=r.nextInt();
            
            switch(menu){
                case 1:{
                    System.out.println("Ingrese el numero");
                    String numero=r.next();
                    numvalido(numero);
                    
                }break;
                case 2:{
                    System.out.println("Ingrese la cadena que desea reordenar");
                    r.nextLine();
                    String cadena=r.nextLine();
                    ordenamiento(cadena);
                }break;
                case 3:{
                    System.out.println("Ingrese el angulo(grados) que desee calcular: ");
                    double angulo=r.nextDouble();
                    System.out.println("Ingrese la precision que desea: ");
                    int precision=r.nextInt();
                    
                    double formula = angulo * Math.PI / 180;

                    calcularseno(formula,precision);
                }break;
                case 4:{
                    codigo=false;
                    System.out.println("Cerrando programa...");
                }break;
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("~~~~~~~~~~~~");
            }
        }
    }
    public static void ordenamiento(String cad){
        String nume="";
        String min="";
        String may="";
        String otros="";
        for(int i = 0;i<cad.length();i++){
            int num=cad.charAt(i);
            char letra=cad.charAt(i);
            if(num>=48 && num<=57){
                nume+=letra;
            }else if(num>=97 && num<=122){
                min+=letra;
            }else if(num>=65 && num<=90){
                may+=letra;
            }else{
                otros+=letra;
            }
        }
        System.out.println("String reordenada: "+nume+min+may+otros);
        System.out.println();
    }
    public static void numvalido(String valido){
        
        String cade = valido.substring(1,valido.length());
        boolean validacion= false;
        for(int i =0; i<valido.length();i++){
            int num=valido.charAt(i);
            if(valido.charAt(0)=='-'|| valido.charAt(i)=='.' || num>=48 && num<=57){
                validacion = true;
            }
        }
        for(int j = 0; j<cade.length();j++){
            if(cade.charAt(j)=='-'){
                validacion=false;
            }
        }
        if(validacion){
            System.out.println("El numero "+valido+" es valido!");
        }else{
            System.out.println("El numero "+valido+" no es valido!");
        }
        System.out.println();
    }
    public static void calcularseno(double angulo, int precision) {
        double resultado = 0;
        double termino = angulo;
        int signo = -1;
        int denominador = 3;

        for (int i = 1; i <= precision; i++) {
            resultado += termino;
            termino = termino * angulo * angulo * signo;
            signo *= -1;
            denominador *= (2 * i + 2) * (2 * i + 1);
            termino = termino / denominador;
        }
        System.out.println("sin(" + angulo + ") = " + resultado);
    }
}



