public class Dni {

    public static final int VALID_LENGTH = 9;

    public Dni(String dni) throws LengthException, DomainException {
        checkDniHasValidLength(dni);

        throw new DomainException("Ends with number");
    }

    private void checkDniHasValidLength(String dni) throws LengthException {
        if (dni.length() != VALID_LENGTH) {
            throw new LengthException("Invalid length");
        }
    }
}
