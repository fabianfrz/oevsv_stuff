package eu.fabianfranz.oevsv.membership.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDatasetParserTest {

    @Test
    void testParsingWorks() {
        CardDatasetParser parser = new CardDatasetParser();
        var result  = parser.parse(
                "OE0HQ, Headquater l Mitgliedsnummer: 00000 l ADL 000 l https://www.oevsv.at/card/00000")
            .orElseThrow();
        var result2 = parser.parse(
                "OE9LTX, Fabian Franz l Mitgliedsnummer: 90200308 l ADL 902 l https://www.oevsv.at/card/90200308")
            .orElseThrow();
        assertEquals("OE0HQ", result.callsign());
        assertEquals(0, result.membershipNumber());
        assertEquals(0, result.adl());
        assertEquals(902, result2.adl());
    }

}