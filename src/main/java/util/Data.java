package util;
import	java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Data implements Serializable{

    private static final long serialVersionUID = -5100326981001472885L;

    public int session;

    public int port;

    public int type;

    public byte b[];

    public int getSession() {
        return session;
    }

    public Data setSession(int session) {
        this.session = session;
        return this;
    }

    public int getPort() {
        return port;
    }

    public Data setPort(int port) {
        this.port = port;
        return this;

    }

    public int getType() {
        return type;
    }

    public Data setType(int type) {
        this.type = type;
        return this;
    }

    public byte[] getB() {
        return b;
    }

    public Data setB(byte[] b) {
        this.b = b;
        return this;

    }
}
