package eu.fabianfranz.oevsv.membership.card;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

public record CardParsingResult(String callsign, String name, int membershipNumber, int adl, URI url)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
