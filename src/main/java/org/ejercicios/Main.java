package org.ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Codigo que devuelve la cadena al revés

        System.out.println(reverse("Hola Mundo"));

        //1 Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.

        String[] arrayStrings = {"hola", "chau", "Buenas", "tardes"};

        for(String e : arrayStrings){

            System.out.println(e);

        }

        //2 Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.

        int[][] arrayEnteros = {{1,2,3},
                                {4,5,6}};
        for(int i = 0; i< arrayEnteros.length; i++){

                for(int x = 0; x < arrayEnteros[i].length; x++ ){

                        System.out.println("En la posicion: "+ i + " " + x + " se encuentra el valor: " + arrayEnteros[i][x]);

                }
        }

        //3 Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.

        Vector<Integer> vector = new Vector<>();

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        vector.remove(1);
        vector.remove(2);

        System.out.println("Vector resultante: " + vector );

        //4. Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.

                //El problema seria que el vector iria agrandando la capicidad muchas veces, y durante el proceso estaría copiando y rehaciendo el array detrás,
                //por lo cual seria un gasto de memoria innecesario.

        //5. Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.

        ArrayList<String> arrayListStrings = new ArrayList<>();
        arrayListStrings.add("Hola");
        arrayListStrings.add("adios");
        arrayListStrings.add("chau");
        arrayListStrings.add("good bye");

        LinkedList<String> linkedList = new LinkedList<>(arrayListStrings);

        for(int i = 0; i < arrayListStrings.size(); i++){

                System.out.println("ArrayList valor: " + arrayListStrings.get(i));
            System.out.println("LinkedList valor: " + linkedList.get(i));

        }

        //6 Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación,
            // con otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final.
            // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        ArrayList<Integer> arrayListInt = new ArrayList<>();

        for(int i = 1; i <= 10; i++){

            arrayListInt.add(i);

        }

        for(int i = 0; i < arrayListInt.size() - 1 ; i++){

            if((arrayListInt.get(i) % 2)==0){

                arrayListInt.remove(i);

            }

            System.out.println(arrayListInt.get(i));

        }

        //7 Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException
        //que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        //Finalmente, mostraremos en cualquier caso: "Demo de código".

        try{
            dividePorCero(0);
            System.out.println("Demo de código");
        } catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }

        //8 Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".

       copiarFichero("C:\\Users\\Emiliano Acevedo\\Documents\\prueba.txt", "C:\\Users\\Emiliano Acevedo\\Documents\\copia.txt" );

        //9
    }

    public static String reverse(String texto){

           String stringInvertido = "";

           for(int i= texto.length() - 1 ; i >= 0 ; i--){

               stringInvertido = stringInvertido + texto.charAt(i);

           }

           return stringInvertido;

    }

    public static void dividePorCero(int numero) throws ArithmeticException{

        try{
            int resultado = numero / 0;
        } catch (ArithmeticException e){
            throw(e);
        }

    }

    public static void copiarFichero(String fileIn, String fileOut){

        try{
            InputStream in = new FileInputStream(fileIn);
            byte[] datos = in.readAllBytes();

            PrintStream out = new PrintStream(fileOut);
            out.write(datos);

        } catch(Exception e){

            System.out.println(e.getMessage());

        }


    }


}