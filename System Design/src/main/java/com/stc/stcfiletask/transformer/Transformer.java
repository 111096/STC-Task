package com.stc.stcfiletask.transformer;

public interface Transformer <E, D> {

        public E transformDtoToEntity(D dto);
        public D transformEntityToDto(E entity);

}
