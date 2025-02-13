package br.com.johnswallet.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;

public abstract class DefaultCrudService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> list() {
        return getRepository().findAll();
    }

    public T get(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Transactional
    public T save(T entity) {
        beforeSave(entity);

        entity = getRepository().save(entity);

        afterSave(entity);

        return entity;
    }

    protected void beforeSave(T entity) { }

    protected void afterSave(T entity) { }

    @Transactional
    public T update(ID id, T updatedEntity) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        }

        updatedEntity = getEntity(updatedEntity, id);

        beforeUpdate(updatedEntity);

        updatedEntity = getRepository().save(updatedEntity);

        afterUpdate(updatedEntity);

        return updatedEntity;
    }

    protected void beforeUpdate(T entity) { }

    protected void afterUpdate(T entity) { }

    @Transactional
    public void delete(ID id) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        }

        T entity = get(id);

        beforeDelete(entity);

        getRepository().deleteById(id);

        afterDelete(entity);
    }

    protected void beforeDelete(T entity) { }

    protected void afterDelete(T entity) { }

    protected T getEntity(T entity, ID id) {
        try {
            Field field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(entity, id);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter entidade " + entity.getClass().getSimpleName(), e);
        }
    }

}
