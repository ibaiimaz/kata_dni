
public class Dni {

    public static final int VALID_LENGTH = 9;

    public Dni(String dni) throws LengthException, DomainException {
        checkDniHasValidLength(dni);

        if (dni.matches("^.*\\d$")) {
            throw new DomainException("Ends with number");
        }

        if (dni.matches("^.*[UIOÑ]$")) {
            throw new DomainException("Ends with invalid letter");
        }

        if (!dni.matches("^.\\d{7}.$")) {
            throw new DomainException("Has letters in the middle\"");
        }

        throw new DomainException("Starts with invalid letter");
    }

    private void checkDniHasValidLength(String dni) throws LengthException {
        if (dni.length() != VALID_LENGTH) {
            throw new LengthException("Invalid length");
        }
    }
}
