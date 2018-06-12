package ru.saleman.rest.ro.transformer;

import ru.saleman.data.dto.AbstractDto;
import ru.saleman.rest.ro.AbstractRo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */

public abstract class RoDtoAbstractTransformer<RO extends AbstractRo, DTO extends AbstractDto> {

    abstract RO toRo(DTO dto);

    abstract DTO toDto(RO ro);

    abstract RO createRo();

    abstract DTO createDto();

    public List<RO> toRoList(List<DTO> dtoList) {
        return dtoList.stream().map(dto -> toRo(dto)).collect(Collectors.toList());
    }

    public List<DTO> toDtoList(List<RO> roList) {
        return roList.stream().map(ro -> toDto(ro)).collect(Collectors.toList());
    }

}
