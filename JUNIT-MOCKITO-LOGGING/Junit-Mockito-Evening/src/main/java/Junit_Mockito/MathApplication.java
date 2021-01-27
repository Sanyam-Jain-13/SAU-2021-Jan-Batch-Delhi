package Junit_Mockito;

public class MathApplication {

    private CalculatorService calcService;

    public void setCalService(CalculatorService calcService)
    {
        this.calcService = calcService;
    }

    public double add(double ip1, double ip2)
    {
        return calcService.add(ip1,ip2);
    }

    public double subtract(double ip1, double ip2)
    {
        return calcService.subtract(ip1,ip2);
    }

    public double multiply(double ip1, double ip2)
    {
        return calcService.multiply(ip1,ip2);
    }

    public double divide(double ip1, double ip2)
    {
        return calcService.divide(ip1, ip2);
    }
}
