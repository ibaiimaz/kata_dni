public class Dni {

    public Dni(String dni) throws LengthException {
        if (dni.length() > 9) {
            throw new LengthException("Too long");
        }
        throw new LengthException("Too short");
    }
}
