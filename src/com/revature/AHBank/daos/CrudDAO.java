package com.revature.AHBank.daos;

import com.revature.AHBank.util.List;
//// CRUD: Create, Read, Update, Delete
public interface CrudDAO<T> {

    T save(T newObj);
    List<T> findAll();
    T findById(String id);
    boolean update(T updatedObj);
    boolean removeById(String id);

}
