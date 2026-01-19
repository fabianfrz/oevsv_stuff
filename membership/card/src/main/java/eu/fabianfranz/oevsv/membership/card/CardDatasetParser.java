package eu.fabianfranz.oevsv.membership.card;

import java.net.URI;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Parser for the Membership card QR-Code.
 */
public class CardDatasetParser {
    // I don't get it why there are "l" characters in it when I look at it in the IDE for splitting,
    // shouldn't that be something like pipes
    private final Pattern pattern = Pattern.compile("(\\S+), (.*?) l Mitgliedsnummer: (\\d+) l ADL (\\d+) l (.*)");

    /**
     * Parse the card data.
     * @param data the string from the QR code
     * @return the parsed data or an empty optional if the data is not parsable.
     */
    public Optional<CardParsingResult> parse(String data) {
        if (data == null) {
            return Optional.empty();
        }
        var matcher = pattern.matcher(data);
        if (!matcher.find()) {
            return Optional.empty(); // string does not match
        }
        return Optional.of(new CardParsingResult(
            matcher.group(1),
            matcher.group(2),
            Integer.parseInt(matcher.group(3)),
            Integer.parseInt(matcher.group(4)),
            URI.create(matcher.group(5))));
    }
}
