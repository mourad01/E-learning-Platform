package com.jobintech.elearningjobintech.tools;

import java.util.List;

public interface ServicesCRUD <T>{
    T saveOrUpdate(T t);
    T findById(Long id);

    Boolean delete(Long id);
    Boolean deleteAll();
    List<T> findAll();
}
