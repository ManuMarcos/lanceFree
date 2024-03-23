package com.manumarcos.lanceFree.Service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUsuarioDto {

    private Long id;
    private String email;
    private Date createdAt;
}
