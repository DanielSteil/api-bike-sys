package br.com.lvds.BikeSys.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.model.Client;

public class ClientMapper {

    public static Client fromDTO(ClientDTO client) {
        return Client.builder()
                .id(client.getId())
                .name(client.getName())
                .number(client.getNumber())
                .bikesId(client.getBikesId())
                .createdAt(client.getCreatedAt())
                .updatedAt(client.getUpdatedAt())
                .active(client.getActive())
            .build();
    }    
    
    public static ClientDTO fromEntity(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .number(client.getNumber())
                .bikesId(client.getBikesId())
                .createdAt(client.getCreatedAt())
                .updatedAt(client.getUpdatedAt())
                .active(client.getActive())
            .build();
    }

    public static List<ClientDTO> fromEntities(List<Client> clients) {
        return clients.stream().map((client) -> fromEntity(client)).collect(Collectors.toList());
    }

}
