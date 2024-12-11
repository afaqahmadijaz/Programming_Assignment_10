public class HourlyEmployee extends Employee
{
    // Private instance variables
    private double totalHoursWorked;
    private double totalRegularHours;
    private double totalOvertimeHours;

    // Constructor
    public HourlyEmployee(String firstName, String lastName, String SSN, double payRate)
    {
        super(firstName, lastName, SSN, payRate);
        this.totalHoursWorked = 0.0;
        this.totalRegularHours = 0.0;
        this.totalOvertimeHours = 0.0;
    }

    // Setter for total hours worked per week, called 4 times for 4 weeks
    public void setTotalHoursWorked(double hoursWorked)
    {
        // Accumulate total hours
        this.totalHoursWorked += hoursWorked;

        // Calculate how much is regular and how much is overtime from this week's hours
        if (hoursWorked <= 40)
        {
            this.totalRegularHours += hoursWorked;
        }
        else
        {
            this.totalRegularHours += 40;
            this.totalOvertimeHours += (hoursWorked - 40);
        }
    }

    // Getters
    public double getTotalRegularHours()
    {
        return this.totalRegularHours;
    }

    public double getTotalOvertimeHours()
    {
        return this.totalOvertimeHours;
    }

    // Monthly Regular Pay
    public double getMonthlyRegularPay()
    {
        return getTotalRegularHours() * getPayRate();
    }

    // Monthly Overtime Pay
    public double getMonthlyOvertimePay()
    {
        return getTotalOvertimeHours() * getPayRate() * 1.5;
    }

    // Monthly Gross Pay
    public double getMonthlyGrossPay()
    {
        return getMonthlyRegularPay() + getMonthlyOvertimePay();
    }

    // Compute Monthly Taxes based on the gross pay and the provided tax table
    public double getMonthlyTaxes()
    {
        double gross = getMonthlyGrossPay();
        double taxRate = 0.0;

        if (gross > 15000.00)
            taxRate = 0.36;
        else if (gross > 10000.00)
            taxRate = 0.31;
        else if (gross > 8000.00)
            taxRate = 0.28;
        else if (gross > 4500.00)
            taxRate = 0.22;
        else if (gross > 2500.00)
            taxRate = 0.15;
        else if (gross > 1200.00)
            taxRate = 0.10;
        else
            taxRate = 0.00;

        return gross * taxRate;
    }

    // Monthly Net Pay
    public double getMonthlyNetPay()
    {
        return getMonthlyGrossPay() - getMonthlyTaxes();
    }

    @Override
    public String toString()
    {
        return String.format("%s%n" +
                        "Total Regular Hours Worked: %.2f%n" +
                        "Total Overtime Hours Worked: %.2f%n" +
                        "Total Hours Worked: %.2f%n" +
                        "Monthly Regular Pay: $%.2f%n" +
                        "Monthly Overtime Pay: $%.2f%n" +
                        "Monthly Gross Pay: $%.2f%n" +
                        "Monthly Taxes: $%.2f%n" +
                        "Monthly Net Pay: $%.2f%n",
                super.toString(),
                getTotalRegularHours(),
                getTotalOvertimeHours(),
                this.totalHoursWorked,
                getMonthlyRegularPay(),
                getMonthlyOvertimePay(),
                getMonthlyGrossPay(),
                getMonthlyTaxes(),
                getMonthlyNetPay());
    }
}