package programAndVmArguments;

public class ProgramAndVmArguments {
	public static void main(String[] args) {
		
		String sysArg1=args[0];
		String sysArg2=args[1];
		
		String vmName=System.getProperty("x");
		String vmName2=System.getProperty("y");
		
		System.out.println("System Arguments");
		System.out.println("=================");
		System.out.println(sysArg1);
		System.out.println(sysArg2);
		
		
		System.out.println("VM Arguments");
		System.out.println("=================");
		System.out.println(vmName);
		System.out.println(vmName2);
		
		System.setProperty("x", sysArg1);
		System.setProperty("y", sysArg2);
		
		args[0]=vmName;
		args[1]=vmName2;
		
		System.out.println();
		System.out.println("System Arguments after swapping");
		System.out.println("=================");
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		
		System.out.println("VM Arguments after swapping");
		System.out.println("=================");
		System.out.println(System.getProperty("x"));
		System.out.println(System.getProperty("y"));
		
		
	}
	
	

}
