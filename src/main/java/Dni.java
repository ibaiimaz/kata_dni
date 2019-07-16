import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Dni {

    private static final String VALID_DNI_PATTERN = "^[XYZ\\d]\\d{7}[^UIOÑ\\d]$";
    private static final String CONTROL_LETTER_MAP = "TRWAGMYFPDXBNJZSQVHLCKE";

    private String dni;

    public Dni(String dni) throws DomainException, InvalidArgumentException {
        checkIsValidDni(dni);

        Integer number = parseInt(dni.substring(0, dni.length() - 1));
        String letter = dni.substring(dni.length() - 1);

        Integer mod = number % 23;

        Map<Integer, String> map = new HashMap<>() {{
            put(0, "T");
            put(1, "R");
            put(2, "W");
        }};

        if (!letter.equals(String.valueOf(CONTROL_LETTER_MAP.charAt(mod)))) {
            throw new InvalidArgumentException("Invalid dni");
        }

        this.dni = dni;
    }

    @Override
    public String toString() {
        return dni;
    }

    private void checkIsValidDni(String dni) throws DomainException {
        if (!dni.matches(VALID_DNI_PATTERN)) {
            throw new DomainException("Bad format");
        }
    }
}
