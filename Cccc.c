#include <stdio.h>

/* Floats#
 * FahrenheitToCelsius is fahrenheit to celsius conversion using the formula
 * (degreesF - 32)* 5/9.
 */
float FahrenheitToCelsius(float fahrenheit) {
    return ((fahrenheit - 32.0) * 5.0)/9.0;
}

/* Floats#
 * CelsiusToFahrenheit is celsius to fahrenheit conversion using the formula
 * ((degreesC * 9.0)/5.0) + 32.0;
 */
float CelsiusToFahrenheit(float celsius) {
    return ((celsius * 9.0)/5.0 + 32.0);
}

/* Floats# Loops#
 * FtoCTable does fahrenheit to celsius conversion and outputs a table of a
 * user specified range. It also considers the difference between each value.
 * Input a 'c' for FahrenheitToCelsius conversion template and input a 'f'
 * for CelsiusToFahrenheit conversion.
 */
//void tableOutput(int upperRange, int lowerRange, int stepSize, char cORfConversion) {
//    switch (cORfConversion) { // FahrenheitToCelsius
//        case 'c':
//            for (float lower = lowerRange; lower <= upperRange; lower += stepSize) {
//                printf("%3f %6.3f\n", lower, FahrenheitToCelius(lower));
//            }
//            break;
//        case 'f': // CelsiusToFahrenheit
//            for (float lower = lowerRange; lower <= upperRange; lower += stepSize) {
//                printf("3f %6.3f\n", lower, CelsiusToFahrenheit(lower));
//            }
//            break;
//        default:
//            printf("Please write the correct inputs\n");
//    }
//}

int main()
{
    // FahrenheitToCelsius Tester
    printf("%.3f\n", FahrenheitToCelsius(400.0));
    printf("%.3f", CelsiusToFahrenheit(36.667));

    // tableOutput Tester
//    tableOutput(300, 0, 20, 'c');



}

