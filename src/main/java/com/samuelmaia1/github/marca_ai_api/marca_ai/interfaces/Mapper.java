package com.samuelmaia1.github.marca_ai_api.marca_ai.interfaces;

public interface Mapper<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
}
