package org.facosta.springsurbtcplots.utils.errors;

public class UserExistsException extends Exception
{
    public UserExistsException()
    {
        super("Username is already registered!");
    }
}
