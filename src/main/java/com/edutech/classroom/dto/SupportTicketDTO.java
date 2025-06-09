package com.edutech.classroom.dto;

import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class SupportTicketDTO {
    private Integer id;

    @NotNull(message = "El usuario no puede estar vacío")
    private Integer userId;

    private Integer supportUserId;

    @NotBlank(message = "El asunto no puede estar vacío")
    @Size(max = 200, message = "El asunto tiene un máximo de 200 caracteres")
    private String subject;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 800, message = "La descripción tiene un máximo de 800 caracteres")
    private String description;

    @NotBlank(message = "El estado no puede estar vacío")
    @Size(max = 20, message = "El estado tiene un máximo de 20 caracteres")
    private String status;

    @NotNull(message = "La fecha de creación no puede estar vacía")
    private Instant createdAt;

    private Instant closedAt;

    public static SupportTicketDTO fromEntity(SupportTicket entity){
        SupportTicketDTO dto = new SupportTicketDTO();
        dto.setId(entity.getId());
        //Objeto de nuevo
        dto.setUserId(entity.getUser().getId());
        //Objeto de nuevo
        dto.setSupportUserId(entity.getSupportUser().getId());
        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setClosedAt(entity.getClosedAt());
        return dto;
    }

    public SupportTicket toEntity(){
        SupportTicket entity = new SupportTicket();
        entity.setId(getId());
        // Creamos objeto
        User user = new User();
        user.setId(getUserId());
        entity.setUser(user);
        // Objeto para supportUser
        User supportUser = new User();
        supportUser.setId(getSupportUserId());
        entity.setSupportUser(supportUser);

        entity.setSubject(getSubject());
        entity.setDescription(getDescription());
        entity.setStatus(getStatus());
        entity.setCreatedAt(getCreatedAt());
        entity.setClosedAt(getClosedAt());
        return entity;
    }
}
