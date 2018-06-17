package ru.saleman.manager.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import ru.saleman.data.dto.MicrosystemDto;
import ru.saleman.manager.vo.MicrosystemVo;

/**
 * Created by Ivan Timofeev on 17.06.2018.
 */
@Component
public class MicrosystemDtoVoConverter extends AbstractConverter<MicrosystemDto, MicrosystemVo> {
    @Override
    protected MicrosystemVo convert(MicrosystemDto microsystemDto) {
        MicrosystemVo microsystemVo = new MicrosystemVo();
        microsystemVo.setId(microsystemDto.getId());
        microsystemVo.setName(microsystemDto.getName());
        return microsystemVo;
    }
}
