package com.itla.school.repository;

import java.util.List;

public interface CrudRepository<E, I> {

    E create(E entity);

    void update(E entity);

    void delete(E entity);

    E get(I id);

    List<E> getAll();
}
