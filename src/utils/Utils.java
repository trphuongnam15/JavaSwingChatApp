package utils;

public class Utils {
    public static getRandomNumber(int min, int max) {
        int port = (int)Math.floor(Math.random()*(max - min + 1) + min);
        PORT = port;
        return port;
    }
}
