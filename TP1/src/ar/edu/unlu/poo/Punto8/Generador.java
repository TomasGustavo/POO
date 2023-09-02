package ar.edu.unlu.poo.Punto8;
import java.security.SecureRandom;
public class Generador{

        private static final String LETRAS_MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
        private static final String DIGITOS = "01234567890123456789";
        private static final String CARACTERRES_ESPECIALES = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        private int longitud;
        private Contrasenia contrasenia;


        public Contrasenia generar(int longitud) {
            if (longitud < 8) {
                throw new IllegalArgumentException("La longitud mínima del password debe ser al menos 8 caracteres.");
            }
            this.longitud = longitud;
            this.contrasenia = generarContrasenias(longitud);
            return contrasenia;
        }


        public int getLongitud() {
            return longitud;
        }

        public void setLength(int longitud) {
            if (longitud < 8) {
                System.out.println("La longitud mínima del password debe ser al menos 8 caracteres.");
                //break;
            }
            this.longitud = longitud;
            this.contrasenia = generarContrasenias(longitud);
        }

        public boolean esFuerte(String contra) {
            int uppercaseCount = 0;
            int lowercaseCount = 0;
            int digitCount = 0;
            int specialCharacterCount = 0;

            for (char c : contra.toCharArray()) {
                if (LETRAS_MAYUSCULAS.contains(String.valueOf(c))) {
                    uppercaseCount++;
                } else if (LETRAS_MINUSCULAS.contains(String.valueOf(c))) {
                    lowercaseCount++;
                } else if (DIGITOS.contains(String.valueOf(c))) {
                    digitCount++;
                } else if (CARACTERRES_ESPECIALES.contains(String.valueOf(c))) {
                    specialCharacterCount++;
                }
            }
            boolean fuerte = uppercaseCount > 2 && lowercaseCount > 1 && digitCount >= 2;
            /*
            if(!fuerte){
                System.out.println("Contraseña debil, se regenara nuevamente.");
                contra = generarContrasenias(contra.length());
                fuerte = isStrongPassword(contra);
            }

             */
            return fuerte;
        }

        private Contrasenia generarContrasenias(int longi) {
            StringBuilder contra = new StringBuilder();
            SecureRandom random = new SecureRandom();
            Contrasenia actual = new Contrasenia();

            String caracteres = LETRAS_MAYUSCULAS + LETRAS_MINUSCULAS + DIGITOS;// + CARACTERRES_ESPECIALES;

            for (int i = 0; i < longi; i++) {
                int randomIndex = random.nextInt(caracteres.length());
                contra.append(caracteres.charAt(randomIndex));
            }
            actual.setContra(contra.toString());
            actual.setFuerte(esFuerte(contra.toString()));
            return actual;
        }
}
