package com.mosofty.crm.dto;

public record UserView(
  Long id,

  String username,
  String fullName,
  String surname,
  String ufunction,
  String accessToken
) {

}
