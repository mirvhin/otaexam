package com.ota.exam.exceptions;

public class NotFoundException extends ApplicationException {
	public NotFoundException() {
        super("Entity not found!");
    }
}
