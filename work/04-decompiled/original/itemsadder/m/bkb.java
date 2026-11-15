package itemsadder.m;

import itemsadder.m.bkg;

public class bkb
extends bkg {
    private static final long serialVersionUID = 1616151763072450476L;
    private static final String aFA = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.";

    public bkb(String string) {
        super(string);
    }

    public bkb(String string, Throwable throwable) {
        super(string, throwable);
    }

    static bkb b(Throwable throwable) {
        return new bkb(aFA, throwable);
    }

    static bkb Gi() {
        return new bkb(aFA);
    }

    static bkb Gj() {
        return new bkb("CodedInput encountered an embedded string or bytes that misreported its size.");
    }

    static bkb Gk() {
        return new bkb("CodedInput encountered an embedded string or message which claimed to have negative size.");
    }

    static bkb Gl() {
        return new bkb("CodedInput encountered a malformed varint.");
    }

    static bkb Gm() {
        return new bkb("Protocol message contained an invalid tag (zero).");
    }

    static bkb Gn() {
        return new bkb("Protocol message end-group tag did not match expected tag.");
    }

    static bkb Go() {
        return new bkb("Protocol message tag had invalid wire type.");
    }

    static bkb Gp() {
        return new bkb("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInput.setRecursionLimit() to increase the depth limit.");
    }

    static bkb Gq() {
        return new bkb("Protocol message was too large.  May be malicious.  Use CodedInput.setSizeLimit() to increase the size limit.");
    }
}
