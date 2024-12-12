package com.betrybe.trybetrack.services;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    public T createEntity(T entity);

    public Optional<T> updateEntity(Long id, T entity);

    public Optional<T> deleteEntity(Long id);

    public Optional<T> getEntityById(Long id);

    public List<T> getAllEntities();

}
