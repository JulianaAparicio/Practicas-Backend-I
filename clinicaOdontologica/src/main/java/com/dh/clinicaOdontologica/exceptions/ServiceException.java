package com.dh.clinicaOdontologica.exceptions;

import org.hibernate.HibernateException;

public class ServiceException extends HibernateException {
    public ServiceException(String message, Throwable root) {
        super(message, root);
    }

    public ServiceException(String message) {
        super(message);
    }
}
