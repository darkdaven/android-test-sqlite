package com.itla.testappdb.repository;

import java.util.List;

public interface CrudRepository<E> {

    public E create(E entity);
    public void update(E entity);
    public void delete(E entity);
    public E get();
    public List<E> getAll();
}
