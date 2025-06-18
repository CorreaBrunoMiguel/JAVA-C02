package dev.correa.springbootsuperheroes.antiHero.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Author: Bruno Miguel Correa
 * Email: devsistemascorrea@gmail.com
 * Data: 18/06/2025
 **/

@Getter
@Setter
public class AntiHeroDto {
 private UUID id;
 @NotNull(message = "First Name is required")
 private String firstName;
 private String lastName;
 private String house;
 private String knowAs;
}
