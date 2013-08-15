package com.rms.rest.health;

import com.yammer.metrics.core.HealthCheck;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;


public class MemoryHealthCheck extends HealthCheck {
    private final double memoryFloor;

    public MemoryHealthCheck(double memoryFloor) {
        super("memoryFloor");
        this.memoryFloor = memoryFloor;
    }

    @Override
    protected Result check() throws Exception {
    
    	Mem mem = new Sigar().getMem();
    	
    	double freeMem = (mem.getActualFree()/1024/1000000);
    	double usedMem = (mem.getActualUsed()/1024)/1000000;
    	double totalMem = (mem.getTotal()/1024)/1000000;
    	
            //Print free memory
    	    System.out.println("\n");
    	    System.out.println("****************");
            System.out.println("Total Memory: "
                + totalMem + " GB");
            System.out.println("Used Memory: "
                    + usedMem + " GB");
            System.out.println("Free Memory: "
                    + freeMem + " GB");
            System.out.println("MemFloor: "
                    + memoryFloor + " GB");
            System.out.println("****************\n");
            
            
       
        if ( freeMem < memoryFloor) {
            return Result.unhealthy("* FAILURE: Memory usage critical. Free memory: " +
            		freeMem+ " GB");
        }
        return Result.healthy("* PASS: Memory usage nominal. Free memory: " +
        		freeMem + " GB");
    }
}
