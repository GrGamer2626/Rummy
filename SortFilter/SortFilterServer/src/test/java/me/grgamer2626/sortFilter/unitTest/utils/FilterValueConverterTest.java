package me.grgamer2626.sortFilter.unitTest.utils;

import me.grgamer2626.sortFilter.testUtils.TestEnum;
import me.grgamer2626.sortFilter.exception.InvalidFilterValueException;
import me.grgamer2626.sortFilter.utils.FilterValueConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


public class FilterValueConverterTest {

    private static final String PROPERTY = "property";

    @Test
    public void convert_rawValueIsNull() {
        //given
        Object rawValue = null;
        Class<?> targetType = String.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Assertions.assertNull(result);
    }

    @Test
    public void convert_rawValueIsString_targetTypeString() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = String.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        String expected = "Test";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsNotString_targetTypeString() {
        //given
        Object rawValue = 42;
        Class<?> targetType = String.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        String expected = "42";
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void convert_rawValueIsString_targetTypeLong() {
        //given
        Object rawValue = "42";
        Class<?> targetType = Long.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Long expected = 42L;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsNotNumberString_targetTypeLong() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = Long.class;

        //when
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convert_rawValueIsString_targetTypePrimitiveLong() {
        //given
        Object rawValue = "42";
        Class<?> targetType = long.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Long expected = 42L;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsOtherNumber_targetTypeLong() {
        //given
        Object rawValue = 5;
        Class<?> targetType = Long.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Long expected = 5L;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsLong_targetTypeLong() {
        //given
        Object rawValue = 5L;
        Class<?> targetType = Long.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Assertions.assertSame(rawValue, result);
    }

    @Test
    public void convert_rawValueIsDouble_targetTypeLong() {
        //given
        Object rawValue = 5.3d;
        Class<?> targetType = Long.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Long expected = 5L;
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void convert_rawValueIsString_targetTypeInteger() {
        //given
        Object rawValue = "7";
        Class<?> targetType = Integer.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Integer expected = 7;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsNotNumberString_targetTypeInteger() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = Integer.class;

        //when
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convert_rawValueIsString_targetTypePrimitiveInt() {
        //given
        Object rawValue = "7";
        Class<?> targetType = int.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Integer expected = 7;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsInteger_targetTypeInteger() {
        //given
        Object rawValue = 5;
        Class<?> targetType = Integer.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Assertions.assertSame(rawValue, result);
    }

    @Test
    public void convert_rawValueIsDouble_targetTypeInteger() {
        //given
        Object rawValue = 5.3;
        Class<?> targetType = Integer.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Integer expected = 5;
        Assertions.assertSame(expected, result);
    }

    @Test
    public void convert_rawValueIsOtherNumber_targetTypeInteger() {
        //given
        Object rawValue = 7L;
        Class<?> targetType = Integer.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Integer expected = 7;
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void convert_rawValueIsString_targetTypeDouble() {
        //given
        Object rawValue = "1.5";
        Class<?> targetType = Double.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Double expected = 1.5d;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsNotNumberString_targetTypeDouble() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = Double.class;

        //when
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convert_rawValueIsString_targetTypePrimitiveDouble() {
        //given
        Object rawValue = "1.5";
        Class<?> targetType = double.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        double expected = 1.5;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsOtherNumber_targetTypeDouble() {
        //given
        Object rawValue = 3;
        Class<?> targetType = Double.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Double expected = 3.0d;
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void convert_rawValueIsString_targetTypeBigDecimal() {
        //given
        Object rawValue = "10.25";
        Class<?> targetType = BigDecimal.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        BigDecimal expected = new BigDecimal("10.25");
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void convert_rawValueIsTrueString_targetTypeBoolean() {
        //given
        Object rawValue = "true";
        Class<?> targetType = Boolean.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsNotBooleanString_targetTypeBoolean() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = Boolean.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convert_rawValueIsBoolean_targetTypeBoolean() {
        //given
        Object rawValue = true;
        Class<?> targetType = Boolean.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Assertions.assertSame(rawValue, result);
    }

    @Test
    public void convert_rawValueIsFalseString_targetTypePrimitiveBoolean() {
        //given
        Object rawValue = "false";
        Class<?> targetType = boolean.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Boolean expected = false;
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void convert_rawValueIsIsoDateString_targetTypeLocalDate() {
        //given
        Object rawValue = "2026-11-05";
        Class<?> targetType = LocalDate.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        LocalDate expected = LocalDate.of(2026, 11, 5);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsMalformedDate_targetTypeLocalDate() {
        //given
        Object rawValue = "05-11-2026";
        Class<?> targetType = LocalDate.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }


    @Test
    public void convert_rawValueIsIsoDateTimeString_targetTypeLocalDateTime() {
        //given
        Object rawValue = "2026-11-05T14:30:00";
        Class<?> targetType = LocalDateTime.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        LocalDateTime expected = LocalDateTime.of(2026, 11, 5, 14, 30);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsInvalidString_targetTypeLocalDateTime() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = LocalDateTime.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class,
                () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }


    @Test
    public void convert_rawValueIsIsoInstantString_targetTypeInstant() {
        //given
        Object rawValue = "2026-11-05T14:30:00Z";
        Class<?> targetType = Instant.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Instant expected = Instant.parse("2026-11-05T14:30:00Z");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsInstantWithOffset_targetTypeInstant() {
        //given
        Object rawValue = "2026-11-05T15:30:00+01:00";
        Class<?> targetType = Instant.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        Instant expected = Instant.parse("2026-11-05T14:30:00Z");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsDateTimeWithoutZone_targetTypeInstant() {
        //given
        Object rawValue = "2026-11-05T14:30:00";
        Class<?> targetType = Instant.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convert_rawValueIsInvalidString_targetTypeInstant() {
        //given
        Object rawValue = "Test";
        Class<?> targetType = Instant.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }



    @Test
    public void convert_rawValueIsValidEnumName_targetTypeEnum() {
        //given
        Object rawValue = "VALUE_1";
        Class<?> targetType = TestEnum.class;

        //when
        Object result = FilterValueConverter.convert(rawValue, targetType, PROPERTY);

        //then
        TestEnum expected = TestEnum.VALUE_1;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void convert_rawValueIsInvalidEnumName_targetTypeEnum() {
        //given
        Object rawValue = "NOPE";
        Class<?> targetType = TestEnum.class;

        //when/then
        InvalidFilterValueException exception = Assertions.assertThrows(InvalidFilterValueException.class,
                () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
        Assertions.assertTrue(exception.getMessage().contains("NOPE"));
    }

    @Test
    public void convert_rawValueIsString_targetTypeUnsupported() {
        //given
        Object rawValue = "x";
        Class<?> targetType = Thread.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convert(rawValue, targetType, PROPERTY));
    }



    @Test
    public void convertCollection_rawValueIsListOfMixedValues_targetTypeLong() {
        //given
        Object rawValue = List.of("1", "2", 3);
        Class<?> targetType = Long.class;

        //when
        Collection<Object> result = FilterValueConverter.convertCollection(rawValue, targetType, PROPERTY);

        //then
        List<Long> expected = List.of(1L, 2L, 3L);
        Assertions.assertEquals(expected, List.copyOf(result));
    }

    @Test
    public void convertCollection_rawValueIsNull() {
        //given
        Object rawValue = null;
        Class<?> targetType = Long.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convertCollection(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convertCollection_rawValueIsNotCollection() {
        //given
        Object rawValue = "1,2,3";
        Class<?> targetType = Long.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convertCollection(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convertCollection_rawValueIsEmptyList() {
        //given
        Object rawValue = List.of();
        Class<?> targetType = Long.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convertCollection(rawValue, targetType, PROPERTY));
    }

    @Test
    public void convertCollection_rawValueContainsInvalidElement_targetTypeLong() {
        //given
        Object rawValue = List.of("1", "Test");
        Class<?> targetType = Long.class;

        //when/then
        Assertions.assertThrows(InvalidFilterValueException.class, () -> FilterValueConverter.convertCollection(rawValue, targetType, PROPERTY));
    }
}
