package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    private static final int MAXIMUM_LENGTH = 800;
    public static final String MESSAGE_CONSTRAINTS = "Addresses should not be blank or start with a space, "
            + "and it cannot exceed " + MAXIMUM_LENGTH + " characters";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].{0," + (MAXIMUM_LENGTH - 1) + "}";

    public final String address;

    /**
     * Constructs an {@code Address}.
     *
     * @param address A valid address.
     */
    public Address(String address) {
        requireNonNull(address);
        checkArgument(isValidAddress(address), MESSAGE_CONSTRAINTS);
        this.address = address;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return address;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && address.equalsIgnoreCase(((Address) other).address)); // state check
    }

    @Override
    public int hashCode() {
        return address.toLowerCase().hashCode();
    }

}
