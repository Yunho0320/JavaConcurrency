package chapter0_introductions;

public class CPUExploration{
    public static void main(String[] args) {
        // This shows how many threads(processors) can run at the same time
        System.out.println("Available logical processors: " + Runtime.getRuntime().availableProcessors());

        // On Powershell I can type below to see my CPU spec
        // Get-WmiObject -class Win32_Processor | Select-Object -Property Name, NumberOfCores, NumberOfLogicalProcessors
    }
}
