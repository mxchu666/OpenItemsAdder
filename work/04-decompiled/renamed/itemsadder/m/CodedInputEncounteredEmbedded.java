package itemsadder.m;

import itemsadder.m.IOError;

public class CodedInputEncounteredEmbedded
extends IOError {
    private static final long serialVersionUID = 1616151763072450476L;
    private static final String aFA = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.";

    public CodedInputEncounteredEmbedded(String string) {
        super(string);
    }

    public CodedInputEncounteredEmbedded(String string, Throwable throwable) {
        super(string, throwable);
    }

    static CodedInputEncounteredEmbedded b(Throwable throwable) {
        return new CodedInputEncounteredEmbedded(aFA, throwable);
    }

    static CodedInputEncounteredEmbedded Gi() {
        return new CodedInputEncounteredEmbedded(aFA);
    }

    static CodedInputEncounteredEmbedded Gj() {
        return new CodedInputEncounteredEmbedded("CodedInput encountered an embedded string or bytes that misreported its size.");
    }

    static CodedInputEncounteredEmbedded Gk() {
        return new CodedInputEncounteredEmbedded("CodedInput encountered an embedded string or message which claimed to have negative size.");
    }

    static CodedInputEncounteredEmbedded Gl() {
        return new CodedInputEncounteredEmbedded("CodedInput encountered a malformed varint.");
    }

    static CodedInputEncounteredEmbedded Gm() {
        return new CodedInputEncounteredEmbedded("Protocol message contained an invalid tag (zero).");
    }

    static CodedInputEncounteredEmbedded Gn() {
        return new CodedInputEncounteredEmbedded("Protocol message end-group tag did not match expected tag.");
    }

    static CodedInputEncounteredEmbedded Go() {
        return new CodedInputEncounteredEmbedded("Protocol message tag had invalid wire type.");
    }

    static CodedInputEncounteredEmbedded Gp() {
        return new CodedInputEncounteredEmbedded("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInput.setRecursionLimit() to increase the depth limit.");
    }

    static CodedInputEncounteredEmbedded Gq() {
        return new CodedInputEncounteredEmbedded("Protocol message was too large.  May be malicious.  Use CodedInput.setSizeLimit() to increase the size limit.");
    }
}
