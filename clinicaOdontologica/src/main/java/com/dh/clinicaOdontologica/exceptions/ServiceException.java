package com.dh.clinicaOdontologica.exceptions;

import org.hibernate.HibernateException;

public class ServiceException extends HibernateException {
    public ServiceException(String message) {
        super(message);
    }
}
