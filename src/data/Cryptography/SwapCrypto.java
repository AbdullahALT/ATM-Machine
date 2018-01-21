package data.Cryptography;

public class SwapCrypto implements Crypto<String> {

    String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String mirror = "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA9876543210";

    @Override
    public String encrypt(String data) {
        return converter(data, text, mirror);
    }

    @Override
    public String decrypt(String data) {
        return converter(data, mirror, text);
    }

    private String converter(String data, String from, String to){

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < data.length(); i++){

            char character = data.charAt(i);
            int index = from.indexOf(character);

            result.append((index == -1)? character : to.charAt(index));

        }

        return result.toString();
    }

}
