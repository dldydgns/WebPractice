package org.zerock.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

// DTO와 VO 상호 변환을 편하게 도와준다(ModelMapper)
public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil(){
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get(){
        return modelMapper;
    }
}
