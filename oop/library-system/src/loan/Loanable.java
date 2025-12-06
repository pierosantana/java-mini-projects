package loan;

import exceptions.ResourceNotAvailableException;

public interface Loanable {

    /**
     * Loans the resource.
     * @throws ResourceNotAvailableException if the resource is already loaned.
     */
    void loan();

    /**
     * Returns the resource.
     * If the resource is not currently loaned, the method will simply mark it as available.
     */
    void returnResource();
}
