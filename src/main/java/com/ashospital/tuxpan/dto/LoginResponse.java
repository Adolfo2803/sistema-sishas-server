package com.ashospital.tuxpan.dto;

public record LoginResponse( String token,
                             String rol,
                             String username) {
}
