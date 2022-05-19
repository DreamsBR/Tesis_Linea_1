package com.lineauno.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
public class UsuarioDTO {

    private String nombre;
    private String nombres;
    private String numeroDocumento;
    private String apellidoPaterno;
    private String apellidoMaterno;

}
