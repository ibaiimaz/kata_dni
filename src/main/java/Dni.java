
public class Dni {

    public static final String VALID_DNI_PATTERN = "^[XYZ\\d]\\d{7}[^UIOÑ\\d]$";

    public Dni(String dni) throws DomainException, InvalidArgumentException {
        if (!dni.matches(VALID_DNI_PATTERN)) {
            throw new DomainException("Bad format");
        }

        throw new InvalidArgumentException("Invalid dni");
    }
}
