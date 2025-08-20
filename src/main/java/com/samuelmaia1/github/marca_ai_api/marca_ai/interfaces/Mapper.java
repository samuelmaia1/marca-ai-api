package com.samuelmaia1.github.marca_ai_api.marca_ai.interfaces;

public interface Mapper<E, RQ, RS> {
    RS toDto(E entity);
    E toEntity(RQ dto);
}
