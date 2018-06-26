package org.facosta.springsurbtcplots.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * Based on http://dolszewski.com/java/cross-field-validation/
 */

public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, Object>
{
    private String matches;
    private String baseField;

    @Override
    public void initialize(MatchPassword constraintAnnotation)
    {
        matches = constraintAnnotation.matches();
        baseField = constraintAnnotation.baseField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context)
    {
        Object password1, password2;
        try
        {
            password1 = getField(value, baseField);
            password2 = getField(value, matches);
            return password1.equals(password2);
        }catch (Exception e)
        {
            return false;
        }
    }

    private Object getField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException
    {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}
