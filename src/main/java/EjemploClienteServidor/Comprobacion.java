package EjemploClienteServidor;

public class Comprobacion {

    public static boolean compruebaMensajeFarolas(String mensaje) throws NumberFormatException {

        mensaje = mensaje.replace("{", "");
        mensaje = mensaje.replace("}", "");

        String[] checkNumeroFarola = mensaje.split("farolaNumero:");

        if (checkNumeroFarola.length > 0) {

            String[] valoresFarola = checkNumeroFarola[1].split(", valor:");

            if (valoresFarola.length == 2) {

                Integer.parseInt(valoresFarola[0]);
                Integer.parseInt(valoresFarola[1]);

                return true;

            } else return false;

        } else return false;

    }

    public static boolean compruebaMensajeFarolasDeDany(String mensaje) {
        //farolaNumero:1, valor:1

        System.out.println(eliminaLlavesMensaje(mensaje));
        System.out.println(compruebaSubcadenaInicio(eliminaLlavesMensaje(mensaje)));

        String[] mensajePartido = eliminaLlavesMensaje(mensaje).split("farolaNumero:");
        System.out.println(compruebaSubcadenaFinal(mensajePartido));

        int CifrasTotal = mensajePartido[1].length() - 21;
        String[] mensajePartidoFinal = mensaje.split(", valor:");
        int CifrasFinal = mensajePartidoFinal[1].length();
        char[] cifrasFinal = mensajePartidoFinal[1].toCharArray();

        for (char caracter : cifrasFinal) {

            if (!Character.isDigit(caracter)) {

                return false;

            }
        }

        char[] mensajeFinal = mensajePartido[1].toCharArray();

        for (int i = 0; i <= mensajePartido.length - 8 - CifrasFinal; i++) {

            if (!Character.isDigit(mensajeFinal[i])) {

                return false;

            }

        }

        return true;

    }

    public static String eliminaLlavesMensaje(String mensaje) {

        mensaje = mensaje.replace("{", "");
        mensaje = mensaje.replace("}", "");

        return mensaje;
    }

    public static boolean compruebaSubcadenaInicio(String mensaje) {
        //farolaNumero:1, valor:1

        String mensajeSubCadenaComienzo = eliminaLlavesMensaje(mensaje).substring(0, 13);

        if (!mensajeSubCadenaComienzo.equals("farolaNumero:")) {

            return false;

        }else return true;

    }

    public static boolean compruebaSubcadenaFinal(String[] mensajePartido) {
        //farolaNumero:1, valor:1

        if (mensajePartido[1].isEmpty() || !mensajePartido[1].contains(", valor:")) {

            return false;

        } else return true;
    }
}




