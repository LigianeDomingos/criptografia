package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        return criptografar(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return descriptografar(texto, 3);
    }

    public String criptografar(String texto, int pos){
        return convertText(processText(texto), pos);
    }
    public String descriptografar(String texto, int pos){
        return convertText(processText(texto), pos* -1);
    }
    public String convertText(String text, int pos){
        String result = "";
        for (int i = 0; i < text.length();i++){
            result = result.concat(converLetter(text.charAt(i), pos));
        }
        return result;
    }
    public static String converLetter(char letter, int pos){
        String result = String.valueOf(letter);
        if (isAlpha(letter)){
            int newPos = (int) letter + pos;
            int lowerAlphaSize = (int) 'z' -(int) 'a';
            if(newPos > (int) 'z'){
                newPos = lowerAlphaSize - newPos + 1;
            } else if (newPos <(int) 'a'){
                newPos = lowerAlphaSize + newPos + 1;
            } result = String.valueOf((char) newPos);
        }
        return result;
    }
    public static boolean isLowercase(char letter){
        return (int)'a' <= (int) letter && (int) 'z' >= (int)letter;
    }
    public static boolean isUppercase(char letter){
        return (int)'A' <= (int) letter && (int) 'Z' >= (int)letter;
    }
    public static boolean isAlpha(char letter){
        return isLowercase(letter) || isUppercase(letter);
    }
    public static String processText(String texto){
        if (texto.isEmpty()) throw new IllegalArgumentException("Texto não encontrado");
        return texto.toLowerCase();
    }
}
