package progettino.dnd.projectDnd.model.mapper;

import org.mapstruct.Mapper;
import progettino.dnd.projectDnd.dtos.WeaponDto;
import progettino.dnd.projectDnd.model.entities.Weapon;


@Mapper(componentModel = "spring")
public interface WeaponMapper {

    Weapon toEntity(WeaponDto weaponDtoDto);

    WeaponDto toDto(Weapon weapon);
}
