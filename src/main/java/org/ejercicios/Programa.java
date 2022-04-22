package org.ejercicios;


import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Programa {


    public static void main(String[] args) {

        System.out.println("Bienvenido al creador de archivos file.txt con datos de usuarios, a continuación \n" +
                            "debera insertar datos y seguir las opciones para crear el archivo o editar uno existente.");

        ArrayList<HashMap<String, String>> users = new ArrayList<>();

        users.add(createUser());

        boolean done = false;

        do {

            System.out.println("Desea agregar un otro usuario? Y/N");

            String response = new Scanner(System.in).nextLine();

            if (response.equalsIgnoreCase("Y")) {

                users.add(createUser());

            } else if (response.equalsIgnoreCase("N")) {

                done = true;

            } else {
                System.out.println("bad command");
            }

        } while(!done);

        StringBuilder data = new StringBuilder();

        boolean directoryCorrect = false;

        do {


            System.out.println("Desea agregar el texto a uno ya existente? Y/N");

            String directorio;

            if(new Scanner(System.in).nextLine().equalsIgnoreCase("Y")){

                System.out.println("Escriba el direccion del archivo terminado en .txt");

                directorio= new Scanner(System.in).nextLine();

            } else {

                System.out.println("Escriba el directorio donde crear el archivo, sin \\ al final");

                directorio = new Scanner(System.in).nextLine() + "\\";

                System.out.println("Escriba el nombre del archivo a crear");

                directorio = directorio + new Scanner(System.in).nextLine() + ".txt";

            }

            for (HashMap<String, String> e : users){

                data.append("Su nombre es ").append(e.get("name")).append(", tiene ").append(e.get("age")).append(" años y su pais es ").append(e.get("country")).append("\n");
            }

            byte[] dataByte = data.toString().getBytes(StandardCharsets.UTF_8);


                try {

                    PrintStream outPut = new PrintStream(directorio);

                    outPut.write(dataByte);

                    System.out.println("El texto con los datos se ha impreso satisfactoriamente");

                    directoryCorrect = true;

                } catch (Exception e) {

                    System.out.println("error: " + e.getMessage());

                }

            } while (!directoryCorrect);





    }

    public static HashMap<String, String> createUser(){

        boolean done = false;

        int age = 0;

        String name="";

        String country;

        HashMap<String, String> user = new HashMap<>();

        do {
            try {

                if(name.equals("")) {
                    System.out.println("Escriba su nombre:");
                    name = new Scanner(System.in).nextLine();
                    user.put("name", name);
                }
                if(age == 0){
                    System.out.println("Edad:");
                    age = new Scanner(System.in).nextInt();
                    user.put("age", Integer.toString(age));

                }

                System.out.println("Pais:");
                country = new Scanner(System.in).nextLine();
                user.put("country", country);

                done = true;

            } catch (Exception e) {

                System.out.println("Los campos son obligatorios y la edad debe ser en números");

            }
        } while (!done);

        return user;

    }

}
