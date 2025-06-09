package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Payment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PaymentDTO {
    private Integer id;

    @NotNull(message = "El id del usuario no puede estar vacio")
    private Integer userId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Instant paymentDate;

    @NotBlank(message = "El método de pago no puede estar vacio")
    @Size(max = 100, message = "El metodo de pago no puede superar los 100 caracteres")
    private String paymentMethod;

    @NotBlank(message = "La institución de pago no puede estar vacia")
    @Size(max = 200, message = "La institucion de pago no puede superar los 200 caracteres")
    private String paymentInstitution;

    @NotBlank(message = "La id de transacción no puede estar vacia")
    @Size(max = 100, message = "El id de la transaccion no puede superar los 100 caracteres")
    private String transactionId;

    @NotBlank(message = "El estado no puede estar vacio")
    @Size(max = 20, message = "El status no puede superar los 20 caracteres")
    private String status;

    public static PaymentDTO fromEntity(Payment entity) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(entity.getId());

        dto.setUserId(entity.getUser().getId());

        dto.setAmount(entity.getAmount());
        dto.setPaymentDate(entity.getPaymentDate());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPaymentInstitution(entity.getPaymentInstitution());
        dto.setTransactionId(entity.getTransactionId());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Payment toEntity() {
        Payment entity = new Payment();
        entity.setId(this.getId());

        User user = new User();
        user.setId(this.getUserId());
        entity.setUser(user);

        entity.setAmount(this.getAmount());
        entity.setPaymentDate(this.getPaymentDate());
        entity.setPaymentMethod(this.getPaymentMethod());
        entity.setPaymentInstitution(this.getPaymentInstitution());
        entity.setStatus(this.getStatus());
        return entity;
    }
}
