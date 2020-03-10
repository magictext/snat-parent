package config;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientConfig{

    private String serverAddress;

    private String ipv4LocalAddress;

    private String ipv6LocalAddress;

    private int port;

    private String Name;

    private List<ConfigEntity> list;
}
