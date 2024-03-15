package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.UsersRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersRequestDto toDto(UsersMapper usersMapper);

    UsersMapper toEntity(UsersRequestDto usersDto);
}
