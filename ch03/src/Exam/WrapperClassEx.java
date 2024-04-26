package src.Exam;

// Wrapper Class 인스턴스 생성 예제
public class WrapperClassEx {
    public static void main(String[] args) {
        // Boxing
        Byte maxByte = Byte.MAX_VALUE;
        Short maxShort = Short.MAX_VALUE;
        Integer maxInteger = Integer.MAX_VALUE;
        Long maxLong = Long.MAX_VALUE;
        Float maxFloat = Float.MAX_VALUE;
        Double maxDouble = Double.MAX_VALUE;
        Character maxChar = Character.MAX_VALUE;
        Boolean trueValue = Boolean.TRUE;

        System.out.println("Byte max value: " + maxByte);
        System.out.println("Short max value: " + maxShort);
        System.out.println("Integer max value: " + maxInteger);
        System.out.println("Long max value: " + maxLong);
        System.out.println("Float max value: " + maxFloat);
        System.out.println("Double max value: " + maxDouble);
        System.out.println("Character max value (Unicode): " + (int) maxChar);
        System.out.println("Boolean true value: " + trueValue);

        // Unboxing
        byte unboxedByte = maxByte;
        short unboxedShort = maxShort;
        int unboxedInteger = maxInteger;
        long unboxedLong = maxLong;
        float unboxedFloat = maxFloat;
        double unboxedDouble = maxDouble;
        char unboxedChar = maxChar;
        boolean unboxedBoolean = trueValue;

        System.out.println("Unboxed byte value: " + unboxedByte);
        System.out.println("Unboxed short value: " + unboxedShort);
        System.out.println("Unboxed integer value: " + unboxedInteger);
        System.out.println("Unboxed long value: " + unboxedLong);
        System.out.println("Unboxed float value: " + unboxedFloat);
        System.out.println("Unboxed double value: " + unboxedDouble);
        System.out.println("Unboxed character value: " + (int) unboxedChar); // 유니코드 값으로 출력
        System.out.println("Unboxed boolean value: " + unboxedBoolean);
    }
}